package com.example.IS.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "task_type")
@Getter
@Setter
@ToString
public class TaskType {
    @Id
    @SequenceGenerator(name = "task_type_seq", sequenceName =
            "task_type_sequence", allocationSize = 1)
    @GeneratedValue(generator = "task_type_seq", strategy =
            GenerationType.SEQUENCE)
    @Column(name = "task_type_id")
    private int taskTypeId;

    @Size(max = 30, message = "Size should be not more than 30")
    @Column(name = "task_type")
    private String taskType;
}
