package com.example.IS.services;

import com.example.IS.models.TaskType;

import java.util.List;

public interface TaskTypeService {
    TaskType getById(int taskTypeId);

    TaskType getByTaskType(String taskType);

    List<TaskType> update(int taskTypeId, TaskType taskType);

    List<TaskType> deleteByTaskTypeId(int taskTypeId);

    List<TaskType> deleteByTaskType(String taskType);

    List<TaskType> create(TaskType taskType);
}
