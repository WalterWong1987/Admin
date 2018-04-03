package com.makeronly.user.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Walter Wong
 */
@Data
public class Account implements Serializable{
    private static final long serialVersionUID = -579933597733762432L;

    private Long id;
    /**
     * 用户编码
     */
    // 将Long类型转换成String，防止前台出现精度丢失的问题
    @JSONField(serializeUsing = ToStringSerializer.class)
    private Long userId;
    /**
     * 登录类型（手机号 邮箱 用户名）或第三方应用名称（微信 微博等）
     * 用户名:1
     * 手机:2
     * 邮箱:3
     * 微信:4
     * QQ:5
     * 微博:6
     */
    private int type;
    /**
     * 标识（手机号 邮箱 用户名或第三方应用的唯一标识）
     */
    private String identifier;
    /**
     * 密码凭证（站内的保存密码，站外的不保存或保存token）
     */
    private String credential;

    private User profile;

    public Account() {
    }

    public Account(Long id, Long userId, int type, String identifier, String credential) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.identifier = identifier;
        this.credential = credential;
    }
    public Account(Long userId, int type, String identifier, String credential) {
        this.userId = userId;
        this.type = type;
        this.identifier = identifier;
        this.credential = credential;
    }
}
