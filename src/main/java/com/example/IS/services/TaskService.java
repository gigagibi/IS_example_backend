package com.example.IS.services;

import com.example.IS.models.Project;
import com.example.IS.models.Task;
import com.example.IS.models.User;

import java.util.Date;
import java.util.List;

public interface TaskService {
    Task getById(int taskId);

    List<Task> create(Task task);

    List<Task> delete(int taskId);

    List<Task> update(int taskId, Task task);

    List<Task> getAll();

    List<Task> getByName(String name);

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

    List<Task> deleteAll();
    
    // FK search
    List<Task> getAllByUser(User user);

    List<Task> getAllByProject(Project project);

    List<Task> getAllByUserId(int userId);

    List<Task> getAllByProjectId(int projectId);

    List<Task> getAllByTaskTypeId(int taskTypeId);

    List<Task> getAllByTaskType(String taskType);

    Task closeTask(int taskId);
}
