package com.makeronly.rbac.resource;

import com.makeronly.common.bean.ResultBean;
import com.makeronly.common.generic.GenericService;
import com.makeronly.common.resource.AbstractResource;
import com.makeronly.common.snowflake.IdGenerator;
import com.makeronly.rbac.domain.Privilege;
import com.makeronly.rbac.service.PrivilegeService;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @author Walter Wong
 */
@Component
@Path("/privilege")
public class PrivilegeResource extends AbstractResource<Privilege,Long> {
    @Resource(name = "rbac.privilegeService")
    private PrivilegeService service;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultBean<Privilege> getInfo(@PathParam("id") Long id) {
        Privilege p = service.get(id);
        return new ResultBean<>(p);
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public ResultBean<Privilege> save(@BeanParam Privilege p) {
        p.setId(IdGenerator.INSTANCE.getId());
        return new ResultBean<>(service.save(p));
    }

    /**
     * 初始化Service
     *
     * @return 指定Service
     */
    @Override
    protected GenericService<Privilege, Long> handleService() {
        return this.service;
    }
}
