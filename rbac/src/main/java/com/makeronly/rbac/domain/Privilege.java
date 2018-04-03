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
public class Privilege implements Serializable{
    private static final long serialVersionUID = -8913534022059668245L;

    // 将Long类型转换成String，防止前台出现精度丢失的问题
    @JSONField(serializeUsing = ToStringSerializer.class)
    @FormParam("id")
    private Long id;
    @FormParam("type")
    private Integer type;

    public Privilege(){}

    public Privilege(Long id, Integer type) {
        this.id = id;
        this.type = type;
    }
}
