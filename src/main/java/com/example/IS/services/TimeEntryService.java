package com.example.IS.services;

import com.example.IS.exceptions.UserAndTimeEntryNotMatchException;
import com.example.IS.models.Department;
import com.example.IS.models.Task;
import com.example.IS.models.TimeEntry;
import com.example.IS.models.User;

import java.time.OffsetDateTime;
import java.util.List;

public interface TimeEntryService {
    boolean checkTimeEntryAndToken(String token, int timeEntryId) throws UserAndTimeEntryNotMatchException;

    TimeEntry getById(String token, int timeEntryId) throws UserAndTimeEntryNotMatchException;

    List<TimeEntry> create(String token, TimeEntry TimeEntry) throws UserAndTimeEntryNotMatchException;

    List<TimeEntry> delete(String token, int timeEntryId) throws UserAndTimeEntryNotMatchException;

    TimeEntry update(String token, int timeEntryId, TimeEntry timeEntry) throws UserAndTimeEntryNotMatchException;

    List<TimeEntry> getAll();

    List<TimeEntry> getAllByEntryDate(OffsetDateTime date);

    List<TimeEntry> getAllByEntryDateAfter(String token, OffsetDateTime date) throws UserAndTimeEntryNotMatchException;

    List<TimeEntry> getAllByEntryDateBefore(String token, OffsetDateTime date) throws UserAndTimeEntryNotMatchException;

    List<TimeEntry> getAllByEntryDateIsBefore(String token, OffsetDateTime date) throws UserAndTimeEntryNotMatchException;

    List<TimeEntry> getAllByEntryDateIsAfter(String token, OffsetDateTime date) throws UserAndTimeEntryNotMatchException;

    List<TimeEntry> getUsersByEntryDateBetween(String token, OffsetDateTime min, OffsetDateTime max) throws UserAndTimeEntryNotMatchException;

    List<TimeEntry> deleteAll();

    List<TimeEntry> getAllByTask(Task task);

    List<TimeEntry> getAllByEntryDateBetween(OffsetDateTime min, OffsetDateTime max);

    List<TimeEntry> getAllByUserToken(String token);
}
