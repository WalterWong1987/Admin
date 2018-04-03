package com.makeronly.user.repo;

import com.makeronly.common.generic.GenericMapper;
import com.makeronly.user.domain.User;

import java.util.List;

/**
 * @author Walter Wong
 */
public interface UserMapper extends GenericMapper<User,Long>{
    Integer deleteMulti(List<Long> ids);
}
