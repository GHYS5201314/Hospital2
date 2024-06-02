package com.qy.service;

import com.qy.domain.Classid;
import com.qy.domain.DoctorSchedule;
import com.qy.domain.Schedule;

import java.util.List;

public interface DoctorScheduleService {
    List<DoctorSchedule> findAll(Integer id);
    void insert(DoctorSchedule doctorSchedule);

    void delete(Integer D_id, Integer C_id);

    void update(Integer D_id, DoctorSchedule doctorSchedule);
    List<Schedule> findByP_id(Integer P_id);

    List<Classid> findAllnameandid();

    Classid findByname(String name);
    void Insertclassname(String name);
}
