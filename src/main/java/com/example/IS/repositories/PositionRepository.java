package com.example.IS.repositories;

import com.example.IS.models.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PositionRepository extends JpaRepository<Position, Integer> {
    Position findAllByName(String name);

    Position findAllByGrade(int grade);

    Position findAllByPositionId(int positionId);
}
