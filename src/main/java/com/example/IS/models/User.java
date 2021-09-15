package com.example.IS.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
public class User {
    @Id
    @SequenceGenerator(name = "user_seq", sequenceName =
            "user_sequence", allocationSize = 1)
    @GeneratedValue(generator = "user_seq", strategy =
            GenerationType.SEQUENCE)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "surname")
    private String surname;

    @Column(name = "name")
    private String name;

    @Column(name = "patronym")
    private String patronym;

    @Column(name = "hire_date")
    private Date hireDate;

    @Column(name = "dismissal_date")
    private Date dismissalDate;

    @Column(name = "email")
    private String email;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "department_id", referencedColumnName = "department_id")
    public Department department;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "position_id", referencedColumnName = "pos_id")
    public Position position;
}
