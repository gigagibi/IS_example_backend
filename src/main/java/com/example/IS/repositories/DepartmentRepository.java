package com.example.IS.repositories;

import com.example.IS.models.Department;
import com.example.IS.models.Office;
import com.example.IS.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    // Search by value
    Department findByDepartmentId(int departmentId);

    List<Department> findAllByName(String name);

    List<Department> findAllByOffice(Office office);

    // Delete
    void deleteByDepartmentId(int departmentId);

    void deleteAllByName(String name);

    // FK search
    Department findByOffice(Office office);
}
