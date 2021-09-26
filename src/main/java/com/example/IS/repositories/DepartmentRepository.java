package com.example.IS.repositories;

import com.example.IS.models.Department;
import com.example.IS.models.Office;
import com.example.IS.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    // Search by value
    Department findByDepartmentId(int departmentId);

    List<Department> findAllByName(String name);

    List<Department> findAllByOffice(Office office);

    @Modifying
    @Query(value = "update Department set name = ?2, office = ?3 where departmentId = ?1")
    void updateDepartment(int id, String name, Office office);
}
