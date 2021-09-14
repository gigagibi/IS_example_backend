package com.example.IS.services;

import com.example.IS.models.Department;
import com.example.IS.models.TimeEntry;
import com.example.IS.models.User;

import java.time.OffsetDateTime;
import java.util.List;

public interface TimeEntryService {
    TimeEntry getById(int timeEntryId);

    List<TimeEntry> createTimeEntry(TimeEntry TimeEntry);

    List<TimeEntry> deleteTimeEntry(int timeEntryId);

    List<TimeEntry> updateTimeEntry(int timeEntryId, TimeEntry timeEntry);

    List<TimeEntry> getAll();

    List<TimeEntry> getAllByEntryDate(OffsetDateTime date);

    List<TimeEntry> getAllByUser(User user);

    List<TimeEntry> getAllByUserAndEntryDateBetween(User user, OffsetDateTime min, OffsetDateTime max);

    List<TimeEntry> getAllByEntryDateAfter(OffsetDateTime date);

    List<TimeEntry> getAllByEntryDateBefore(OffsetDateTime date);

    List<TimeEntry> getAllByEntryDateIsBefore(OffsetDateTime date);

    List<TimeEntry> getAllByEntryDateIsAfter(OffsetDateTime date);

    List<TimeEntry> deleteAll();
}
