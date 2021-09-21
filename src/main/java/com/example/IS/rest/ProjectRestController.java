package com.example.IS.rest;

import com.example.IS.models.Project;
import com.example.IS.models.Task;
import com.example.IS.serviceImpl.repoImpl.ProjectServiceRepoImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/project")
@AllArgsConstructor
public class ProjectRestController {
    private ProjectServiceRepoImpl projectService;

    @GetMapping("/")
    public List<Project> getProjects() {
        return projectService.getAll();
    }

    @PostMapping("/")
    public List<Project> createProject(@RequestBody Project project) {
        return projectService.create(project);
    }

    @DeleteMapping("/")
    public List<Project> deleteProjects() {
        return projectService.deleteAll();
    }

    @GetMapping("/{id}")
    public Project getProject(@PathVariable int id) {
        return projectService.getById(id);
    }

    @DeleteMapping("/{id}")
    public List<Project> deleteProject(@PathVariable int id) {
        return projectService.delete(id);
    }

    @PutMapping("/{id}")
    public List<Project> updateProject(@PathVariable int id, @RequestBody Project project) {
        return projectService.update(id, project);
    }

    @GetMapping("/user")
    public List<Project> getProjectsByUserId(@RequestParam int userId) {
        return projectService.getProjectsByUserId(userId);
    }

    @GetMapping("/project_manager")
    public List<Project> getProjectsByPMId(@RequestParam int PMId) {
        return projectService.getProjectsByPMId(PMId);
    }

    @GetMapping("/task")
    public Project getProjectByTaskId(int taskId) {
        return projectService.getProjectByTaskId(taskId);
    }
}
