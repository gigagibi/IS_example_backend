package com.example.IS.rest;


import com.example.IS.models.Task;
import com.example.IS.serviceImpl.repoImpl.TaskServiceRepoImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/task")
@AllArgsConstructor
public class TaskRestController {
    private final TaskServiceRepoImpl taskService;

    @GetMapping("/")
    public List<Task> getTasks() {
        return taskService.getAll();
    }

    @PostMapping("/")
    public List<Task> createTask(@RequestBody Task task) {
        return taskService.create(task);
    }

    @DeleteMapping("/")
    public List<Task> deleteTasks() {
        return taskService.deleteAll();
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable int id) {
        return taskService.getById(id);
    }

    @PutMapping("/{id}")
    public List<Task> updateTask(@PathVariable int id, @RequestBody Task task) {
        return taskService.update(id, task);
    }

    @DeleteMapping("/{id}")
    public List<Task> deleteTask(int id) {
        return taskService.delete(id);
    }

    @GetMapping("/user")
    public List<Task> getTasksByUserId(@RequestParam int userId) {
        return taskService.getAllByUserId(userId);
    }

    @GetMapping("/project")
    public List<Task> getTasksByProjectId(int projectId) {
        return taskService.getAllByProjectId(projectId);
    }
}
