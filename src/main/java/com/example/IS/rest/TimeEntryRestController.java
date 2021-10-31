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

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/week")
    public List<TimeEntry> getLastTimeEntries(@RequestHeader(value = "Authorization") String token, @RequestParam boolean last) {
        List<TimeEntry> entries = timeEntryService.getAllByUserToken(token.substring(7));
        if (last && entries.size() >= 7)
            return entries.subList(entries.size()-7, entries.size()-1);
        else
            return entries;
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/")
    public List<TimeEntry> getTimeEntries(@RequestParam(defaultValue = "1") String week, @RequestHeader("Authorization") String token) {
        List<TimeEntry> entries = timeEntryService.getAllByUserToken(token.substring(7));
        try {
            return entries.subList(entries.size() - 7 * Integer.parseInt(week), entries.size() - 1 - 7 * (Integer.parseInt(week) - 1));
        }
        catch (IndexOutOfBoundsException e) {
            return entries;
        }
    }


    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PostMapping("/")
    public List<TimeEntry> createTimeEntry (@RequestHeader(value = "Authorization") String token, @RequestBody TimeEntry timeEntry) throws UserAndTimeEntryNotMatchException {
        
        return timeEntryService.create(token.substring(7), timeEntry);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/")
    public List<TimeEntry> deleteTimeEntries() {
        return timeEntryService.deleteAll();
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/{id}")
    public TimeEntry getTimeEntry(@RequestHeader(value = "Authorization") String token, @PathVariable int id) throws UserAndTimeEntryNotMatchException {
        
        return timeEntryService.getById(token.substring(7), id);
    }
    
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @DeleteMapping("/{id}")
    public List<TimeEntry> deleteTimeEntry(@RequestHeader(value = "Authorization") String token, @PathVariable int id) throws UserAndTimeEntryNotMatchException {
        
        return timeEntryService.delete(token.substring(7), id);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PutMapping("/{id}")
    public TimeEntry updateTimeEntry(@RequestHeader(value = "Authorization") String token, @PathVariable int id, @RequestBody TimeEntry timeEntry) throws UserAndTimeEntryNotMatchException {
        
        return timeEntryService.update(token.substring(7), id, timeEntry);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/entry/between")
    public List<TimeEntry> getUsersEntriesBetween(@RequestHeader(value = "Authorization") String token, @RequestParam OffsetDateTime min, @RequestParam OffsetDateTime max) throws UserAndTimeEntryNotMatchException {
        
        return timeEntryService.getUsersByEntryDateBetween(token.substring(7), min, max);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/task/{id}")
    public List<TimeEntry> getEntriesByTask(@RequestHeader(value = "Authorization") String token, @PathVariable int id ) {
        return timeEntryService.getAllByTokenAndTaskId(token.substring(7), id);
    }
}
