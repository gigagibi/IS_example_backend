package com.example.IS.serviceImpl.repoImpl;

import com.example.IS.models.Project;
import com.example.IS.models.Task;
import com.example.IS.models.User;
import com.example.IS.repositories.ProjectRepository;
import com.example.IS.repositories.TaskRepository;
import com.example.IS.repositories.UserRepository;
import com.example.IS.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectServiceRepoImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    @Override
    public Project getById(int projectId) {
        return projectRepository.findByProjectId(projectId);
    }

    @Override
    public List<Project> create(Project project) {
        projectRepository.saveAndFlush(project);
        return projectRepository.findAll();
    }

    @Override
    public List<Project> delete(int projectId) {
        projectRepository.deleteById(projectId);
        return projectRepository.findAll();
    }

    @Override
    public List<Project> update(int projectId, Project project) {
        projectRepository.updateProject(projectId, project.getName(), project.getDescription(), project.getCustomer(), project.getPlannedStartDate(), project.getFactStartDate(), project.getPlannedFinishDate(), project.getFactFinishDate(), project.getPlannedCost(), project.getFactCost(), project.getPlannedProfit(), project.getFactProfit());
        return projectRepository.findAll();
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public List<Project> getByName(String name) {
        return projectRepository.findAllByName(name);
    }

    @Override
    public List<Project> getAllByCustomer(String customer) {
        return projectRepository.findAllByCustomer(customer);
    }

    @Override
    public List<Project> getAllByFactCost(int factCost) {
        return projectRepository.findAllByFactCost(factCost);
    }

    @Override
    public List<Project> getAllByFactProfit(int factProfit) {
        return projectRepository.findAllByFactProfit(factProfit);
    }

    @Override
    public List<Project> getAllByPlannedCost(int plannedCost) {
        return projectRepository.findAllByPlannedCost(plannedCost);
    }

    @Override
    public List<Project> getAllByPlannedProfit(int plannedProfit) {
        return projectRepository.findAllByPlannedProfit(plannedProfit);
    }

    @Override
    public List<Project> getAllByFactCostIsBetween(int min, int max) {
        return projectRepository.findAllByFactCostIsBetween(min, max);
    }

    @Override
    public List<Project> getAllByPlannedCostIsBetween(int min, int max) {
        return projectRepository.findAllByPlannedCostIsBetween(min, max);
    }

    @Override
    public List<Project> getAllByFactProfitIsBetween(int min, int max) {
        return projectRepository.findAllByFactProfitIsBetween(min, max);
    }

    @Override
    public List<Project> getAllByPlannedProfitIsBetween(int min, int max) {
        return projectRepository.findAllByPlannedProfitIsBetween(min, max);
    }

    @Override
    public List<Project> getAllByPlannedStartDateIsBetween(Date min, Date max) {
        return projectRepository.findAllByPlannedStartDateIsBetween(min, max);
    }

    @Override
    public List<Project> getAllByFactStartDateIsBetween(Date min, Date max) {
        return projectRepository.findAllByFactStartDateIsBetween(min, max);
    }

    @Override
    public List<Project> getAllByPlannedFinishDateIsBetween(Date min, Date max) {
        return projectRepository.findAllByPlannedFinishDateIsBetween(min, max);
    }

    @Override
    public List<Project> getAllByFactFinishDateIsBetween(Date min, Date max) {
        return projectRepository.findAllByFactFinishDateIsBetween(min, max);
    }

    @Override
    public List<Project> getAllByFactCostGreaterThanEqual(int value) {
        return projectRepository.findAllByFactCostGreaterThanEqual(value);
    }

    @Override
    public List<Project> getAllByPlannedCostGreaterThanEqual(int value) {
        return projectRepository.findAllByPlannedCostGreaterThanEqual(value);
    }

    @Override
    public List<Project> getAllByFactProfitGreaterThanEqual(int value) {
        return projectRepository.findAllByFactProfitGreaterThanEqual(value);
    }

    @Override
    public List<Project> getAllByPlannedProfitGreaterThanEqual(int value) {
        return projectRepository.findAllByPlannedProfitGreaterThanEqual(value);
    }

    @Override
    public List<Project> getAllByPlannedStartDateIsAfter(Date value) {
        return projectRepository.findAllByPlannedStartDateIsAfter(value);
    }

    @Override
    public List<Project> getAllByFactStartDateIsAfter(Date value) {
        return projectRepository.findAllByFactStartDateIsAfter(value);
    }

    @Override
    public List<Project> getAllByPlannedFinishDateIsAfter(Date value) {
        return projectRepository.findAllByPlannedFinishDateIsAfter(value);
    }

    @Override
    public List<Project> getAllByFactFinishDateIsAfter(Date value) {
        return projectRepository.findAllByFactFinishDateIsAfter(value);
    }

    @Override
    public List<Project> getAllByFactCostGreaterThan(int value) {
        return projectRepository.findAllByFactCostGreaterThan(value);
    }

    @Override
    public List<Project> getAllByPlannedCostGreaterThan(int value) {
        return projectRepository.findAllByPlannedCostGreaterThan(value);
    }

    @Override
    public List<Project> getAllByFactProfitGreaterThan(int value) {
        return projectRepository.findAllByFactProfitGreaterThan(value);
    }

    @Override
    public List<Project> getAllByPlannedProfitGreaterThan(int value) {
        return projectRepository.findAllByPlannedProfitGreaterThan(value);
    }

    @Override
    public List<Project> getAllByPlannedStartDateAfter(Date value) {
        return projectRepository.findAllByPlannedStartDateAfter(value);
    }

    @Override
    public List<Project> getAllByFactStartDateAfter(Date value) {
        return projectRepository.findAllByFactStartDateAfter(value);
    }

    @Override
    public List<Project> getAllByPlannedFinishDateAfter(Date value) {
        return projectRepository.findAllByPlannedFinishDateAfter(value);
    }

    @Override
    public List<Project> getAllByFactFinishDateAfter(Date value) {
        return projectRepository.findAllByFactFinishDateAfter(value);
    }

    @Override
    public List<Project> getAllByFactCostLessThanEqual(int value) {
        return projectRepository.findAllByFactCostLessThanEqual(value);
    }

    @Override
    public List<Project> getAllByPlannedCostLessThanEqual(int value) {
        return projectRepository.findAllByPlannedCostLessThanEqual(value);
    }

    @Override
    public List<Project> getAllByFactProfitLessThanEqual(int value) {
        return projectRepository.findAllByFactProfitLessThanEqual(value);
    }

    @Override
    public List<Project> getAllByPlannedProfitLessThanEqual(int value) {
        return projectRepository.findAllByPlannedProfitLessThanEqual(value);
    }

    @Override
    public List<Project> getAllByPlannedStartDateIsBefore(Date value) {
        return projectRepository.findAllByPlannedStartDateIsBefore(value);
    }

    @Override
    public List<Project> getAllByFactStartDateIsBefore(Date value) {
        return projectRepository.findAllByFactStartDateIsBefore(value);
    }

    @Override
    public List<Project> getAllByPlannedFinishDateIsBefore(Date value) {
        return projectRepository.findAllByPlannedFinishDateIsBefore(value);
    }

    @Override
    public List<Project> getAllByFactFinishDateIsBefore(Date value) {
        return projectRepository.findAllByFactFinishDateIsBefore(value);
    }

    @Override
    public List<Project> getAllByFactCostLessThan(int value) {
        return projectRepository.findAllByFactCostLessThan(value);
    }

    @Override
    public List<Project> getAllByPlannedCostLessThan(int value) {
        return projectRepository.findAllByPlannedCostLessThan(value);
    }

    @Override
    public List<Project> getAllByFactProfitLessThan(int value) {
        return projectRepository.findAllByFactProfitLessThan(value);
    }

    @Override
    public List<Project> getAllByPlannedProfitLessThan(int value) {
        return projectRepository.findAllByPlannedProfitLessThan(value);
    }

    @Override
    public List<Project> getAllByPlannedStartDateBefore(Date value) {
        return projectRepository.findAllByPlannedStartDateBefore(value);
    }

    @Override
    public List<Project> getAllByFactStartDateBefore(Date value) {
        return projectRepository.findAllByFactStartDateBefore(value);
    }

    @Override
    public List<Project> getAllByPlannedFinishDateBefore(Date value) {
        return projectRepository.findAllByPlannedFinishDateBefore(value);
    }

    @Override
    public List<Project> getAllByFactFinishDateBefore(Date value) {
        return projectRepository.findAllByFactFinishDateBefore(value);
    }

    @Override
    public List<Project> deleteAllByCustomer(String customer) {
        projectRepository.deleteAllByCustomer(customer);
        return projectRepository.findAll();
    }

    @Override
    public List<Project> deleteByName(String name) {
        projectRepository.deleteByName(name);
        return projectRepository.findAll();
    }

    @Override
    public List<Project> deleteAll() {
        projectRepository.deleteAll();
        return projectRepository.findAll();
    }

    @Override
    public List<Project> getProjectsByUserId(int userId) { // returns all projects that certain user has been working for
        List<Task> userTasks = taskRepository.findAll();
        userTasks.removeIf(e -> e.user.getId() != userId);
        List<Project> projects = new ArrayList<>();
        for(Task task : userTasks) {
            projects.add(task.project);
        }
        return projects.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public List<Project> getProjectsByPMId(int PMId) { //returns projects managed by certain project manager
        List<Task> userTasks = taskRepository.findAll();
        userTasks.removeIf(e -> (e.user.getId() != PMId || e.taskType.getTaskTypeId() != 1));
        List<Project> projects = new ArrayList<>();
        for(Task task : userTasks) {
            projects.add(task.project);
        }
        return projects.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public Project getProjectByTaskId(int taskId) {
        return taskRepository.getById(taskId).project;
    }
}
