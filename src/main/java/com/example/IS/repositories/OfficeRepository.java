package com.example.IS.repositories;

import com.example.IS.models.Department;
import com.example.IS.models.Office;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



public interface OfficeRepository extends JpaRepository<Office, Integer> {
    Office findByOfficeId(int officeId);

    Office findByAddress(String address);

    void deleteByAddress(String address);

    @Modifying
    @Query(value = "update offices set address= ?2 where office_id = ?1", nativeQuery = true)
    void updateOffice(int id, String address);
}
