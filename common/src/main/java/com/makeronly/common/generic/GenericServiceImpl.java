package com.makeronly.common.generic;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.makeronly.common.exception.NullMapperException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 泛型抽象Service实现类
 *
 * @author Walter Wong
 */
@Transactional(readOnly = true)
public abstract class GenericServiceImpl<T, ID> implements GenericService<T, ID> {
    private static final Logger log = LoggerFactory.getLogger(GenericServiceImpl.class);

    /**
     * 返回对应的Mapper对象
     *
     * @return 对应Mapper对象
     */
    protected abstract GenericMapper<T, ID> init();

    private GenericMapper<T, ID> getMapper() {
        GenericMapper<T, ID> gm = init();
        if (gm == null) {
            log.error("没有指定Mapper，无法操作数据库，请检查init()方法，确保返回GenericMapper");
            throw new NullMapperException("没有指定Mapper，无法操作数据库，请检查init()方法，确保返回GenericMapper");
        }
        return gm;
    }

    /**
     * 获取对象
     *
     * @param id 象唯一标识
     * @return 返回指定对象
     */
    @Override
    public T get(ID id) {
        return this.getMapper().get(id);
    }

    /**
     * 保存
     *
     * @param t 保存对象
     * @return 若成功则返回1
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public T save(T t) {
        this.getMapper().save(t);
        return t;
    }

    /**
     * 删除
     *
     * @param id 对象唯一标识
     * @return 若成功则返回1
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer delete(ID id) {
        return this.getMapper().delete(id);
    }

    /**
     * 更新
     *
     * @param t 更新对象
     * @return 若成功则返回1
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public T update(T t) {
        this.getMapper().update(t);
        return t;
    }

    /**
     * 批量删除
     *
     * @param ids id集合
     * @return 删除记录数量
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer deleteMulti(List<ID> ids) {
        return this.getMapper().deleteMulti(ids);
    }

    /**
     * 分页(不支持数据过滤)
     *
     * @return 分页集合
     */
    @Override
    public PageInfo<T> getPage(Integer pageNum, Integer pageSize) {
        return getPageInfo(pageNum, pageSize, null);
    }

    /**
     * 分页(支持过滤数据)
     *
     * @param param 分页条件，用于过滤数据
     * @return 分页集合
     */
    @Override
    public PageInfo<T> getPage(Integer pageNum, Integer pageSize, Map<String, ?> param) {
        return getPageInfo(pageNum, pageSize, param);
    }

    private PageInfo<T> getPageInfo(Integer pageNum, Integer pageSize, Map<String, ?> param) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(this.getMapper().getPage(param));
    }
}
