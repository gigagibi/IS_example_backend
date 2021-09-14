package com.example.IS.repositories;

import com.example.IS.models.Department;
import com.example.IS.models.Position;
import com.example.IS.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer> {
    // search by value
    User findByUserId(int userId);

    List<User> findAllByName(String name);

    List<User> findAllBySurname(String surname);

    List<User> findAllByPatronym(String patronym);

    List<User> findAllByNameAndSurnameAndPatronym(String name, String surname, String patronym);

    List<User> findAllByNameAndSurname(String name, String surname);

    List<User> findAllByNameAndPatronym(String name, String patronym);

    List<User> findAllByHireDate(Date hireDate);

    List<User> findAllByDismissalDate(Date dissmissalDate);

    User findByEmail(String email);

    // filtration
    List<User> findAllByHireDateBetween(Date min, Date max);

    List<User> findAllByDismissalDateBetween(Date min, Date max);

    List<User> findAllByHireDateIsAfter(Date value);

    List<User> findAllByDismissalDateIsAfter(Date value);

    List<User> findAllByHireDateAfter(Date value);

    List<User> findAllByDismissalDateAfter(Date value);

    List<User> findAllByHireDateIsBefore(Date value);

    List<User> findAllByDismissalDateIsBefore(Date value);

    List<User> findAllByHireDateBefore(Date value);

    List<User> findAllByDismissalDateBefore(Date value);

    // FK search
    List<User> findAllByDepartment(Department department);

    List<User> findAllByPosition (Position position);
}