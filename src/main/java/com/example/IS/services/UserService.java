package com.example.IS.services;

import com.example.IS.models.Department;
import com.example.IS.models.Position;
import com.example.IS.models.TimeEntry;
import com.example.IS.models.User;

import java.util.Date;
import java.util.List;

public interface UserService {
     User getById(int userId);
    
     List<User> create(User user);

     List<User> delete(int userId);

     List<User> update(int userId, User user);

     List<User> getAll();

     List<User> getAllByName(String name);

     List<User> getAllBySurname(String surname);

     List<User> getAllByPatronym(String patronym);

     List<User> getAllByNameAndSurname(String name, String surname);

     List<User> getAllByNameAndSurnameAndPatronym(String name, String surname, String patronym);

     List<User> getAllByNameAndPatronym(String name, String patronym);

     List<User> getAllByHireDate(Date hireDate);

     List<User> getAllByDismissalDate(Date dismisssalDate);

     User getByEmail(String email);

     List<User> getAllByHireDateBetween(Date min, Date max);

     List<User> getAllByDismissalDateBetween(Date min, Date max);

     List<User> getAllByHireDateIsAfter(Date value);

     List<User> getAllByDismissalDateIsAfter(Date value);

     List<User> getAllByHireDateAfter(Date value);

     List<User> getAllByDismissalDateAfter(Date value);

     List<User> getAllByHireDateIsBefore(Date value);

     List<User> getAllByDismissalDateIsBefore(Date value);

     List<User> getAllByHireDateBefore(Date value);

     List<User> getAllByDismissalDateBefore(Date value);

     List<User> getAllByDepartment(Department department);

    List<User> getAllByDepartmentId(int departmentId);

    List<User> getAllByPosition (Position position);

     List<User> getAllByPositionId(int positionId);

     List<User> deleteAll();

     User getByLogin(String login);

     String getRoleByUserId(int userId);
}

