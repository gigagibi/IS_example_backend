package com.example.IS.repositories;

import com.example.IS.models.Department;
import com.example.IS.models.Office;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfficeRepository extends JpaRepository<Office, Integer> {
    Office findByOfficeId(int officeId);

    List<Office> findAllByAddress(String address);

    void deleteByOfficeId(int officeId);

    void deleteByAddress(String address);

}
