package com.makeronly.rbac.repo;

import com.makeronly.common.generic.GenericMapper;
import com.makeronly.rbac.domain.Role;

import java.util.List;

/**
 * @author Walter Wong
 */
public interface RoleMapper extends GenericMapper<Role,Long> {
    List<Role> getPage();
}
