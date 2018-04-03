package com.makeronly.common.generic;

import java.util.List;
import java.util.Map;

/**
 * Generic mapper interface
 * @author Walter Wong
 */
public interface GenericMapper<T,ID> {
    /**
     * 保存
     * @param t  保存对象
     * @return  若成功则返回1
     */
    Integer save(T t);

    /**
     * 删除
     * @param id    对象唯一标识
     * @return      若成功则返回1
     */
    Integer delete(ID id);

    /**
     * 更新
     * @param t  更新对象
     * @return   若成功则返回1
     */
    Integer update(T t);

    /**
     * 获取对象
     * @param id    象唯一标识
     * @return      返回指定对象
     */
    T get(ID id);

    /**
     * 批量删除
     * @param ids   id集合
     * @return Integer
     */
    Integer deleteMulti(List<ID> ids);

    /**
     * 分页
     * @param param 分页条件，用于过滤数据
     * @return  分页集合
     */
    List<T> getPage(Map<String, ?> param);

}
