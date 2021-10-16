package com.example.IS.repositories;

import com.example.IS.models.Department;
import com.example.IS.models.Project;
import com.example.IS.models.Task;
import com.example.IS.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Integer> {
    // find by value
    Task findByTaskId(int taskId);

    List<Task> findAllByFinishDate(Date finishDate);

    List<Task> findAllByStartDate(Date startDate);

    List<Task> findAllByName(String name);

    // Different filtration's
    List<Task> findAllByFinishDateBetween(Date min, Date max);

    List<Task> findAllByStartDateBetween(Date min, Date max);

    List<Task> findAllByStartDateBefore(Date value);

    List<Task> findAllByFinishDateBefore(Date value);

    List<Task> findAllByStartDateAfter(Date value);

    List<Task> findAllByFinishDateAfter(Date value);

    List<Task> findAllByStartDateIsBefore(Date value);

    List<Task> findAllByFinishDateIsBefore(Date value);

    List<Task> findAllByStartDateIsAfter(Date value);

    List<Task> findAllByFinishDateIsAfter(Date value);

    List<Task> findAllByDescription(String description);
    // FK search
    List<Task> findAllByUser(User user);

    List<Task> findAllByProject(Project project);

    @Modifying
    @Query(value = "update Task set name = ?2, description = ?3, startDate = ?4, finishDate = ?5, project = ?6, user = ?7 where taskId = ?1")
    void updateTask(int id, String name, String description, Date startDate, Date finishDate, Project project, User user);

    @Modifying
    @Query(value = "update Task set finishDate = ?2 where taskId = ?1")
    void changeTaskFinishDate(int id, Date finishDate);
}
