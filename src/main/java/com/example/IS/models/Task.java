package com.example.IS.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@ToString
public class Task {
    @Id
    @SequenceGenerator(name = "task_seq", sequenceName =
            "task_sequence", allocationSize = 1)
    @GeneratedValue(generator = "task_seq", strategy =
            GenerationType.SEQUENCE)
    private int taskId;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "finish_date")
    private Date finishDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;

    @ManyToOne
    @JoinColumn(name = "project_id")
    public Project project;
}
