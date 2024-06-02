package com.qy.service.impl;

import com.qy.domain.ClassKind;
import com.qy.mapper.ClassKindMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassKindServiceImpl implements ClassKindService{

    @Autowired
    ClassKindMapper classKindMapper;
    @Override
    public void add(ClassKind classkind) {
        classKindMapper.add(classkind);
    }

    @Override
    public void delete(Integer id) {
        classKindMapper.delete(id);
    }

    @Override
    public List<ClassKind> findAll() {
        return classKindMapper.findAll();
    }

    @Override
    public void update(ClassKind classKind) {
        classKindMapper.update(classKind);
    }
}
