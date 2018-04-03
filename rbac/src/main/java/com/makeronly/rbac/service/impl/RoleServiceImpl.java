package com.makeronly.rbac.service.impl;

import com.makeronly.common.generic.GenericMapper;
import com.makeronly.common.generic.GenericServiceImpl;
import com.makeronly.rbac.domain.Role;
import com.makeronly.rbac.repo.RoleMapper;
import com.makeronly.rbac.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Walter Wong
 */
@Service("rbac.roleService")
@Transactional(readOnly = true)
public class RoleServiceImpl extends GenericServiceImpl<Role,Long> implements RoleService {

    private RoleMapper mapper;

    @Autowired
    public RoleServiceImpl(RoleMapper mapper) {
        this.mapper = mapper;
    }
    /**
     * 返回对应的Mapper对象
     *
     * @return 对应Mapper对象
     */
    @Override
    @Deprecated
    protected GenericMapper<Role, Long> init() {
        return this.mapper;
    }

    @Override
    public List<Role> getPage() {
        return mapper.getPage();
    }
}
