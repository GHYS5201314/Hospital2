package com.qy.service.impl;

import com.qy.domain.Patient;
import com.qy.mapper.PatientMapper;
import com.qy.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientMapper patientMapper;
    @Override
    public Integer insert(Patient patient) {
        patientMapper.insert(patient);
        return patientMapper.selectid(patient);
    }

    @Override
    public void update(Patient patient) {
        patientMapper.update(patient);
    }

    @Override
    public Patient findmsg(Integer id) {
        return patientMapper.findmsg(id);
    }

    @Override
    public void insertbook(Integer P_id, Integer D_id, Integer C_id) {
        patientMapper.insertbook(P_id,D_id,C_id);
    }

    @Override
    public void updatebook(Integer D_id, Integer C_id) {
        patientMapper.updatebook(D_id,C_id);
    }

    @Override
    public void updatebook2(Integer P_id, Integer D_id, Integer C_id) {
        patientMapper.updatebook2(P_id,D_id,C_id);
    }

    @Override
    public void updatebook3(Integer P_id, Integer D_id, Integer C_id) {
        patientMapper.updatebook3(P_id,D_id,C_id);
    }

    @Override
    public void updatebook4(Integer P_id, Integer D_id, Integer C_id) {
        patientMapper.updatebook4(P_id,D_id,C_id);
    }

    @Override
    public void updatepatient4(Integer P_id) {
        patientMapper.updatepatient4(P_id);
    }
}
