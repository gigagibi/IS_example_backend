package com.example.IS.service;

import com.example.IS.models.Department;
import com.example.IS.models.Position;
import com.example.IS.models.User;
import com.example.IS.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public interface UserService {
     User getById(int userId);
    
     List<User> createUser(User user);

     List<User> deleteUser(int userId);

     List<User> updateUser(int userId, User user);

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

     List<User> getAllByPosition (Position position);
}

