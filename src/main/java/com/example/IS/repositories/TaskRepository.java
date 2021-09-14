package com.example.IS.repositories;

import com.example.IS.models.Project;
import com.example.IS.models.Task;
import com.example.IS.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Integer> {
    // find by value
    Task findByTaskId(int taskId);

    List<Task> findAllByFinishDate(Date finishDate);

    List<Task> findAllByStartDate(Date startDate);

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

    // FK search
    List<Task> findAllByUser(User user);

    List<Task> findAllByProject(Project project);
}
