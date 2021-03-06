package com.example.IS.repositories;

import com.example.IS.models.Task;
import com.example.IS.models.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskTypeRepository extends JpaRepository<TaskType, Integer> {
    TaskType findByTaskTypeId(int taskTypeId);

    TaskType findByTaskType(String taskType);

    @Modifying
    @Query(value = "update TaskType set taskType = ?2")
    void updateTaskType(int taskTypeId, String taskType);

    void deleteByTaskType(String taskType);
}
