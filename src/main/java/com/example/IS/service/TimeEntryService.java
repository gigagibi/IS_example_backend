package com.example.IS.service;

import com.example.IS.models.TimeEntry;
import com.example.IS.models.User;

import java.time.OffsetDateTime;
import java.util.List;

public interface TimeEntryService {
    public TimeEntry getById(int timeEntryId);

    public List<TimeEntry> createTimeEntry(TimeEntry TimeEntry);

    public List<TimeEntry> deleteTimeEntry(int timeEntryId);

    public List<TimeEntry> updateTimeEntry(int timeEntryId, TimeEntry timeEntry);

    public List<TimeEntry> getAll();

    public List<TimeEntry> getAllByEntryDate(OffsetDateTime date);

    public List<TimeEntry> getAllByUser(User user);

    public List<TimeEntry> getAllByUserAndEntryDateBetween(User user, OffsetDateTime min, OffsetDateTime max);

    List<TimeEntry> getAllByEntryDateAfter(OffsetDateTime date);

    List<TimeEntry> getAllByEntryDateBefore(OffsetDateTime date);

    List<TimeEntry> getAllByEntryDateIsBefore(OffsetDateTime date);

    List<TimeEntry> getAllByEntryDateIsAfter(OffsetDateTime date);
}
