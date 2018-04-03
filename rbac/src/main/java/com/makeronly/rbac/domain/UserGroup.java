package com.makeronly.rbac.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import lombok.Data;

import javax.ws.rs.FormParam;
import java.io.Serializable;

/**
 * @author Walter Wong
 */
@Data
public class UserGroup implements Serializable {
    private static final long serialVersionUID = -7460362524736347186L;

    // 将Long类型转换成String，防止前台出现精度丢失的问题
    @JSONField(serializeUsing = ToStringSerializer.class)
    @FormParam("id")
    private Long id;
    @FormParam("name")
    private String name;

    public UserGroup(){}

    public UserGroup(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
