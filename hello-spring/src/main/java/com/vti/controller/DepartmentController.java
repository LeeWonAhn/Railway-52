package com.vti.controller;

import com.vti.entity.Department;
import com.vti.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    @Autowired
    private IDepartmentService service;

    @GetMapping
    public List<Department> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}") // => /api/v1/departments/{id}
    public Department findById(@PathVariable(name = "id") int id) {
        return service.findByid(id);
    }

    @PostMapping
    public void create(@RequestBody Department department) {
        service.create(department);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody  Department department) {
        department.setId(id);
        service.update(department);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(name = "id") int id) {
        service.deleteById(id);
    }
}
