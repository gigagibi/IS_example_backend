package com.example.IS.serviceImpl.repoImpl;

import com.example.IS.models.TaskType;
import com.example.IS.repositories.TaskTypeRepository;
import com.example.IS.services.TaskTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TaskTypeServiceRepoImpl implements TaskTypeService {
    private final TaskTypeRepository taskTypeRepository;

    @Override
    public TaskType getById(int taskTypeId) {
        return taskTypeRepository.findByTaskTypeId(taskTypeId);
    }

    @Override
    public TaskType getByTaskType(String taskType) {
        return taskTypeRepository.findByTaskType(taskType);
    }

    @Override
    public List<TaskType> update(int taskTypeId, TaskType taskType) {
        taskTypeRepository.updateTaskType(taskTypeId, taskType.getTaskType());
        return taskTypeRepository.findAll();
    }

    @Override
    public List<TaskType> deleteByTaskTypeId(int taskTypeId) {
        taskTypeRepository.deleteById(taskTypeId);
        return taskTypeRepository.findAll();
    }

    @Override
    public List<TaskType> deleteByTaskType(String taskType) {
        taskTypeRepository.deleteByTaskType(taskType);
        return taskTypeRepository.findAll();
    }

    @Override
    public List<TaskType> create(TaskType taskType) {
        taskTypeRepository.save(taskType);
        return taskTypeRepository.findAll();
    }
}
