package com.example.IS.repositories;

import com.example.IS.models.Department;
import com.example.IS.models.Position;
import com.example.IS.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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

//    @Modifying
//    @Query(value = "update users set surname = ?2, name = ?3, patronym = ?4, hire_date = ?5, dismissal_date = ?6, email = ?7, position_id = ?8, department_id = ?9 where user_id= ?1", nativeQuery = true)
//    void updateUser(int id, String surname, String name, String patronym,  hire_date, Date dismissal_date, String email, int positionId, int departmentId);

    @Modifying
    @Query(value = "update User set surname = ?2, name = ?3, patronym = ?4, hireDate = ?5, dismissalDate = ?6, email = ?7, position = ?8, department = ?9 where userId= ?1")
        void updateUser(int id, String surname, String name, String patronym, Date hire_date, Date dismissal_date, String email, Position position, Department department);
}