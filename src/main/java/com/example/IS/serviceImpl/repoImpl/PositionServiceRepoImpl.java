package com.example.IS.serviceImpl.repoImpl;

import com.example.IS.models.Position;
import com.example.IS.repositories.PositionRepository;
import com.example.IS.services.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionServiceRepoImpl implements PositionService {
    private final PositionRepository positionRepository;
    @Override
    public Position getById(int positionId) {
        return positionRepository.findByPositionId(positionId);
    }

    @Override
    public List<Position> createPosition(Position position) {
        positionRepository.saveAndFlush(position);
        return positionRepository.findAll();
    }

    @Override
    public List<Position> deletePosition(int positionId) {
        positionRepository.deleteById(positionId);
        return positionRepository.findAll();
    }

    @Override
    public List<Position> updatePosition(int positionId, Position position) {
        positionRepository.updatePosition(positionId, position.getName(), position.getGrade());
        return positionRepository.findAll();
    }

    @Override
    public List<Position> getAll() {
        return positionRepository.findAll();
    }

    @Override
    public Position getByName(String name) {
        return positionRepository.findByName(name);
    }

    @Override
    public List<Position> getAllByGrade(int grade) {
        return positionRepository.findAllByGrade(grade);
    }

    @Override
    public List<Position> deleteAll() {
        return null;
    }
}
