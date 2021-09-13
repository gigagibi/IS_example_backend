package com.example.IS.serviceImpl.repoImpl;

import com.example.IS.models.Department;
import com.example.IS.repositories.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl {
    private final DepartmentRepository departmentRepository;

    public List<Department> getAll() { return departmentRepository.findAll(); }

    public List<Department> createDepartment(Department department) {
        departmentRepository.save(department);
        return departmentRepository.findAll();
    }

    public List<Department>
}