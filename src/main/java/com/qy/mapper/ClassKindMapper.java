package com.qy.mapper;


import com.qy.domain.ClassKind;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClassKindMapper {
    void add(ClassKind classkind);

    void delete(Integer id);

    List<ClassKind> findAll();

    void update(ClassKind classKind);
}
