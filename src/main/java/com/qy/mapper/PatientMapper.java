package com.qy.mapper;


import com.qy.domain.DoctorSchedule;
import com.qy.domain.Patient;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Mapper
@Repository
public interface PatientMapper {

    void insert(Patient patient);
    Integer selectid(Patient patient);

    void update(Patient patient);

    Patient findmsg(Integer id);

    void insertbook(@Param("P_id") Integer P_id, @Param("D_id") Integer D_id,@Param("C_id") Integer C_id);
    void updatebook(@Param("D_id") Integer D_id,@Param("C_id") Integer C_id);

    void updatebook2(@Param("P_id") Integer P_id, @Param("D_id") Integer D_id,@Param("C_id") Integer C_id);

    void updatebook3(@Param("P_id") Integer P_id, @Param("D_id") Integer D_id,@Param("C_id") Integer C_id);

    void updatebook4(@Param("P_id") Integer P_id, @Param("D_id") Integer D_id,@Param("C_id") Integer C_id);
    void updatepatient4(Integer P_id);
}
