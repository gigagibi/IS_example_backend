package com.example.IS.rest;

import com.example.IS.models.TimeEntry;
import com.example.IS.serviceImpl.repoImpl.TaskTypeServiceRepoImpl;
import com.example.IS.serviceImpl.repoImpl.TimeEntryServiceRepoImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/time_entry")
@AllArgsConstructor
public class TimeEntryRestController {
    private final TimeEntryServiceRepoImpl timeEntryService;

    @GetMapping("/")
    public List<TimeEntry> getTimeEntries(@RequestParam boolean last) {
        List<TimeEntry> entries = timeEntryService.getAll();
        if (last && entries.size() >= 7)
            return entries.subList(entries.size()-7, entries.size()-1);
        else
            return entries;
    }

    @PostMapping("/")
    public List<TimeEntry> createTimeEntry (@RequestBody TimeEntry timeEntry){
        return timeEntryService.create(timeEntry);
    }

    @DeleteMapping("/")
    public List<TimeEntry> deleteTimeEntries() {
        return timeEntryService.deleteAll();
    }

    @GetMapping("/{id}")
    public TimeEntry getTimeEntry(@PathVariable int id) {
        return timeEntryService.getById(id);
    }

    @DeleteMapping("/{id}")
    public List<TimeEntry> deleteTimeEntry(@PathVariable int id) {
        return timeEntryService.delete(id);
    }

    @PutMapping("/{id}")
    public List<TimeEntry> updateTimeEntry(@PathVariable int id, @RequestBody TimeEntry timeEntry) {
        return timeEntryService.update(id, timeEntry);
    }

    @GetMapping("/entry/between")
    public List<TimeEntry> getUsersEntriesBetween(@RequestParam int userId, @RequestParam OffsetDateTime min, @RequestParam OffsetDateTime max) {
        return timeEntryService.getUsersByEntryDateBetween(userId, min, max);
    }


}
