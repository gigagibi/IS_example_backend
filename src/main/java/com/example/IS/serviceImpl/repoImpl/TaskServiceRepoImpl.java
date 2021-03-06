package com.example.IS.serviceImpl.repoImpl;

import com.example.IS.exceptions.UserAndTaskNotMatchException;
import com.example.IS.models.Project;
import com.example.IS.models.Task;
import com.example.IS.models.User;
import com.example.IS.repositories.TaskRepository;
import com.example.IS.repositories.UserRepository;
import com.example.IS.security.JwtProvider;
import com.example.IS.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TaskServiceRepoImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    public boolean checkUserAndTask(String token, int taskId) {
        User user = userRepository.findByLogin(jwtProvider.getLoginFromToken(token));
        Task task = taskRepository.findByTaskId(taskId);
        return (task.getUser().getUserId() == user.getUserId() || user.getRole().getName().equals("ROLE_ADMIN"));
    }

    @Override
    public Task getById(int taskId) {
        return taskRepository.findByTaskId(taskId);
    }

    @Override
    public List<Task> create(Task task) {
        taskRepository.saveAndFlush(task);
        return taskRepository.findAll();
    }

    @Override
    public List<Task> delete(int taskId) {
        taskRepository.deleteById(taskId);
        return taskRepository.findAll();
    }

    @Override
    public List<Task> update(int taskId, Task task) {
        taskRepository.updateTask(taskId, task.getName(), task.getDescription(), task.getStartDate(), task.getFinishDate(), task.getProject(), task.getUser());
        return taskRepository.findAll();
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> getByName(String name) {
        return taskRepository.findAllByName(name);
    }

    @Override
    public List<Task> getAllByFinishDate(Date finishDate) {
        return taskRepository.findAllByFinishDate(finishDate);
    }

    @Override
    public List<Task> getAllByStartDate(Date startDate) {
        return taskRepository.findAllByStartDate(startDate);
    }

    @Override
    public List<Task> getAllByFinishDateBetween(Date min, Date max) {
        return taskRepository.findAllByFinishDateBetween(min, max);
    }

    @Override
    public List<Task> getAllByStartDateBetween(Date min, Date max) {
        return taskRepository.findAllByStartDateBetween(min, max);
    }

    @Override
    public List<Task> getAllByStartDateBefore(Date value) {
        return taskRepository.findAllByStartDateBefore(value);
    }

    @Override
    public List<Task> getAllByFinishDateBefore(Date value) {
        return taskRepository.findAllByFinishDateBefore(value);
    }

    @Override
    public List<Task> getAllByStartDateAfter(Date value) {
        return taskRepository.findAllByStartDateAfter(value);
    }

    @Override
    public List<Task> getAllByFinishDateAfter(Date value) {
        return taskRepository.findAllByFinishDateAfter(value);
    }

    @Override
    public List<Task> getAllByStartDateIsBefore(Date value) {
        return taskRepository.findAllByStartDateIsBefore(value);
    }

    @Override
    public List<Task> getAllByFinishDateIsBefore(Date value) {
        return taskRepository.findAllByFinishDateIsBefore(value);
    }

    @Override
    public List<Task> getAllByStartDateIsAfter(Date value) {
        return taskRepository.findAllByStartDateIsAfter(value);
    }

    @Override
    public List<Task> getAllByFinishDateIsAfter(Date value) {
        return taskRepository.findAllByFinishDateIsAfter(value);
    }

    @Override
    public List<Task> deleteAll() {
        taskRepository.deleteAll();
        return taskRepository.findAll();
    }

    @Override
    public List<Task> getAllByUser(User user) {
        return taskRepository.findAllByUser(user);
    }

    @Override
    public List<Task> getAllByProject(Project project) {
        return taskRepository.findAllByProject(project);
    }

    @Override
    public List<Task> getAllByUserId(int userId) {
        return taskRepository.findAll().stream().filter(e -> e.user.getUserId() == userId).collect(Collectors.toList());
    }

    @Override
    public List<Task> getAllByProjectId(int projectId) {
        return taskRepository.findAll().stream().filter(e -> e.project.getProjectId() == projectId).collect(Collectors.toList());
    }

    @Override
    public List<Task> getAllByTaskTypeId(int taskTypeId) {
        return null;
    }

    @Override
    public List<Task> getAllByTaskType(String taskType) {
        return null;
    }

    @Override
    public Task closeTask(String token, int taskId) throws UserAndTaskNotMatchException {
        if(checkUserAndTask(token, taskId)) {
            taskRepository.changeTaskFinishDate(taskId, java.sql.Date.valueOf(LocalDate.now()));
            return taskRepository.getById(taskId);
        }
        else
            throw new UserAndTaskNotMatchException();
    }

    @Override
    public List<Task> getTasksByToken(String token) {
        return taskRepository.findAllByUser(userRepository.findByLogin(jwtProvider.getLoginFromToken(token)));
    }
}
