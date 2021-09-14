package com.example.IS.service;

import com.example.IS.models.Department;
import com.example.IS.models.Office;
import com.example.IS.repositories.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DepartmentService {
    public Department getById(int departmentId);

    public List<Department> createDepartment(Department department);

    public List<Department> deleteDepartment(int departmentId);

    public List<Department> updateDepartment(int departmentId, Department department);

    public List<Department> getAll();

    public List<Department> getAllByName(String name);

    public List<Department> getAllByOffice(Office office);
}