package com.example.EmployeeManagementSystem.service;

import com.example.EmployeeManagementSystem.model.Department;
import com.example.EmployeeManagementSystem.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(Long id) {
        Optional<Department> department = departmentRepository.findById(id);
        return department.orElse(null);
    }

    public Set<Department> getAllDepartments() {
        Set<Department> departments = new HashSet<>();
        departmentRepository.findAll().forEach(departments::add);
        return departments;
    }
}