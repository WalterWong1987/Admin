package com.makeronly.user.resource;

import com.github.pagehelper.PageInfo;
import com.makeronly.common.bean.ResultBean;
import com.makeronly.common.generic.GenericService;
import com.makeronly.common.resource.AbstractResource;
import com.makeronly.common.snowflake.IdGenerator;
import com.makeronly.user.domain.User;
import com.makeronly.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User resource
 * @author Walter Wong
 */
@Component
@Path("/user")
public class UserResource extends AbstractResource<User,Long> {
    private static final Logger log = LoggerFactory.getLogger(UserResource.class);

    @Resource(name = "user.userService")
    private UserService service;


    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public ResultBean<User> get(@PathParam("id")Long id){
        return super.get(id);
    }

    /**
     * 获取分页
     * @param pageNum  当前页码
     * @param pageSize 分页大小
     * @return  分页信息
     */
    @GET
    @Path("/{pageNum}/{pageSize}")
    @Produces(APPLICATION_JSON)
    public ResultBean<PageInfo<User>> getPage(@PathParam("pageNum") Integer pageNum, @PathParam("pageSize") Integer pageSize, @Context UriInfo uriInfo) {
        // 获取查询参数
        Map<String,String> param = getQueryParam(uriInfo);
        Map<String,Object> map = new HashMap<>();
        for (Map.Entry<String,String> entry : param.entrySet()) {
            // gender 为 Int类型
            if (entry.getKey().equals("gender") && !StringUtils.isEmpty(entry.getValue())) {
                map.put(entry.getKey(), Integer.parseInt(entry.getValue()));
            } else {
                map.put(entry.getKey(),entry.getValue());
            }
        }

        return super.getPage(pageNum, pageSize, map);
    }

    @POST
    @Consumes(APPLICATION_FORM_URLENCODED)
    @Produces(APPLICATION_JSON)
    public ResultBean<User> save(@BeanParam User u) {
        Assert.notNull(u,"Can not persist a null Navigation object");
        u.setId(IdGenerator.INSTANCE.getId());
        return super.save(u);
    }

    @DELETE
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public ResultBean<Boolean> delete(@PathParam("id")Long id) {
        return super.delete(id);
    }

    @DELETE
    @Path("/multi")
    @Consumes(APPLICATION_FORM_URLENCODED)
    @Produces(APPLICATION_JSON)
    public ResultBean<Integer> deleteMulti(@FormParam("ids") List<Long> ids) {
        return super.deleteMulti(ids);
    }

    @PUT
    @Consumes(APPLICATION_FORM_URLENCODED)
    @Produces(APPLICATION_JSON)
    public ResultBean<User> update(@BeanParam User u){
        return super.update(u);
    }

    /**
     * 初始化Service
     *
     * @return 指定Service
     */
    @Override
    protected GenericService<User, Long> handleService() {
        return this.service;
    }


    @POST
    @Path("/login")
    @Consumes("application/x-www-form-urlencoded")
    @Produces(APPLICATION_JSON)
    public ResultBean<Map<String,String>> login(@FormParam("username")String username, @FormParam("password")String password) {
        Map<String,String> m = new HashMap<>();
        m.put("token","admin");
        return new ResultBean<>(m);
    }

    @GET
    @Path("/info")
    @Produces(APPLICATION_JSON)
    public ResultBean<Map<String,Object>> getInfo(@Context HttpServletRequest req) {
        Map<String,Object> m = new HashMap<>();
        List<String> role = new ArrayList<>();
        role.add("admin");
        m.put("name","admin");
        m.put("roles",role);
        m.put("role",role);
        m.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return new ResultBean<>(m);
    }

    @POST
    @Path("/logout")
    @Produces(APPLICATION_JSON)
    public ResultBean<String> logout(){
        ResultBean<String> rb = new ResultBean<>("logout");
        rb.setCode(20000);
        return rb;
    }
}
