package com.qy.mapper;

import com.qy.domain.Doctor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DoctorMapper {

    void insert(Doctor doctor);
    Integer selectid(Doctor doctor);
    Doctor findmsg(Integer id);
    void update(Integer id,Doctor doctor);
}
