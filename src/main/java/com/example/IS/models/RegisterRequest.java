package com.example.IS.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String surname;

    private String name;

    private String patronym;

    private Date hireDate;

    private Date dismissalDate;

    private String email;

    public Department department;

    public Position position;

    private Role role;

    private String login;

    private String password;
}
