package com.example.IS.service;

import com.example.IS.models.Department;
import com.example.IS.repositories.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public interface DepartmentService {
    public List<Department> getAll();

    public List<Department> createDepartment(Department department);
}