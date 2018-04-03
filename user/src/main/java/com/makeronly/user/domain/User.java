package com.makeronly.user.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import lombok.Data;
import javax.ws.rs.FormParam;
import java.io.Serializable;

/**
 * @author Walter Wong
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -6308055729212523806L;

    // 将Long类型转换成String，防止前台出现精度丢失的问题
    @JSONField(serializeUsing = ToStringSerializer.class)
    @FormParam("id")
    private Long id;
    /**
     * 姓名
     */
    @FormParam("name")
    private String name;
    /**
     * 昵称
     */
    @FormParam("nickname")
    private String nickname;
    /**
     * 性别
     */

    private int gender;
    /**
     * 邮箱
     */
    @FormParam("email")
    private String email;
    /**
     * 手机号
     */
    @FormParam("phone")
    private String phone;
    /**
     * 头像
     */
    @FormParam("avatar")
    private String avatar;

    public User() {
    }
}
