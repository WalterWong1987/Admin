package com.makeronly.rbac.service;

import com.makeronly.common.generic.GenericService;
import com.makeronly.rbac.domain.Role;

import java.util.List;

/**
 * @author Walter Wong
 */
public interface RoleService extends GenericService<Role,Long> {
    List<Role> getPage();
}
