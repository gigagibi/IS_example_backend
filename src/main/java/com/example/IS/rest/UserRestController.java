package com.example.IS.rest;

import com.example.IS.models.User;
import com.example.IS.serviceImpl.repoImpl.UserServiceRepoImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
@AllArgsConstructor
public class UserRestController {
    private final UserServiceRepoImpl userService;

    @GetMapping("/{login}/name")
    public String getNameByLogin(@PathVariable String login) {
        return userService.getByLogin(login).getName();
    }

    @GetMapping("/")
    public List<User> getByInitials(@RequestParam(required = false) String name, @RequestParam(required = false) String surname, @RequestParam(required = false) String patronym) {
        return userService.getAllByInitials(name,surname,patronym);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/")
    public List<User> createUser(@RequestBody User user) {
        return userService.create(user);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/")
    public List<User> deleteUsers() {
        return userService.deleteAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public List<User> deleteUser(@PathVariable int id) {
        return userService.delete(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
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

    @GetMapping("/{login}/role")
    public String getRoleByLogin(@PathVariable String login) {
        return userService.getByLogin(login).getRole();
    }
}
