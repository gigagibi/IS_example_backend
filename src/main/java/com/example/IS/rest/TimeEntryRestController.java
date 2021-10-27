package com.example.IS.rest;

import com.example.IS.exceptions.UserAndTimeEntryNotMatchException;
import com.example.IS.models.TimeEntry;
import com.example.IS.security.JwtProvider;
import com.example.IS.serviceImpl.repoImpl.TaskTypeServiceRepoImpl;
import com.example.IS.serviceImpl.repoImpl.TimeEntryServiceRepoImpl;
import com.example.IS.serviceImpl.repoImpl.UserServiceRepoImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/time_entry")
@AllArgsConstructor
public class TimeEntryRestController {
    private final TimeEntryServiceRepoImpl timeEntryService;

    @GetMapping("/week")
    public List<TimeEntry> getLastTimeEntries(@RequestHeader("Authorization") String token, @RequestParam boolean last) {
        token = token.substring(7);
        List<TimeEntry> entries = timeEntryService.getAllByUserToken(token);
        if (last && entries.size() >= 7)
            return entries.subList(entries.size()-7, entries.size()-1);
        else
            return entries;
    }

    @GetMapping("/")
    public List<TimeEntry> getTimeEntries(@RequestParam(defaultValue = "1") String week, @RequestHeader("Authorization") String token) {
        token = token.substring(7);
        List<TimeEntry> entries = timeEntryService.getAllByUserToken(token);
        try {
            return entries.subList(entries.size() - 7 * Integer.parseInt(week), entries.size() - 1 - 7 * (Integer.parseInt(week) - 1));
        }
        catch (IndexOutOfBoundsException e) {
            return entries;
        }
    }


    @PostMapping("/")
    public List<TimeEntry> createTimeEntry (@RequestHeader("Authorization") String token, @RequestBody TimeEntry timeEntry) throws UserAndTimeEntryNotMatchException {
        token = token.substring(7);
        return timeEntryService.create(token, timeEntry);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/")
    public List<TimeEntry> deleteTimeEntries() {
        return timeEntryService.deleteAll();
    }

    @GetMapping("/{id}")
    public TimeEntry getTimeEntry(@RequestHeader("Authorization") String token, @PathVariable int id) throws UserAndTimeEntryNotMatchException {
        token = token.substring(7);
        return timeEntryService.getById(token, id);
    }

    @DeleteMapping("/{id}")
    public List<TimeEntry> deleteTimeEntry(@RequestHeader("Authorization") String token, @PathVariable int id) throws UserAndTimeEntryNotMatchException {
        token = token.substring(7);
        return timeEntryService.delete(token, id);
    }

    @PutMapping("/{id}")
    public TimeEntry updateTimeEntry(@RequestHeader("Authorization") String token, @PathVariable int id, @RequestBody TimeEntry timeEntry) throws UserAndTimeEntryNotMatchException {
        token = token.substring(7);
        return timeEntryService.update(token, id, timeEntry);
    }

    @GetMapping("/entry/between")
    public List<TimeEntry> getUsersEntriesBetween(@RequestHeader("Authorization") String token, @RequestParam OffsetDateTime min, @RequestParam OffsetDateTime max) throws UserAndTimeEntryNotMatchException {
        token = token.substring(7);
        return timeEntryService.getUsersByEntryDateBetween(token, min, max);
    }


}
