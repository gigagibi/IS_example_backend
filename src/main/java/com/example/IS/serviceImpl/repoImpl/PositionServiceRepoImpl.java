package com.example.IS.serviceImpl.repoImpl;

import com.example.IS.models.Position;
import com.example.IS.repositories.PositionRepository;
import com.example.IS.repositories.UserRepository;
import com.example.IS.services.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PositionServiceRepoImpl implements PositionService {
    private final PositionRepository positionRepository;
    private final UserRepository userRepository;
    @Override
    public Position getById(int positionId) {
        return positionRepository.findByPositionId(positionId);
    }

    @Override
    public List<Position> create(Position position) {
        positionRepository.saveAndFlush(position);
        return positionRepository.findAll();
    }

    @Override
    public List<Position> delete(int positionId) {
        positionRepository.deleteById(positionId);
        return positionRepository.findAll();
    }

    @Override
    public List<Position> update(int positionId, Position position) {
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
        positionRepository.deleteAll();
        return positionRepository.findAll();
    }

    @Override
    public Position getByUserId(int userId) {
        return userRepository.getById(userId).position;
    }
}
