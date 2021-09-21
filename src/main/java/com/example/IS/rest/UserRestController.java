package com.example.IS.rest;

import com.example.IS.models.User;
import com.example.IS.serviceImpl.repoImpl.UserServiceRepoImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
@AllArgsConstructor
public class UserRestController {
    private final UserServiceRepoImpl userService;

    @GetMapping("/")
    public List<User> getUsers() {
        return userService.getAll();
    }

    @PostMapping("/")
    public List<User> createUser(@RequestBody User user) {
        return userService.create(user);
    }

    @DeleteMapping("/")
    public List<User> deleteUsers() {
        return userService.deleteAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getById(id);
    }

    @DeleteMapping("/{id|")
    public List<User> deleteUser(@PathVariable int id) {
        return userService.delete(id);
    }

    @PutMapping("/{id}")
    public List<User> updateUser(@PathVariable int id, @RequestBody User user) {
        return userService.update(id, user);
    }

    @GetMapping("/department")
    public List<User> getUsersByDepartmentId(@RequestParam int departmentId) {
        return userService.getAllByDepartmentId(departmentId);
    }

    @GetMapping("/position")
    public List<User> getUsersByPositionId(@RequestParam int positionId) {
        return userService.getAllByPositionId(positionId);
    }
}
