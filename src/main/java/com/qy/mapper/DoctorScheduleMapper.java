package com.qy.mapper;

import com.qy.domain.DoctorSchedule;
import com.qy.domain.Classid;
import com.qy.domain.Schedule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DoctorScheduleMapper {
    List<DoctorSchedule> findAll(Integer id);
    void insert(DoctorSchedule doctorSchedule);
    void delete(@Param("D_id") Integer D_id, @Param("C_id") Integer C_id);

    void update(@Param("D_id") Integer D_id, @Param("c") DoctorSchedule doctorSchedule);

    DoctorSchedule findByD_idandC_id(@Param("D_id") Integer D_id,@Param("C_id") Integer C_id);
    List<DoctorSchedule> findByP_idandD_idandC_id(@Param("P_id")Integer P_id,@Param("D_id") Integer D_id,@Param("C_id") Integer C_id);
    List<Schedule> findByP_id(@Param("P_id")Integer P_id);
    Classid findByname(String name);
    void Insertclassname(String name);

    List<Classid> findAllnameandid();
}
