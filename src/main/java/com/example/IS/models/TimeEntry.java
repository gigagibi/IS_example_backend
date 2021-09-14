package com.example.IS.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Time;
import java.time.OffsetDateTime;
import java.util.Date;

@Entity
@Table(name = "time_entries")
@Getter
@Setter
@ToString
public class TimeEntry {
    @Id
    @SequenceGenerator(name = "time_entry_seq", sequenceName =
            "time_entry_sequence", allocationSize = 1)
    @GeneratedValue(generator = "time_entry_seq", strategy =
            GenerationType.SEQUENCE)
    @Column(name = "entry_id")
    private int timeEntryId;

    @Column(name = "hours")
    private int hours;

    @Column(name = "entry_date")
    private OffsetDateTime entryDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;

    @ManyToOne
    @JoinColumn(name = "task_id")
    public Task task;
}
