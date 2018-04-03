package com.makeronly.rbac.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import lombok.Data;

import javax.ws.rs.FormParam;
import java.io.Serializable;

/**
 * 角色
 * @author Walter Wong
 */
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = -3287128294264034193L;

    // 将Long类型转换成String，防止前台出现精度丢失的问题
    @JSONField(serializeUsing = ToStringSerializer.class)
    @FormParam("id")
    private Long id;
    @FormParam("name")
    private String name;
    @FormParam("description")
    private String description;
    public Role() {
    }

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
