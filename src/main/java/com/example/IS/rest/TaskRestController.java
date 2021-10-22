package com.example.IS.rest;


import com.example.IS.models.Task;
import com.example.IS.serviceImpl.repoImpl.TaskServiceRepoImpl;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @GetMapping("/")
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

    @GetMapping("/user")
    public List<Task> getTasksByUserId(@RequestParam int userId) {
        return taskService.getAllByUserId(userId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/project")
    public List<Task> getTasksByProjectId(int projectId) {
        return taskService.getAllByProjectId(projectId);
    }

    @PatchMapping("/{id}/close")
    public Task closeTask(@PathVariable int id) {return taskService.closeTask(id);}
}
