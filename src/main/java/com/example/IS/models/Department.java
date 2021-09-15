package com.example.IS.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="departments")
@Getter
@Setter
@ToString
public class Department {
    @Id
    @SequenceGenerator(name = "department_seq", sequenceName = "department_sequence", allocationSize = 1)
    @GeneratedValue(generator = "department_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "department_id")
    private int departmentId;

    @Column(name = "name")
    @Size(max = 55, message = "Size should not be more than 55 symbols")
    private String name;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "office_id", referencedColumnName = "office_id")
    public Office office;
}
