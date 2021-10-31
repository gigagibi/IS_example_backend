package com.example.IS.rest;

import com.example.IS.models.Task;
import com.example.IS.models.TaskType;
import com.example.IS.models.TaskType;
import com.example.IS.serviceImpl.repoImpl.TaskTypeServiceRepoImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/task_type")
@AllArgsConstructor
public class TaskTypeRestController {
    private final TaskTypeServiceRepoImpl taskTypeService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/")
    public List<TaskType> getTaskTypes() {
        return taskTypeService.getAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/")
    public List<TaskType> createTaskType(@RequestBody TaskType taskType) {
        return taskTypeService.create(taskType);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/")
    public List<TaskType> deleteTaskTypes() {
        return taskTypeService.deleteAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public TaskType getTaskType(@PathVariable int id) {
        return taskTypeService.getById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public List<TaskType> updateTaskType(@PathVariable int id, @RequestBody TaskType taskType) {
        return taskTypeService.update(id, taskType);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public List<TaskType> deleteTaskType(@PathVariable int id) {
        return taskTypeService.delete(id);
    }

    @GetMapping("/{taskId}")
    public TaskType getTypeByTaskId(@PathVariable int taskId) {
        return null;
    }
}
