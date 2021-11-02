package com.example.IS.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Getter
@Setter
@ToString
public class Role {
    @Id
    @SequenceGenerator(name = "role_seq", sequenceName =
            "role_sequence", allocationSize = 1)
    @GeneratedValue(generator = "role_seq", strategy =
            GenerationType.SEQUENCE)
    @Column(name = "role_id")
    private int roleId;

    @Column(name = "name")
    private String name;
}
