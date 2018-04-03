package com.makeronly.user.service;

import com.makeronly.common.generic.GenericMapper;
import com.makeronly.common.generic.GenericServiceImpl;
import com.makeronly.user.domain.Account;
import com.makeronly.user.repo.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Walter Wong
 */
@Service("user.accountService")
public class AccountServiceImpl extends GenericServiceImpl<Account,Long> implements AccountService{

    private AccountMapper mapper;

    @Autowired
    public AccountServiceImpl(AccountMapper mapper) {
        this.mapper = mapper;
    }
    /**
     * 返回对应的Mapper对象
     *
     * @return 对应Mapper对象
     */
    @Override
    protected GenericMapper<Account, Long> init() {
        return this.mapper;
    }
}
