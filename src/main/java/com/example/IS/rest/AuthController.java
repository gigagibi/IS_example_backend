package com.example.IS.rest;

import com.example.IS.models.AuthRequest;
import com.example.IS.models.User;
import com.example.IS.security.JwtProvider;
import com.example.IS.serviceImpl.repoImpl.UserServiceRepoImpl;
import com.example.IS.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String registerUser(@RequestBody AuthRequest authRequest) {
        User u = new User();
        u.setPassword(authRequest.getPassword());
        u.setLogin(authRequest.getLogin());
        userService.create(u);
        return "OK";
    }

    @PostMapping("/auth")
    public String auth(@RequestBody AuthRequest authRequest) {
        String login = authRequest.getLogin();
        String password = authRequest.getPassword();
        if(userService.getByLoginAndPassword(login, password) != null)
            return jwtProvider.generateToken(login, password);
        else
            return "User not found";
    }
}
