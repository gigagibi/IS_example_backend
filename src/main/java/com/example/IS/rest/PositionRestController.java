package com.example.IS.rest;

import com.example.IS.exceptions.EntityNotFoundException;
import com.example.IS.models.Position;
import com.example.IS.serviceImpl.repoImpl.PositionServiceRepoImpl;
import com.example.IS.services.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/position")
@RequiredArgsConstructor
public class PositionRestController {
    private final PositionServiceRepoImpl positionService;

    @GetMapping("/")
    public List<Position> getPositions() {
        return positionService.getAll();
    }

    @PostMapping("/")
    public List<Position> createPosition(Position position) {
        return positionService.create(position);
    }


    @DeleteMapping("/")
    public List<Position> deletePositions() {
        return positionService.deleteAll();
    }

    @GetMapping("/{id}")
    public Position getPosition(@PathVariable int id) {
        return positionService.getById(id);
    }

    @DeleteMapping("/{id}")
    public List<Position> deletePosition(@PathVariable int id) {
        return positionService.delete(id);
    }

    @PutMapping("/{id}")
    public List<Position> updatePosition(@PathVariable int id, @RequestBody Position position) throws EntityNotFoundException {
        if(positionService.getById(id) == null)
            throw new EntityNotFoundException();
        else
            return positionService.update(id, position);
    }

    @GetMapping("/name")
    public Position getPositionByName(@RequestParam String name) {
        return positionService.getByName(name);
    }

    @GetMapping("/grade")
    public List<Position> getPositionsByGrade(@RequestParam int grade) {
        return positionService.getAllByGrade(grade);
    }

    @GetMapping("/user")
    public Position getPositionByUserId(@RequestParam int userId) {
        return positionService.getByUserId(userId);
    }

}
