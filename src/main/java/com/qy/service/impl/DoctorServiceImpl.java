package com.qy.service.impl;

import com.qy.domain.Doctor;
import com.qy.domain.DoctorProperties;
import com.qy.domain.DoctorSchedule;
import com.qy.domain.ResponseResult;
import com.qy.mapper.DoctorMapper;
import com.qy.service.DoctorService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;

@Service
public class DoctorServiceImpl implements DoctorService {


    @Autowired
    DoctorMapper doctorMapper;

    @Override
    public Integer insert(Doctor doctor) {
        doctorMapper.insert(doctor);
        return doctorMapper.selectid(doctor);
    }

    @Override
    public Doctor findmsg(Integer id) {
        return doctorMapper.findmsg(id);
    }

    @Override
    public void update(@Param("id")Integer id, @Param("doctor") Doctor doctor) {
        doctorMapper.update(id,doctor);
    }
}
