package com.qy.service;

import com.qy.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SystemUserService {

    List<SystemUser> findbyusernameandpasswordandrole(SystemUser systemuser);

    void insert(SystemUser systemUser);
}
