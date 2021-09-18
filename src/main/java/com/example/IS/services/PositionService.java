package com.example.IS.services;

import com.example.IS.models.Department;
import com.example.IS.models.Position;

import java.util.List;

public interface PositionService {
    Position getById(int positionId);

    List<Position> create(Position Position);

    List<Position> delete(int positionId);

    List<Position> update(int positionId, Position position);

    List<Position> getAll();

    Position getByName(String name);

    List<Position> getAllByGrade(int grade);

    List<Position> deleteAll();

    Position getByUserId(int userId);
}
