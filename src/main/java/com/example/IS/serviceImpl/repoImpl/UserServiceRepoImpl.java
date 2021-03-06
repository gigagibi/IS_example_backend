package com.example.IS.serviceImpl.repoImpl;

import com.example.IS.models.*;
import com.example.IS.repositories.MessageRepository;
import com.example.IS.repositories.RoleRepository;
import com.example.IS.repositories.UserRepository;
import com.example.IS.security.JwtProvider;
import com.example.IS.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceRepoImpl implements UserService {
    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;
    private final MessageRepository messageRepository;
    private final RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User getById(int userId) {
        return userRepository.findByUserId(userId);
    }

    @Override
    public List<User> getAllByInitials(String name, String surname, String patronym) {
        List<User> users = userRepository.findAll();
        if(surname!= null && !surname.equals(""))
            users = users.stream().filter(e -> e.getSurname().equals(surname)).collect(Collectors.toList());
        if(name!= null && !name.equals(""))
            users = users.stream().filter(e -> e.getName().equals(name)).collect(Collectors.toList());
        if(patronym!= null && !patronym.equals(""))
            users = users.stream().filter(e -> e.getPatronym().equals(patronym)).collect(Collectors.toList());
        return users;
    }

    @Override
    public List<User> create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.saveAndFlush(user);
        return userRepository.findAll();
    }

    @Override
    public List<User> delete(int userId) {
        userRepository.deleteById(userId);
        return userRepository.findAll();
    }

    @Override
    public List<User> update(int userId, User user) {
        userRepository.updateUser(userId, user.getSurname(), user.getName(), user.getPatronym(), user.getHireDate(), user.getDismissalDate(), user.getEmail(), user.getPosition(), user.getDepartment());
        return userRepository.findAll();
    }


    @Override
    public List<User> getAll() { return userRepository.findAll(); }

    @Override
    public List<User> getAllByName(String name) {
        return userRepository.findAllByName(name);
    }

    @Override
    public List<User> getAllBySurname(String surname) {
        return userRepository.findAllBySurname(surname);
    }

    @Override
    public List<User> getAllByPatronym(String patronym) {
        return userRepository.findAllByPatronym(patronym);
    }

    @Override
    public List<User> getAllByNameAndSurname(String name, String surname) {
        return userRepository.findAllByNameAndSurname(name, surname);
    }

    @Override
    public List<User> getAllByNameAndSurnameAndPatronym(String name, String surname, String patronym) {
        return userRepository.findAllByNameAndSurnameAndPatronym(name, surname, patronym);
    }

    @Override
    public List<User> getAllByNameAndPatronym(String name, String patronym) {
        return userRepository.findAllByNameAndPatronym(name, patronym);
    }

    @Override
    public List<User> getAllByHireDate(Date hireDate) {
        return userRepository.findAllByHireDate(hireDate);
    }

    @Override
    public List<User> getAllByDismissalDate(Date dismisssalDate) {
        return userRepository.findAllByDismissalDate(dismisssalDate);
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getAllByHireDateBetween(Date min, Date max) {
        return userRepository.findAllByHireDateBetween(min, max);
    }

    @Override
    public List<User> getAllByDismissalDateBetween(Date min, Date max) {
        return userRepository.findAllByDismissalDateBetween(min, max);
    }

    @Override
    public List<User> getAllByHireDateIsAfter(Date value) {
        return userRepository.findAllByHireDateIsAfter(value);
    }

    @Override
    public List<User> getAllByDismissalDateIsAfter(Date value) {
        return userRepository.findAllByDismissalDateIsAfter(value);
    }

    @Override
    public List<User> getAllByHireDateAfter(Date value) {
        return userRepository.findAllByHireDateAfter(value);
    }

    @Override
    public List<User> getAllByDismissalDateAfter(Date value) {
        return userRepository.findAllByDismissalDateAfter(value);
    }

    @Override
    public List<User> getAllByHireDateIsBefore(Date value) {
        return userRepository.findAllByHireDateIsBefore(value);
    }

    @Override
    public List<User> getAllByDismissalDateIsBefore(Date value) {
        return userRepository.findAllByDismissalDateIsBefore(value);
    }

    @Override
    public List<User> getAllByHireDateBefore(Date value) {
        return userRepository.findAllByHireDateBefore(value);
    }

    @Override
    public List<User> getAllByDismissalDateBefore(Date value) {
        return userRepository.findAllByDismissalDateBefore(value);
    }

    @Override
    public List<User> getAllByDepartment(Department department) {
        return userRepository.findAllByDepartment(department);
    }

    @Override
    public List<User> getAllByDepartmentId(int departmentId) {
        return userRepository.findAll().stream().filter(e -> e.department.getDepartmentId() == departmentId).collect(Collectors.toList());
    }

    @Override
    public List<User> getAllByPosition(Position position) {
        return userRepository.findAllByPosition(position);
    }

    @Override
    public List<User> getAllByPositionId(int positionId) {
        return userRepository.findAll().stream().filter(e -> e.position.getPositionId() == positionId).collect(Collectors.toList());
    }

    @Override
    public List<User> deleteAll() {
        return null;
    }

    @Override
    public List<User> getMessagedUsers(String token) {
        User me = userRepository.findByLogin(jwtProvider.getLoginFromToken(token));
        return userRepository.findAll().stream().filter(e -> (messageRepository.findAllByReceiverAndSender(e, me).size()!=0 || messageRepository.findAllByReceiverAndSender(me, e).size()!=0)).collect(Collectors.toList());
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public User getByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User getByToken(String token) {
        return userRepository.findByLogin(jwtProvider.getLoginFromToken(token));
    }

    @Override
    public String getRoleByUserId(int userId) {
        return userRepository.findByUserId(userId).getRole().getName();
    }
}