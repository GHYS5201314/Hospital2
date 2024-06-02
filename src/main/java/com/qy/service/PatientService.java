package com.qy.service;

import com.qy.domain.Patient;
import com.qy.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface PatientService {

    Integer insert(Patient patient);


    void update(Patient patient);

    Patient findmsg(Integer id);
    void insertbook(Integer P_id,Integer D_id,Integer C_id);
    void updatebook(Integer D_id,Integer C_ID);
    void updatebook2(Integer P_id,Integer D_id,Integer C_id);

    void updatebook3(Integer P_id,Integer D_id,Integer C_id);

    void updatebook4(Integer P_id,Integer D_id,Integer C_id);
    void updatepatient4(Integer P_id);
}
