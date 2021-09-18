package com.example.IS.services;

import com.example.IS.models.Department;
import com.example.IS.models.Project;
import com.example.IS.models.User;

import java.util.Date;
import java.util.List;

public interface ProjectService {
    Project getById(int projectId);

    List<Project> create(Project Project);

    List<Project> delete(int projectId);

    List<Project> update(int projectId, Project project);

    List<Project> getAll();

    List<Project> getByName(String name);

    List<Project> getAllByCustomer(String customer);

    List<Project> getAllByFactCost(int factCost);

    List<Project> getAllByFactProfit(int factProfit);

    List<Project> getAllByPlannedCost(int plannedCost);

    List<Project> getAllByPlannedProfit(int plannedProfit);

    List<Project> getAllByFactCostIsBetween(int min, int max);

    List<Project> getAllByPlannedCostIsBetween(int min, int max);

    List<Project> getAllByFactProfitIsBetween(int min, int max);

    List<Project> getAllByPlannedProfitIsBetween(int min, int max);

    List<Project> getAllByPlannedStartDateIsBetween(Date min, Date max);

    List<Project> getAllByFactStartDateIsBetween(Date min, Date max);

    List<Project> getAllByPlannedFinishDateIsBetween(Date min, Date max);

    List<Project> getAllByFactFinishDateIsBetween(Date min, Date max);

    List<Project> getAllByFactCostGreaterThanEqual(int value);

    List<Project> getAllByPlannedCostGreaterThanEqual(int value);

    List<Project> getAllByFactProfitGreaterThanEqual(int value);

    List<Project> getAllByPlannedProfitGreaterThanEqual(int value);

    List<Project> getAllByPlannedStartDateIsAfter(Date value);

    List<Project> getAllByFactStartDateIsAfter(Date value);

    List<Project> getAllByPlannedFinishDateIsAfter(Date value);

    List<Project> getAllByFactFinishDateIsAfter(Date value);

    List<Project> getAllByFactCostGreaterThan(int value);

    List<Project> getAllByPlannedCostGreaterThan(int value);

    List<Project> getAllByFactProfitGreaterThan(int value);

    List<Project> getAllByPlannedProfitGreaterThan(int value);

    List<Project> getAllByPlannedStartDateAfter(Date value);

    List<Project> getAllByFactStartDateAfter(Date value);

    List<Project> getAllByPlannedFinishDateAfter(Date value);

    List<Project> getAllByFactFinishDateAfter(Date value);

    List<Project> getAllByFactCostLessThanEqual(int value);

    List<Project> getAllByPlannedCostLessThanEqual(int value);

    List<Project> getAllByFactProfitLessThanEqual(int value);

    List<Project> getAllByPlannedProfitLessThanEqual(int value);

    List<Project> getAllByPlannedStartDateIsBefore(Date value);

    List<Project> getAllByFactStartDateIsBefore(Date value);

    List<Project> getAllByPlannedFinishDateIsBefore(Date value);

    List<Project> getAllByFactFinishDateIsBefore(Date value);

    List<Project> getAllByFactCostLessThan(int value);

    List<Project> getAllByPlannedCostLessThan(int value);

    List<Project> getAllByFactProfitLessThan(int value);

    List<Project> getAllByPlannedProfitLessThan(int value);

    List<Project> getAllByPlannedStartDateBefore(Date value);

    List<Project> getAllByFactStartDateBefore(Date value);

    List<Project> getAllByPlannedFinishDateBefore(Date value);

    List<Project> getAllByFactFinishDateBefore(Date value);

    List<Project> deleteAllByCustomer(String customer);

    List<Project> deleteByName(String name);

    List<Project> deleteAll();

    List<Project> getProjectsByUserId(int userId);

    List<Project> getProjectsByPMId(int PMId);

    Project getProjectByTaskId(int taskId);
}
