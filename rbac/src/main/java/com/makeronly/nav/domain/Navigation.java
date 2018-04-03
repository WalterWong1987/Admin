package com.makeronly.nav.domain;

import lombok.Data;

import javax.ws.rs.FormParam;
import java.io.Serializable;

/**
 * 导航(菜单)
 * @author Walter Wong
 */
@Data
public class Navigation implements Serializable {
    private static final long serialVersionUID = -8996042856651297751L;
    //编号
    @FormParam("id")
    private Long id;
    //导航名称
    @FormParam("name")
    private String name;
    //导航地址
    @FormParam("url")
    private String url;
    //上级编号
    @FormParam("pid")
    private String pid;

    public Navigation() {
    }

    public Navigation(Long id, String name, String url, String pid) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.pid = pid;
    }
}
