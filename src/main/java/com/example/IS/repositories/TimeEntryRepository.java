package com.example.IS.repositories;

import com.example.IS.models.Department;
import com.example.IS.models.Task;
import com.example.IS.models.TimeEntry;
import com.example.IS.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;


public interface TimeEntryRepository extends JpaRepository<TimeEntry, Integer> {
    // search by value
    TimeEntry findByTimeEntryId(int timeEntryId);

    List<TimeEntry> findAllByEntryDate(OffsetDateTime date);

    List<TimeEntry> findAllByEntryDateAfter(OffsetDateTime date);

    List<TimeEntry> findAllByEntryDateBefore(OffsetDateTime date);

    List<TimeEntry> findAllByEntryDateIsBefore(OffsetDateTime date);

    List<TimeEntry> findAllByEntryDateIsAfter(OffsetDateTime date);

    List<TimeEntry> findAllByTask(Task task);

    List<TimeEntry> findAllByEntryDateBetween(OffsetDateTime min, OffsetDateTime max);
    @Modifying
    @Query(value = "update TimeEntry set task = ?2, hours = ?3, entryDate = ?4 where timeEntryId = ?1")
    void updateTimeEntry(int id, Task task, int hours, OffsetDateTime entryDate);
}
