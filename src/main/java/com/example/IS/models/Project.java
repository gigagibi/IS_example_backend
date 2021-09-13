package com.example.IS.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "projects")
@Getter
@Setter
@ToString
public class Project {
    @Id
    @SequenceGenerator(name = "project_seq", sequenceName =
            "project_sequence", allocationSize = 1)
    @GeneratedValue(generator = "project_seq", strategy =
            GenerationType.SEQUENCE)
    private int projectId;

    @Column(name = "name")
    @Size(max = 50, message = "Size should not be more than 50 symbols")
    private String name;

    @Column(name = "description")
    @Size(max = 1100, message = "Size should not be more than 55 symbols")
    private String description;

    @Column(name = "customer")
    @Size(max = 55, message = "Size should not be more than 55 symbols")
    private String customer;

    @Column(name = "planned_start_date")
    private Date plannedStartDate;

    @Column(name = "fact_start_date")
    private Date factStartDate;

    @Column(name = "planned_finish_date")
    private Date plannedFinishDate;

    @Column(name = "fact_finish_date")
    private Date factFinishDate;

    @Column(name = "planned_cost")
    private int plannedCost;

    @Column(name = "planned_profit")
    private int plannedProfit;

    @Column(name = "fact_cost")
    private int factCost;

    @Column(name = "fact_profit")
    private int factProfit;

    @OneToOne
    @JoinColumn(name = "user_id")
    public User user;

}
