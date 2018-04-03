package com.makeronly.rbac.resource;

import com.github.pagehelper.PageInfo;
import com.makeronly.common.bean.ResultBean;
import com.makeronly.common.generic.GenericService;
import com.makeronly.common.resource.AbstractResource;
import com.makeronly.common.snowflake.IdGenerator;
import com.makeronly.rbac.domain.Role;
import com.makeronly.rbac.service.RoleService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.ws.rs.*;
import java.util.List;

/**
 * @author Walter Wong
 */
@Component
@Path("/role")
public class RoleResource extends AbstractResource<Role, Long> {
    @Resource(name = "rbac.roleService")
    private RoleService service;

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public ResultBean<Role> getInfo(@PathParam("id") Long id) {
        return super.get(id);
    }

    @GET
    @Path("{pageNum}/{pageSize}")
    @Produces(APPLICATION_JSON)
    public ResultBean<PageInfo<Role>> getPage(@PathParam("pageNum") Integer pageNum, @PathParam("pageSize") Integer pageSize) {
        return super.getPage(pageNum, pageSize, null);
    }

    @POST
    @Consumes(APPLICATION_FORM_URLENCODED)
    @Produces(APPLICATION_JSON)
    public ResultBean<Role> save(@BeanParam Role r) {
        r.setId(IdGenerator.INSTANCE.getId());
        return super.save(r);
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
    public ResultBean<Role> update(@BeanParam Role r) {
        return super.update(r);
    }

    /**
     * 初始化Service
     *
     * @return 指定Service
     */
    @Override
    protected GenericService<Role, Long> handleService() {
        return this.service;
    }
}
