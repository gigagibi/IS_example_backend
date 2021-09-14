package com.example.IS.service;

import com.example.IS.models.Project;
import com.example.IS.models.Task;
import com.example.IS.models.User;

import java.util.Date;
import java.util.List;

public interface TaskService {
    public Project getById(int projectId);

    public List<Project> createProject(Project Project);

    public List<Project> deleteProject(int projectId);

    public List<Project> updateProject(int projectId, Project project);

    public List<Project> getAll();

    public Project getByName(String name);

    List<Task> getAllByFinishDate(Date finishDate);

    List<Task> getAllByStartDate(Date startDate);

    // Different filtration's
    List<Task> getAllByFinishDateBetween(Date min, Date max);

    List<Task> getAllByStartDateBetween(Date min, Date max);

    List<Task> getAllByStartDateBefore(Date value);

    List<Task> getAllByFinishDateBefore(Date value);

    List<Task> getAllByStartDateAfter(Date value);

    List<Task> getAllByFinishDateAfter(Date value);

    List<Task> getAllByStartDateIsBefore(Date value);

    List<Task> getAllByFinishDateIsBefore(Date value);

    List<Task> getAllByStartDateIsAfter(Date value);

    List<Task> getAllByFinishDateIsAfter(Date value);

    // FK search
    List<Task> getAllByUser(User user);

    List<Task> getAllByProject(Project project);
}
