package com.makeronly.common.generic;

import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.Map;

/**
 * 泛型Service接口
 * @author Walter Wong
 */
public interface GenericService<T,ID> {
    /**
     * 持久化对象
     * @param obj   持久化前的对象
     * @return  持久化后的对象
     */
    T save(T obj);

    /**
     * 删除
     * @param id    唯一标识
     * @return  成功则返回1
     */
    Integer delete(ID id);

    /**
     * 更新
     * @param obj   更新对象
     * @return  更新后的对象
     */
    T update(T obj);

    /**
     * 根据唯一标识获取T对象
     * @param id    唯一标识
     * @return  T对象
     */
    T get(ID id);

    /**
     * 批量删除
     * @param ids   id集合
     * @return 删除记录数量
     */
    Integer deleteMulti(List<ID> ids);

    /**
     * 分页(支持过滤数据)
     * @param param 分页条件，用于过滤数据
     * @return  分页集合
     */
    PageInfo<T> getPage(Integer pageNum, Integer pageSize, Map<String, ?> param);

    /**
     * 分页(不支持数据过滤)
     * @return  分页集合
     */
    PageInfo<T> getPage(Integer pageNum, Integer pageSize);
}
