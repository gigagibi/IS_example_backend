package com.example.IS.repositories;

import com.example.IS.models.TimeEntry;
import com.example.IS.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.OffsetDateTime;
import java.util.List;

public interface TimeEntryRepository extends JpaRepository<TimeEntry, Integer> {
    // search by value
    TimeEntry findByTimeEntryId(int timeEntryId);

    List<TimeEntry> findAllByEntryDate(OffsetDateTime date);

    List<TimeEntry> findAllByUser(User user);

    List<TimeEntry> findAllByUserAndEntryDateBetween(User user, OffsetDateTime min, OffsetDateTime max);

}
