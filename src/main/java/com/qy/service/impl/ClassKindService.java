package com.qy.service.impl;

import com.qy.domain.ClassKind;

import java.util.List;

public interface ClassKindService {
    void add(ClassKind classkind);
    void delete(Integer id);
    List<ClassKind> findAll();
    void update(ClassKind classKind);
}
