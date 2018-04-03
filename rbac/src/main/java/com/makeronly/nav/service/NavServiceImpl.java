package com.makeronly.nav.service;

import com.makeronly.common.generic.GenericMapper;
import com.makeronly.common.generic.GenericServiceImpl;
import com.makeronly.nav.domain.Navigation;
import com.makeronly.nav.repo.NavMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Walter Wong
 */
@Service("nav.navService")
public class NavServiceImpl extends GenericServiceImpl<Navigation,Long> implements NavService{

    private NavMapper mapper;

    @Autowired
    public NavServiceImpl(NavMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * 返回对应的Mapper对象
     *
     * @return 对应Mapper对象
     */
    @Override
    protected GenericMapper<Navigation, Long> init() {
        return this.mapper;
    }
}
