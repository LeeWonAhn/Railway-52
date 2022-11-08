package com.vti.service;

import com.vti.entity.Department;
import com.vti.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {
    // Tự động tạo đối tượng
    @Autowired
    private IDepartmentRepository repository;

    @Override
    public List<Department> findAll() {
        return repository.findAll();
    }

    @Override
    public Department findByid(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void create(Department department) {
        repository.save(department);
    }

    @Override
    public void update(Department department) {
        repository.save(department);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
