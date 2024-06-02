package com.qy.mapper;

import com.qy.domain.DoctorSchedule;
import com.qy.domain.SystemUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface SystemUserMapper {

    List<SystemUser> findbyusernameandpasswordandrole(SystemUser systemuser);

    void insert(SystemUser systemUser);
}
