package com.example.IS.repositories;

import com.example.IS.models.Project;
import com.example.IS.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    //search by value
    Project findByProjectId(int projectId);

    List<Project> findAllByName(String name);

    List<Project> findAllByCustomer(String customer);

    List<Project> findAllByFactCost(int factCost);

    List<Project> findAllByFactProfit(int factCost);

    List<Project> findAllByPlannedCost(int factCost);

    List<Project> findAllByPlannedProfit(int factCost);

    // Between
    List<Project> findAllByFactCostIsBetween(int min, int max);

    List<Project> findAllByPlannedCostIsBetween(int min, int max);

    List<Project> findAllByFactProfitIsBetween(int min, int max);

    List<Project> findAllByPlannedProfitIsBetween(int min, int max);

    List<Project> findAllByPlannedStartDateIsBetween(Date min, Date max);

    List<Project> findAllByFactStartDateIsBetween(Date min, Date max);

    List<Project> findAllByPlannedFinishDateIsBetween(Date min, Date max);

    List<Project> findAllByFactFinishDateIsBetween(Date min, Date max);

    // Greater or equal
    List<Project> findAllByFactCostGreaterThanEqual(int value);

    List<Project> findAllByPlannedCostGreaterThanEqual(int value);

    List<Project> findAllByFactProfitGreaterThanEqual(int value);

    List<Project> findAllByPlannedProfitGreaterThanEqual(int value);

    List<Project> findAllByPlannedStartDateIsAfter(Date value);

    List<Project> findAllByFactStartDateIsAfter(Date value);

    List<Project> findAllByPlannedFinishDateIsAfter(Date value);

    List<Project> findAllByFactFinishDateIsAfter(Date value);

    // Greater
    List<Project> findAllByFactCostGreaterThan(int value);

    List<Project> findAllByPlannedCostGreaterThan(int value);

    List<Project> findAllByFactProfitGreaterThan(int value);

    List<Project> findAllByPlannedProfitGreaterThan(int value);

    List<Project> findAllByPlannedStartDateAfter(Date value);

    List<Project> findAllByFactStartDateAfter(Date value);

    List<Project> findAllByPlannedFinishDateAfter(Date value);

    List<Project> findAllByFactFinishDateAfter(Date value);

    // Less or equal
    List<Project> findAllByFactCostLessThanEqual(int value);

    List<Project> findAllByPlannedCostLessThanEqual(int value);

    List<Project> findAllByFactProfitLessThanEqual(int value);

    List<Project> findAllByPlannedProfitLessThanEqual(int value);

    List<Project> findAllByPlannedStartDateIsBefore(Date value);

    List<Project> findAllByFactStartDateIsBefore(Date value);

    List<Project> findAllByPlannedFinishDateIsBefore(Date value);

    List<Project> findAllByFactFinishDateIsBefore(Date value);

    // Less
    List<Project> findAllByFactCostLessThan(int value);

    List<Project> findAllByPlannedCostLessThan(int value);

    List<Project> findAllByFactProfitLessThan(int value);

    List<Project> findAllByPlannedProfitLessThan(int value);

    List<Project> findAllByPlannedStartDateBefore(Date value);

    List<Project> findAllByFactStartDateBefore(Date value);

    List<Project> findAllByPlannedFinishDateBefore(Date value);

    List<Project> findAllByFactFinishDateBefore(Date value);

    // Delete
    void deleteAllByCustomer(String customer);

    void deleteByProjectId(int projectId);

    void deleteByName(String name);

    // FK search
    Project findByUser(User user);
}
