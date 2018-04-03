package com.makeronly.common.resource;

import com.github.pagehelper.PageInfo;
import com.makeronly.common.bean.ResultBean;
import com.makeronly.common.generic.GenericService;
import org.springframework.util.Assert;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Walter Wong
 */
public abstract class AbstractResource<T, ID> {
    //JSON类型编码
    protected final String APPLICATION_JSON = MediaType.APPLICATION_JSON + ";charset=UTF-8";
    //APPLICATION_FORM_URLENCODED类型编码
    protected final String APPLICATION_FORM_URLENCODED = MediaType.APPLICATION_FORM_URLENCODED;

    /**
     * 初始化Service
     *
     * @return 指定Service
     */
    protected abstract GenericService<T, ID> handleService();

    /**
     * 获取对象信息
     *
     * @param id 唯一标识
     * @return 对象信息
     */
    protected ResultBean<T> get(ID id) {
        Assert.notNull(id, "The primary key is empty,");
        return new ResultBean<>(handleService().get(id));
    }

    /**
     * 修改对象信息
     *
     * @param t 修改前的对象
     * @return 修改后的对象
     */
    protected ResultBean<T> update(T t) {
        Assert.notNull(t, "Can not update a null object");
        return new ResultBean<>(handleService().update(t));
    }

    /**
     * 删除对象
     *
     * @param id 唯一标识
     * @return 成功返回true，失败返回false
     */
    protected ResultBean<Boolean> delete(ID id) {
        Assert.notNull(id, "The primary key is empty");
        return new ResultBean<>(handleService().delete(id) >= 1);
    }

    /**
     * 批量删除
     *
     * @param ids 唯一标识集合
     * @return 删除记录数
     */
    public ResultBean<Integer> deleteMulti(List<ID> ids) {
        return new ResultBean<>(handleService().deleteMulti(ids));
    }

    /**
     * 保存对象
     *
     * @param t 对象实体
     * @return 保存后的对象
     */
    protected ResultBean<T> save(T t) {
        Assert.notNull(t, "Can not persist a null object");
        return new ResultBean<>(handleService().save(t));
    }

    /**
     * 获取分页信息
     *
     * @param pageNum  当前页码
     * @param pageSize 分页大小
     * @param param    数据过滤条件
     * @return 分页信息
     */
    protected ResultBean<PageInfo<T>> getPage(Integer pageNum, Integer pageSize, Map<String, ?> param) {
        if (pageNum == null) {
            pageNum = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }

        return new ResultBean<>(handleService().getPage(pageNum, pageSize, param));
    }

    /**
     * 获取分页信息(不支持数据过滤)
     *
     * @param pageNum  当前页码
     * @param pageSize 分页大小
     * @return 分页信息
     */
    protected ResultBean<PageInfo<T>> getPage(Integer pageNum, Integer pageSize) {
        return getPage(pageNum, pageSize, null);
    }

    /**
     * 获取查询参数
     * <p>
     *     只能获取QueryParam中的参数。且QueryParam中参数的value值建议是基本类型，不推荐使用集合类型。若value值为集合类型，则只取集合中下标为0的成员
     * </p>
     * @see javax.ws.rs.QueryParam
     * @param param MultivaluedMap类型的参数集合
     * @return  Map
     */
    protected Map<String, String> getQueryParam(MultivaluedMap<String, String> param) {
        Map<String, String> map = new HashMap<>();
        for (Map.Entry<String, List<String>> e : param.entrySet()) {
            map.put(e.getKey(), e.getValue().get(0));
        }
        return map;
    }

    /**
     * 获取查询参数
     * <p>
     *     只能获取QueryParam中的参数。且QueryParam中参数的value值建议是基本类型，不推荐使用集合类型。若value值为集合类型，则只取集合中下标为0的成员
     * </p>
     * @param uriInfo   URI信息
     * @return  Map
     */
    protected Map<String, String> getQueryParam(UriInfo uriInfo) {
        return getQueryParam(uriInfo.getQueryParameters());
    }
}
