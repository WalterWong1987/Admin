package com.makeronly.nav.resource;

import com.makeronly.common.bean.ResultBean;
import com.makeronly.common.generic.GenericService;
import com.makeronly.common.resource.AbstractResource;
import com.makeronly.common.snowflake.IdGenerator;
import com.makeronly.nav.domain.Navigation;
import com.makeronly.nav.service.NavService;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import javax.annotation.Resource;
import javax.ws.rs.*;

/**
 * @author Walter Wong
 */
@Component
@Path("/nav")
public class NavigationResource extends AbstractResource<Navigation,Long> {

    @Resource(name = "nav.navService")
    private NavService service;

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public ResultBean<Navigation> getInfo(@PathParam("id")Long id) {
        return super.get(id);
    }

    @POST
    @Consumes(APPLICATION_FORM_URLENCODED)
    @Produces(APPLICATION_JSON)
    public ResultBean<Navigation> save(@BeanParam Navigation nav) {
        Assert.notNull(nav,"Can not persist a null Navigation object");
        nav.setId(IdGenerator.INSTANCE.getId());
        return super.save(nav);
    }

    @DELETE
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public ResultBean<Boolean> delete(@PathParam("id")Long id) {
        return super.delete(id);
    }

    @PUT
    @Consumes(APPLICATION_FORM_URLENCODED)
    @Produces(APPLICATION_JSON)
    public ResultBean<Navigation> update(@BeanParam Navigation nav){
        return super.update(nav);
    }

    @Override
    protected GenericService<Navigation, Long> handleService() {
        return this.service;
    }
}
