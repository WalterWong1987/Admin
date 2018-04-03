package com.makeronly.rbac.service.impl;

import com.makeronly.common.generic.GenericMapper;
import com.makeronly.common.generic.GenericServiceImpl;
import com.makeronly.rbac.domain.UserGroup;
import com.makeronly.rbac.repo.UserGroupMapper;
import com.makeronly.rbac.service.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Walter Wong
 */
@Service("rbac.userGroup")
public class UserGroupServiceImpl extends GenericServiceImpl<UserGroup,Long> implements UserGroupService{

    private UserGroupMapper mapper;

    @Autowired
    public UserGroupServiceImpl(UserGroupMapper mapper) {
        this.mapper = mapper;
    }
    /**
     * 返回对应的Mapper对象
     *
     * @return 对应Mapper对象
     */
    @Override
    protected GenericMapper<UserGroup, Long> init() {
        return this.mapper;
    }
}
