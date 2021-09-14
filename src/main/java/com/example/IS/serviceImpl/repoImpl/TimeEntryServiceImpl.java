package com.example.IS.serviceImpl.repoImpl;

import com.example.IS.models.TimeEntry;
import com.example.IS.models.User;
import com.example.IS.repositories.TimeEntryRepository;
import com.example.IS.service.TimeEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TimeEntryServiceImpl implements TimeEntryService {
    private final TimeEntryRepository timeEntryRepository;

    @Override
    public TimeEntry getById(int timeEntryId) {
        return timeEntryRepository.findByTimeEntryId(timeEntryId);
    }

    @Override
    public List<TimeEntry> createTimeEntry(TimeEntry timeEntry) {
        timeEntryRepository.save(timeEntry);
        return timeEntryRepository.findAll();
    }

    @Override
    public List<TimeEntry> deleteTimeEntry(int timeEntryId) {
        timeEntryRepository.deleteById(timeEntryId);
        return timeEntryRepository.findAll();
    }

    @Override
    public List<TimeEntry> updateTimeEntry(int timeEntryId, TimeEntry timeEntry) {
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
    public List<TimeEntry> getAllByUser(User user) {
        return timeEntryRepository.findAllByUser(user);
    }

    @Override
    public List<TimeEntry> getAllByUserAndEntryDateBetween(User user, OffsetDateTime min, OffsetDateTime max) {
        return timeEntryRepository.findAllByUserAndEntryDateBetween(user, min, max);
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
}
