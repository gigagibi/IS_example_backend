package com.example.IS.serviceImpl.repoImpl;

import com.example.IS.models.Project;
import com.example.IS.models.Task;
import com.example.IS.models.User;
import com.example.IS.repositories.TaskRepository;
import com.example.IS.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    @Override
    public Project getById(int projectId) {
        return null;
    }

    @Override
    public List<Project> createProject(Project Project) {
        return null;
    }

    @Override
    public List<Project> deleteProject(int projectId) {
        return null;
    }

    @Override
    public List<Project> updateProject(int projectId, Project project) {
        return null;
    }

    @Override
    public List<Project> getAll() {
        return null;
    }

    @Override
    public Project getByName(String name) {
        return null;
    }

    @Override
    public List<Task> getAllByFinishDate(Date finishDate) {
        return null;
    }

    @Override
    public List<Task> getAllByStartDate(Date startDate) {
        return null;
    }

    @Override
    public List<Task> getAllByFinishDateBetween(Date min, Date max) {
        return null;
    }

    @Override
    public List<Task> getAllByStartDateBetween(Date min, Date max) {
        return null;
    }

    @Override
    public List<Task> getAllByStartDateBefore(Date value) {
        return null;
    }

    @Override
    public List<Task> getAllByFinishDateBefore(Date value) {
        return null;
    }

    @Override
    public List<Task> getAllByStartDateAfter(Date value) {
        return null;
    }

    @Override
    public List<Task> getAllByFinishDateAfter(Date value) {
        return null;
    }

    @Override
    public List<Task> getAllByStartDateIsBefore(Date value) {
        return null;
    }

    @Override
    public List<Task> getAllByFinishDateIsBefore(Date value) {
        return null;
    }

    @Override
    public List<Task> getAllByStartDateIsAfter(Date value) {
        return null;
    }

    @Override
    public List<Task> getAllByFinishDateIsAfter(Date value) {
        return null;
    }

    @Override
    public List<Task> getAllByUser(User user) {
        return null;
    }

    @Override
    public List<Task> getAllByProject(Project project) {
        return null;
    }
}
