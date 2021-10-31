package com.example.IS.rest;


import com.example.IS.exceptions.UserAndTaskNotMatchException;
import com.example.IS.models.Task;
import com.example.IS.serviceImpl.repoImpl.TaskServiceRepoImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/task")
@AllArgsConstructor
public class TaskRestController {
    private final TaskServiceRepoImpl taskService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public List<Task> getTasks() {
        return taskService.getAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/")
    public List<Task> createTask(@RequestBody Task task) {
        return taskService.create(task);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/")
    public List<Task> deleteTasks() {
        return taskService.deleteAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public Task getTask(@PathVariable int id) {
        return taskService.getById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public List<Task> updateTask(@PathVariable int id, @RequestBody Task task) {
        return taskService.update(id, task);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public List<Task> deleteTask(int id) {
        return taskService.delete(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/user")
    public List<Task> getTasksByUserId(@RequestParam int userId) {
        return taskService.getAllByUserId(userId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/project")
    public List<Task> getTasksByProjectId(int projectId) {
        return taskService.getAllByProjectId(projectId);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/")
    public List<Task> getTasksByToken(@RequestHeader("Authorization") String token) {
        return taskService.getTasksByToken(token.substring(7));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PatchMapping("/{id}/close")
    public Task closeTask(@RequestHeader("Authorization") String token, @PathVariable int id) throws UserAndTaskNotMatchException {
        token=token.substring(7);
        return taskService.closeTask(token, id);
    }
}
