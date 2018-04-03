package com.makeronly.user.resource;

import com.makeronly.common.bean.ResultBean;
import com.makeronly.common.generic.GenericService;
import com.makeronly.common.resource.AbstractResource;
import com.makeronly.common.snowflake.IdGenerator;
import com.makeronly.user.domain.Account;
import com.makeronly.user.service.AccountService;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import javax.annotation.Resource;
import javax.ws.rs.*;

/**
 * @author Walter Wong
 */
@Component
@Path("/acc")
public class AccountResource extends AbstractResource<Account,Long> {
    @Resource(name = "user.accountService")
    private AccountService service;

    @GET
    @Path("/{id}")
    @Produces(APPLICATION_JSON)
    public ResultBean<Account> get(@PathParam("id")Long id){
        return super.get(id);
    }
    @POST
    @Consumes(APPLICATION_FORM_URLENCODED)
    @Produces(APPLICATION_JSON)
    public ResultBean<Account> save(@BeanParam Account acc) {
        Assert.notNull(acc,"Can not persist a null Navigation object");
        acc.setId(IdGenerator.INSTANCE.getId());
        return super.save(acc);
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
    public ResultBean<Account> update(@BeanParam Account acc){
        return super.update(acc);
    }
    /**
     * 初始化Service
     *
     * @return 指定Service
     */
    @Override
    protected GenericService<Account, Long> handleService() {
        return this.service;
    }
}
