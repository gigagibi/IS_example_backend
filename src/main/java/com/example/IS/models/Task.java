package com.example.IS.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
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
    @Column(name = "task_id")
    private int taskId;

    @Size(max = 55, message = "Size should not be more than 55")
    @Column(name = "name")
    private String name;

    @Size(max = 500, message = "Size should not be more than 500")
    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "finish_date")
    private Date finishDate;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    public User user;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    public Project project;
}
