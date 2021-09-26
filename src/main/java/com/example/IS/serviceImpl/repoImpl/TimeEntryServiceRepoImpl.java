package com.example.IS.serviceImpl.repoImpl;

import com.example.IS.models.Task;
import com.example.IS.models.TimeEntry;
import com.example.IS.repositories.TimeEntryRepository;
import com.example.IS.services.TimeEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TimeEntryServiceRepoImpl implements TimeEntryService {
    private final TimeEntryRepository timeEntryRepository;

    @Override
    public TimeEntry getById(int timeEntryId) {
        return timeEntryRepository.findByTimeEntryId(timeEntryId);
    }

    @Override
    public List<TimeEntry> create(TimeEntry timeEntry) {
        timeEntryRepository.saveAndFlush(timeEntry);
        return timeEntryRepository.findAll();
    }

    @Override
    public List<TimeEntry> delete(int timeEntryId) {
        timeEntryRepository.deleteById(timeEntryId);
        return timeEntryRepository.findAll();
    }

    @Override
    public List<TimeEntry> update(int timeEntryId, TimeEntry timeEntry) {
        timeEntryRepository.updateTimeEntry(timeEntryId, timeEntry.getTask(), timeEntry.getHours(), timeEntry.getEntryDate());
        return timeEntryRepository.findAll();
    }

    @Override
    public List<TimeEntry> getAll() {
        return timeEntryRepository.findAll();
    }

    @Override
    public List<TimeEntry> getAllByEntryDate(OffsetDateTime date) {
        return timeEntryRepository.findAllByEntryDate(date);
    }


    @Override
    public List<TimeEntry> getAllByEntryDateAfter(OffsetDateTime date) {
        return timeEntryRepository.findAllByEntryDate(date);
    }

    @Override
    public List<TimeEntry> getAllByEntryDateBefore(OffsetDateTime date) {
        return timeEntryRepository.findAllByEntryDateBefore(date);
    }

    @Override
    public List<TimeEntry> getAllByEntryDateIsBefore(OffsetDateTime date) {
        return timeEntryRepository.findAllByEntryDateIsBefore(date);
    }

    @Override
    public List<TimeEntry> getAllByEntryDateIsAfter(OffsetDateTime date) {
        return timeEntryRepository.findAllByEntryDateIsAfter(date);
    }

    @Override
    public List<TimeEntry> getUsersByEntryDateBetween(int userId, OffsetDateTime min, OffsetDateTime max) {
        return timeEntryRepository.findAllByEntryDateBetween(min, max).stream().filter(e -> e.task.user.getUserId() == userId).collect(Collectors.toList());
    }

    @Override
    public List<TimeEntry> deleteAll() {
        return null;
    }

    @Override
    public List<TimeEntry> getAllByTask(Task task) {
        return timeEntryRepository.findAllByTask(task);
    }

    @Override
    public List<TimeEntry> getAllByEntryDateBetween(OffsetDateTime min, OffsetDateTime max) {
        return null;
    }
}
