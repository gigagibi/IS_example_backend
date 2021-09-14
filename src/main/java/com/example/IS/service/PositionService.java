package com.example.IS.service;

import com.example.IS.models.Position;

import java.util.List;

public interface PositionService {
    public Position getById(int positionId);

    public List<Position> createPosition(Position Position);

    public List<Position> deletePosition(int positionId);

    public List<Position> updatePosition(int positionId, Position position);

    public List<Position> getAll();

    public Position getByName(String name);

    public List<Position> getAllByGrade(int grade);

}
