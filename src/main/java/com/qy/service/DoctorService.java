package com.qy.service;

import com.qy.domain.Doctor;
import com.qy.domain.DoctorProperties;
import com.qy.domain.DoctorSchedule;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;

public interface DoctorService {

    Integer insert(Doctor doctor);
    Doctor findmsg(Integer id);
    void update(Integer id,Doctor doctor);
}
