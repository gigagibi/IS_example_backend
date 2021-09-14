package com.example.IS.repositories;

import com.example.IS.models.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface PositionRepository extends JpaRepository<Position, Integer> {
    Position findByName(String name);

    List<Position> findAllByGrade(int grade);

    Position findByPositionId(int positionId);
}
