package com.makeronly.rbac.resource;

import com.makeronly.common.bean.ResultBean;
import com.makeronly.common.generic.GenericService;
import com.makeronly.common.resource.AbstractResource;
import com.makeronly.common.snowflake.IdGenerator;
import com.makeronly.rbac.domain.UserGroup;
import com.makeronly.rbac.service.UserGroupService;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @author Walter Wong
 */
@Component
@Path("/usergroup")
public class UserGroupResource extends AbstractResource<UserGroup,Long> {
    @Resource(name="rbac.userGroup")
    private UserGroupService service;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultBean<UserGroup> getInfo(@PathParam("id") Long id) {
        return new ResultBean<>(service.get(id));
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public ResultBean<UserGroup> save(@BeanParam UserGroup ug) {
        ug.setId(IdGenerator.INSTANCE.getId());
        return new ResultBean<>(service.save(ug));
    }

    /**
     * 初始化Service
     *
     * @return 指定Service
     */
    @Override
    protected GenericService<UserGroup, Long> handleService() {
        return this.service;
    }
}
