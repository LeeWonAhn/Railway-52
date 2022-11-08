package com.vti.service;

import com.vti.entity.Department;

import java.util.List;

public interface IDepartmentService {
    List<Department> findAll();
    Department findByid(int id);
    void create(Department department);
    void update(Department department);
    void deleteById(int id);
}
