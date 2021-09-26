package com.example.IS.rest;

import com.example.IS.models.TaskType;
import com.example.IS.models.TaskType;
import com.example.IS.serviceImpl.repoImpl.TaskTypeServiceRepoImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/task_type")
@AllArgsConstructor
public class TaskTypeRestController {
    private final TaskTypeServiceRepoImpl taskTypeService;

    @GetMapping("/")
    public List<TaskType> getTaskTypes() {
        return taskTypeService.getAll();
    }

    @PostMapping("/")
    public List<TaskType> createTaskType(@RequestBody TaskType taskType) {
        return taskTypeService.create(taskType);
    }

    @DeleteMapping("/")
    public List<TaskType> deleteTaskTypes() {
        return taskTypeService.deleteAll();
    }

    @GetMapping("/{id}")
    public TaskType getTaskType(@PathVariable int id) {
        return taskTypeService.getById(id);
    }

    @PutMapping("/{id}")
    public List<TaskType> updateTaskType(@PathVariable int id, @RequestBody TaskType taskType) {
        return taskTypeService.update(id, taskType);
    }

    @DeleteMapping("/{id}")
    public List<TaskType> deleteTaskType(int id) {
        return taskTypeService.delete(id);
    }
}
