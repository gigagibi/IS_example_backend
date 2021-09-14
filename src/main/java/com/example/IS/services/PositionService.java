package com.example.IS.services;

import com.example.IS.models.Department;
import com.example.IS.models.Position;

import java.util.List;

public interface PositionService {
    Position getById(int positionId);

    List<Position> createPosition(Position Position);

    List<Position> deletePosition(int positionId);

    List<Position> updatePosition(int positionId, Position position);

    List<Position> getAll();

    Position getByName(String name);

    List<Position> getAllByGrade(int grade);

    List<Position> deleteAll();

}
