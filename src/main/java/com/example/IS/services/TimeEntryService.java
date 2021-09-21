package com.example.IS.services;

import com.example.IS.models.Department;
import com.example.IS.models.Task;
import com.example.IS.models.TimeEntry;
import com.example.IS.models.User;

import java.time.OffsetDateTime;
import java.util.List;

public interface TimeEntryService {
    TimeEntry getById(int timeEntryId);

    List<TimeEntry> create(TimeEntry TimeEntry);

    List<TimeEntry> delete(int timeEntryId);

    List<TimeEntry> update(int timeEntryId, TimeEntry timeEntry);

    List<TimeEntry> getAll();

    List<TimeEntry> getAllByEntryDate(OffsetDateTime date);

    List<TimeEntry> getAllByEntryDateAfter(OffsetDateTime date);

    List<TimeEntry> getAllByEntryDateBefore(OffsetDateTime date);

    List<TimeEntry> getAllByEntryDateIsBefore(OffsetDateTime date);

    List<TimeEntry> getAllByEntryDateIsAfter(OffsetDateTime date);

    List<TimeEntry> getUsersByEntryDateBetween(int userId, OffsetDateTime min, OffsetDateTime max);

    List<TimeEntry> deleteAll();

    List<TimeEntry> getAllByTask(Task task);

    List<TimeEntry> getAllByEntryDateBetween(OffsetDateTime min, OffsetDateTime max);
}
