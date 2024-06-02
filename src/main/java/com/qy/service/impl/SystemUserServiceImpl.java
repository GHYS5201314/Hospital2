package com.qy.service.impl;

import com.qy.domain.*;
import com.qy.mapper.SystemUserMapper;
import com.qy.service.DoctorService;
import com.qy.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemUserServiceImpl implements SystemUserService {

    @Autowired
    SystemUserMapper systemUserMapper;

    @Override
    public List<SystemUser> findbyusernameandpasswordandrole(SystemUser systemuser) {
        return systemUserMapper.findbyusernameandpasswordandrole(systemuser);
    }

    @Override
    public void insert(SystemUser systemUser) {
        systemUserMapper.insert(systemUser);
    }
}