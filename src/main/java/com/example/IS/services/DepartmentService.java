package com.example.IS.services;

import com.example.IS.models.Department;
import com.example.IS.models.Office;

import java.util.List;

public interface DepartmentService {
    Department getById(int departmentId);

    List<Department> create(Department department);

    List<Department> delete(int departmentId);

    List<Department> update(int departmentId, Department department);

    List<Department> getAll();

    List<Department> getAllByName(String name);

    List<Department> getAllByOffice(Office office);

    List<Department> getAllByOfficeId(int officeId);

    List<Department> deleteAll();
}