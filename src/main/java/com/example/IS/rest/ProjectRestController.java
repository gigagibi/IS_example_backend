package com.example.IS.rest;

import com.example.IS.models.Project;
import com.example.IS.models.Task;
import com.example.IS.serviceImpl.repoImpl.ProjectServiceRepoImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/project")
@AllArgsConstructor
public class ProjectRestController {
    private ProjectServiceRepoImpl projectService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/")
    public List<Project> getProjects() {
        return projectService.getAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/")
    public List<Project> createProject(@RequestBody Project project) {
        return projectService.create(project);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/")
    public List<Project> deleteProjects() {
        return projectService.deleteAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public Project getProject(@PathVariable int id) {
        return projectService.getById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public List<Project> deleteProject(@PathVariable int id) {
        return projectService.delete(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public List<Project> updateProject(@PathVariable int id, @RequestBody Project project) {
        return projectService.update(id, project);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/user")
    public List<Project> getProjectsByUserId(@RequestParam int userId) {
        return projectService.getProjectsByUserId(userId);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/project_manager")
    public List<Project> getProjectsByPMId(@RequestHeader("Authorization") String token) {
        return projectService.getProjectsByPMId(token.substring(7));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/task")
    public Project getProjectByTaskId(int taskId) {
        return projectService.getProjectByTaskId(taskId);
    }
}
