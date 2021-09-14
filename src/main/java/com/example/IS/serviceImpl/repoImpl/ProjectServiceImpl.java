package com.example.IS.serviceImpl.repoImpl;

import com.example.IS.models.Project;
import com.example.IS.models.User;
import com.example.IS.repositories.ProjectRepository;
import com.example.IS.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
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
    public List<Project> getAllByCustomer(String customer) {
        return null;
    }

    @Override
    public List<Project> getAllByFactCost(int factCost) {
        return null;
    }

    @Override
    public List<Project> getAllByFactProfit(int factCost) {
        return null;
    }

    @Override
    public List<Project> getAllByPlannedCost(int factCost) {
        return null;
    }

    @Override
    public List<Project> getAllByPlannedProfit(int factCost) {
        return null;
    }

    @Override
    public List<Project> getAllByFactCostIsBetween(int min, int max) {
        return null;
    }

    @Override
    public List<Project> getAllByPlannedCostIsBetween(int min, int max) {
        return null;
    }

    @Override
    public List<Project> getAllByFactProfitIsBetween(int min, int max) {
        return null;
    }

    @Override
    public List<Project> getAllByPlannedProfitIsBetween(int min, int max) {
        return null;
    }

    @Override
    public List<Project> getAllByPlannedStartDateIsBetween(Date min, Date max) {
        return null;
    }

    @Override
    public List<Project> getAllByFactStartDateIsBetween(Date min, Date max) {
        return null;
    }

    @Override
    public List<Project> getAllByPlannedFinishDateIsBetween(Date min, Date max) {
        return null;
    }

    @Override
    public List<Project> getAllByFactFinishDateIsBetween(Date min, Date max) {
        return null;
    }

    @Override
    public List<Project> getAllByFactCostGreaterThanEqual(int value) {
        return null;
    }

    @Override
    public List<Project> getAllByPlannedCostGreaterThanEqual(int value) {
        return null;
    }

    @Override
    public List<Project> getAllByFactProfitGreaterThanEqual(int value) {
        return null;
    }

    @Override
    public List<Project> getAllByPlannedProfitGreaterThanEqual(int value) {
        return null;
    }

    @Override
    public List<Project> getAllByPlannedStartDateIsAfter(Date value) {
        return null;
    }

    @Override
    public List<Project> getAllByFactStartDateIsAfter(Date value) {
        return null;
    }

    @Override
    public List<Project> getAllByPlannedFinishDateIsAfter(Date value) {
        return null;
    }

    @Override
    public List<Project> getAllByFactFinishDateIsAfter(Date value) {
        return null;
    }

    @Override
    public List<Project> getAllByFactCostGreaterThan(int value) {
        return null;
    }

    @Override
    public List<Project> getAllByPlannedCostGreaterThan(int value) {
        return null;
    }

    @Override
    public List<Project> getAllByFactProfitGreaterThan(int value) {
        return null;
    }

    @Override
    public List<Project> getAllByPlannedProfitGreaterThan(int value) {
        return null;
    }

    @Override
    public List<Project> getAllByPlannedStartDateAfter(Date value) {
        return null;
    }

    @Override
    public List<Project> getAllByFactStartDateAfter(Date value) {
        return null;
    }

    @Override
    public List<Project> getAllByPlannedFinishDateAfter(Date value) {
        return null;
    }

    @Override
    public List<Project> getAllByFactFinishDateAfter(Date value) {
        return null;
    }

    @Override
    public List<Project> getAllByFactCostLessThanEqual(int value) {
        return null;
    }

    @Override
    public List<Project> getAllByPlannedCostLessThanEqual(int value) {
        return null;
    }

    @Override
    public List<Project> getAllByFactProfitLessThanEqual(int value) {
        return null;
    }

    @Override
    public List<Project> getAllByPlannedProfitLessThanEqual(int value) {
        return null;
    }

    @Override
    public List<Project> getAllByPlannedStartDateIsBefore(Date value) {
        return null;
    }

    @Override
    public List<Project> getAllByFactStartDateIsBefore(Date value) {
        return null;
    }

    @Override
    public List<Project> getAllByPlannedFinishDateIsBefore(Date value) {
        return null;
    }

    @Override
    public List<Project> getAllByFactFinishDateIsBefore(Date value) {
        return null;
    }

    @Override
    public List<Project> getAllByFactCostLessThan(int value) {
        return null;
    }

    @Override
    public List<Project> getAllByPlannedCostLessThan(int value) {
        return null;
    }

    @Override
    public List<Project> getAllByFactProfitLessThan(int value) {
        return null;
    }

    @Override
    public List<Project> getAllByPlannedProfitLessThan(int value) {
        return null;
    }

    @Override
    public List<Project> getAllByPlannedStartDateBefore(Date value) {
        return null;
    }

    @Override
    public List<Project> getAllByFactStartDateBefore(Date value) {
        return null;
    }

    @Override
    public List<Project> getAllByPlannedFinishDateBefore(Date value) {
        return null;
    }

    @Override
    public List<Project> getAllByFactFinishDateBefore(Date value) {
        return null;
    }

    @Override
    public List<Project> deleteAllByCustomer(String customer) {
        return null;
    }

    @Override
    public List<Project> deleteByName(String name) {
        return null;
    }

    @Override
    public Project getByProjectManager(User user) {
        return null;
    }

    @Override
    public List<Project> deleteByProjectManager(User user) {
        return null;
    }
}
