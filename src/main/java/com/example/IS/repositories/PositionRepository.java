package com.example.IS.repositories;

import com.example.IS.models.Department;
import com.example.IS.models.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface PositionRepository extends JpaRepository<Position, Integer> {
    Position findByName(String name);

    List<Position> findAllByGrade(int grade);

    Position findByPositionId(int positionId);

    @Modifying
    @Query(value = "update Position set name = ?2, grade = ?3 where positionId = ?1")
    void updatePosition(int id, String name, int grade);
}
