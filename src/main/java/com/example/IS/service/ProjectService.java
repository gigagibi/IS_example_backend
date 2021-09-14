package com.example.IS.service;

import com.example.IS.models.Project;
import com.example.IS.models.User;

import java.util.Date;
import java.util.List;

public interface ProjectService {
    public Project getById(int projectId);

    public List<Project> createProject(Project Project);

    public List<Project> deleteProject(int projectId);

    public List<Project> updateProject(int projectId, Project project);

    public List<Project> getAll();

    public Project getByName(String name);

    public List<Project> getAllByCustomer(String customer);

    public List<Project> getAllByFactCost(int factCost);

    public List<Project> getAllByFactProfit(int factCost);

    public List<Project> getAllByPlannedCost(int factCost);

    public List<Project> getAllByPlannedProfit(int factCost);

    public List<Project> getAllByFactCostIsBetween(int min, int max);

    public List<Project> getAllByPlannedCostIsBetween(int min, int max);

    public List<Project> getAllByFactProfitIsBetween(int min, int max);

    public List<Project> getAllByPlannedProfitIsBetween(int min, int max);

    public List<Project> getAllByPlannedStartDateIsBetween(Date min, Date max);

    public List<Project> getAllByFactStartDateIsBetween(Date min, Date max);

    public List<Project> getAllByPlannedFinishDateIsBetween(Date min, Date max);

    public List<Project> getAllByFactFinishDateIsBetween(Date min, Date max);

    public List<Project> getAllByFactCostGreaterThanEqual(int value);

    public List<Project> getAllByPlannedCostGreaterThanEqual(int value);

    public List<Project> getAllByFactProfitGreaterThanEqual(int value);

    public List<Project> getAllByPlannedProfitGreaterThanEqual(int value);

    public List<Project> getAllByPlannedStartDateIsAfter(Date value);

    public List<Project> getAllByFactStartDateIsAfter(Date value);

    public List<Project> getAllByPlannedFinishDateIsAfter(Date value);

    public List<Project> getAllByFactFinishDateIsAfter(Date value);

    public List<Project> getAllByFactCostGreaterThan(int value);

    public List<Project> getAllByPlannedCostGreaterThan(int value);

    public List<Project> getAllByFactProfitGreaterThan(int value);

    public List<Project> getAllByPlannedProfitGreaterThan(int value);

    public List<Project> getAllByPlannedStartDateAfter(Date value);

    public List<Project> getAllByFactStartDateAfter(Date value);

    public List<Project> getAllByPlannedFinishDateAfter(Date value);

    public List<Project> getAllByFactFinishDateAfter(Date value);

    public List<Project> getAllByFactCostLessThanEqual(int value);

    public List<Project> getAllByPlannedCostLessThanEqual(int value);

    public List<Project> getAllByFactProfitLessThanEqual(int value);

    public List<Project> getAllByPlannedProfitLessThanEqual(int value);

    public List<Project> getAllByPlannedStartDateIsBefore(Date value);

    public List<Project> getAllByFactStartDateIsBefore(Date value);

    public List<Project> getAllByPlannedFinishDateIsBefore(Date value);

    public List<Project> getAllByFactFinishDateIsBefore(Date value);

    public List<Project> getAllByFactCostLessThan(int value);

    public List<Project> getAllByPlannedCostLessThan(int value);

    public List<Project> getAllByFactProfitLessThan(int value);

    public List<Project> getAllByPlannedProfitLessThan(int value);

    public List<Project> getAllByPlannedStartDateBefore(Date value);

    public List<Project> getAllByFactStartDateBefore(Date value);

    public List<Project> getAllByPlannedFinishDateBefore(Date value);

    public List<Project> getAllByFactFinishDateBefore(Date value);

    public List<Project> deleteAllByCustomer(String customer);

    public List<Project> deleteByName(String name);

    Project getByProjectManager(User user);

    List<Project> deleteByProjectManager(User user);
}
