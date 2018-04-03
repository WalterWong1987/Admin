package com.makeronly.user.service;

import com.makeronly.common.generic.GenericMapper;
import com.makeronly.common.generic.GenericServiceImpl;
import com.makeronly.common.snowflake.IdGenerator;
import com.makeronly.user.domain.Account;
import com.makeronly.user.domain.User;
import com.makeronly.user.repo.AccountMapper;
import com.makeronly.user.repo.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import java.util.List;

/**
 * @author Walter Wong
 */
@Service("user.userService")
@Transactional(readOnly = true)
public class UserServiceImpl extends GenericServiceImpl<User,Long> implements UserService {

    private UserMapper mapper;

    private AccountMapper acMapper;

    @Autowired
    public UserServiceImpl(UserMapper mapper, AccountMapper acMapper) {
        this.mapper = mapper;
        this.acMapper = acMapper;
    }

    /**
     * 返回对应的Mapper对象
     *
     * @return 对应Mapper对象
     */
    @Override
    protected GenericMapper<User, Long> init() {
        return this.mapper;
    }

    @Override
    @Transactional
    public User save(User user) {
        User u = super.save(user);
        // 创建手机账户
        if (!StringUtils.isEmpty(user.getPhone())) {
            Account ac = new Account(user.getId(),2,user.getPhone(),"1");
            ac.setId(IdGenerator.INSTANCE.getId());
            acMapper.save(ac);
        }
        // 创建邮箱账户
        if (!StringUtils.isEmpty(user.getEmail())) {
            Account ac = new Account(user.getId(),3,user.getEmail(),"1");
            ac.setId(IdGenerator.INSTANCE.getId());
            acMapper.save(ac);
        }
        return u;
    }

    /**
     * 批量删除
     * @param ids   id集合
     * @return Integer
     */
    @Override
    @Transactional
    public Integer deleteMulti(List<Long> ids) {
        return mapper.deleteMulti(ids);
    }
}
