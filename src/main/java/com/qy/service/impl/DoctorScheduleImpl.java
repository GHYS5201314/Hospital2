package com.qy.service.impl;

import com.qy.domain.Classid;
import com.qy.domain.DoctorSchedule;
import com.qy.domain.Schedule;
import com.qy.mapper.DoctorScheduleMapper;
import com.qy.service.DoctorScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DoctorScheduleImpl implements DoctorScheduleService {

    @Autowired

    DoctorScheduleMapper doctorScheduleMapper;
    @Override
    public List<DoctorSchedule> findAll(Integer id) {
        return doctorScheduleMapper.findAll(id);
    }

    @Override
    public void insert(DoctorSchedule doctorSchedule) {
        doctorScheduleMapper.insert(doctorSchedule);
    }

    @Override
    public void delete(Integer D_id, Integer C_id) {
        doctorScheduleMapper.delete(D_id,C_id);
    }

    @Override
    public void update(Integer D_id, DoctorSchedule doctorSchedule) {
        doctorScheduleMapper.update(D_id,doctorSchedule);
    }

    @Override
    public List<Schedule> findByP_id(Integer P_id) {
        return doctorScheduleMapper.findByP_id(P_id);
    }

    @Override
    public List<Classid> findAllnameandid() {
        return doctorScheduleMapper.findAllnameandid();
    }

    @Override
    public Classid findByname(String name) {
        return doctorScheduleMapper.findByname(name);
    }

    @Override
    public void Insertclassname(String name) {
        doctorScheduleMapper.Insertclassname(name);
    }

}
