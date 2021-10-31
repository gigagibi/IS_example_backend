package com.example.IS.rest;

import com.example.IS.exceptions.EntityNotFoundException;
import com.example.IS.models.Position;
import com.example.IS.serviceImpl.repoImpl.PositionServiceRepoImpl;
import com.example.IS.services.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/position")
@RequiredArgsConstructor
public class PositionRestController {
    private final PositionServiceRepoImpl positionService;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/")
    public List<Position> getPositions() {
        return positionService.getAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/")
    public List<Position> createPosition(@RequestBody Position position) {
        return positionService.create(position);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/")
    public List<Position> deletePositions() {
        return positionService.deleteAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public Position getPosition(@PathVariable int id) {
        return positionService.getById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public List<Position> deletePosition(@PathVariable int id) {
        return positionService.delete(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public List<Position> updatePosition(@PathVariable int id, @RequestBody Position position) throws EntityNotFoundException {
        if(positionService.getById(id) == null)
            throw new EntityNotFoundException();
        else
            return positionService.update(id, position);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/name")
    public Position getPositionByName(@RequestParam String name) {
        return positionService.getByName(name);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/grade")
    public List<Position> getPositionsByGrade(@RequestParam int grade) {
        return positionService.getAllByGrade(grade);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/user")
    public Position getPositionByUserId(@RequestParam int userId) {
        return positionService.getByUserId(userId);
    }

}
