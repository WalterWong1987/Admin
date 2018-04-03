package com.makeronly.rbac.service.impl;

import com.makeronly.common.generic.GenericMapper;
import com.makeronly.common.generic.GenericServiceImpl;
import com.makeronly.rbac.domain.Privilege;
import com.makeronly.rbac.repo.PrivilegeMapper;
import com.makeronly.rbac.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Walter Wong
 */
@Service("rbac.privilegeService")
public class PrivilegeServiceImpl extends GenericServiceImpl<Privilege,Long> implements PrivilegeService{

    private PrivilegeMapper mapper;
    @Autowired
    public PrivilegeServiceImpl(PrivilegeMapper mapper){
        this.mapper = mapper;
    }
    /**
     * 返回对应的Mapper对象
     *
     * @return 对应Mapper对象
     */
    @Override
    protected GenericMapper<Privilege, Long> init() {
        return this.mapper;
    }
}
