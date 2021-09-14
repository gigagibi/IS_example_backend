package com.example.IS.services;

import com.example.IS.models.Department;
import com.example.IS.models.Office;

import java.util.List;

public interface DepartmentService {
    public Department getById(int departmentId);

    public List<Department> createDepartment(Department department);

    public List<Department> deleteDepartment(int departmentId);

    public List<Department> updateDepartment(int departmentId, Department department);

    public List<Department> getAll();

    public List<Department> getAllByName(String name);

    public List<Department> getAllByOffice(Office office);

    public List<Department> deleteAll();
}