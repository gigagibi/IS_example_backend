package com.example.IS.security;

import com.example.IS.models.User;
import com.example.IS.serviceImpl.repoImpl.UserServiceRepoImpl;
import com.example.IS.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserServiceRepoImpl userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByLogin(username);
        return CustomUserDetails.fromUserEntityToCustomUserDetails(user);
    }
}
