package com.example.IS.rest;

import com.example.IS.models.AuthRequest;
import com.example.IS.models.AuthResponse;
import com.example.IS.models.RegisterRequest;
import com.example.IS.models.User;
import com.example.IS.security.JwtProvider;
import com.example.IS.serviceImpl.repoImpl.UserServiceRepoImpl;
import com.example.IS.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UserServiceRepoImpl userService;
    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setSurname(request.getSurname());
        user.setPassword(request.getPassword());
        user.setLogin(request.getLogin());
        user.setPatronym(request.getPatronym());
        user.setHireDate(request.getHireDate());
        user.setDismissalDate(request.getDismissalDate());
        user.setPosition(request.getPosition());
        user.setRole(request.getRole());
        user.setDepartment(request.getDepartment());
        userService.create(user);
        return "OK";
    }

    @PostMapping("/login")
    public AuthResponse auth(@RequestBody AuthRequest authRequest) {
        AuthResponse response = new AuthResponse();
        String login = authRequest.getLogin();
        String password = authRequest.getPassword();
        User user = userService.getByLogin(login);
        if(user != null && BCrypt.checkpw(password, user.getPassword())) {
            response.setToken(jwtProvider.generateToken(login));
            response.setRole(user.getRole());
        }
        else
            response.setToken("User not found");
        return response;
    }
}
