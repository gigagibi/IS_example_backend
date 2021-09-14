package com.example.IS.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "positions")
@Getter
@Setter
@ToString
public class Position {
    @Id
    @SequenceGenerator(name = "position_seq", sequenceName =
            "position_sequence", allocationSize = 1)
    @GeneratedValue(generator = "position_seq", strategy =
            GenerationType.SEQUENCE)
    @Column(name = "pos_id")
    private int positionId;

    @Column(name = "name")
    @Size(max = 30, message = "Size should not be more than 30 symbols")
    private String name;

    @Column(name = "grade")
    private int grade;
}
