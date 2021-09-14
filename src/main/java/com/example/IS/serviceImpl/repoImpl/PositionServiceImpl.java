package com.example.IS.serviceImpl.repoImpl;

import com.example.IS.models.Position;
import com.example.IS.repositories.PositionRepository;
import com.example.IS.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;
    @Override
    public Position getById(int positionId) {
        return positionRepository.findByPositionId(positionId);
    }

    @Override
    public List<Position> createPosition(Position position) {
        positionRepository.save(position);
        return positionRepository.findAll();
    }

    @Override
    public List<Position> deletePosition(int positionId) {
        positionRepository.deleteById(positionId);
        return positionRepository.findAll();
    }

    @Override
    public List<Position> updatePosition(int positionId, Position position) {
        if(positionRepository.findByPositionId(positionId) != null) {
            positionRepository.save(position);
            return positionRepository.findAll();
        }
        else
            return null;
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
}
