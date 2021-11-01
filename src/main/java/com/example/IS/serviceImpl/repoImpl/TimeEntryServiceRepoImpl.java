package com.example.IS.serviceImpl.repoImpl;

import com.example.IS.exceptions.UserAndTimeEntryNotMatchException;
import com.example.IS.models.Task;
import com.example.IS.models.TimeEntry;
import com.example.IS.models.User;
import com.example.IS.repositories.TaskRepository;
import com.example.IS.repositories.TimeEntryRepository;
import com.example.IS.repositories.UserRepository;
import com.example.IS.security.JwtProvider;
import com.example.IS.services.TimeEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TimeEntryServiceRepoImpl implements TimeEntryService {
    private final TimeEntryRepository timeEntryRepository;
    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    private final JwtProvider jwtProvider;

    @Override
    public boolean checkTimeEntryAndToken(String token, int timeEntryId) {
        TimeEntry timeEntry = timeEntryRepository.findByTimeEntryId(timeEntryId);
        User user = userRepository.findByLogin(jwtProvider.getLoginFromToken(token));
        return (timeEntry.getTask().getUser().getUserId() == user.getUserId() || user.getRole().equals("ROLE_ADMIN"));
    }

    @Override
    public TimeEntry getById(String token, int timeEntryId) throws UserAndTimeEntryNotMatchException {
        if(checkTimeEntryAndToken(token, timeEntryId))
            return timeEntryRepository.findByTimeEntryId(timeEntryId);
        else
            throw new UserAndTimeEntryNotMatchException();
    }

    @Override
    public List<TimeEntry> getAllByTokenAndTaskId(String token, int taskId) {
        User user = userRepository.findByLogin(jwtProvider.getLoginFromToken(token));
        return timeEntryRepository.getTimeEntryByUserIdAndTaskId(user.getUserId(), taskId);
    }

    @Override
    public List<TimeEntry> create(String token, TimeEntry timeEntry) throws UserAndTimeEntryNotMatchException {
        User user = userRepository.findByLogin(jwtProvider.getLoginFromToken(token));
        Task task = taskRepository.findByTaskId(timeEntry.getTask().getTaskId());
        if(task.getUser().getUserId() == user.getUserId() || user.getRole().equals("ROLE_ADMIN")) {
            timeEntryRepository.saveAndFlush(timeEntry);
//            return timeEntryRepository.findAll().stream().filter(e -> e.getTask().getUser()!=null && e.getTask().getUser().getLogin().equals(jwtProvider.getLoginFromToken(token))).collect(Collectors.toList());
            return timeEntryRepository.getTimeEntryByUserIdAndTaskId(user.getUserId(), task.getTaskId());
        }
        else
            throw new UserAndTimeEntryNotMatchException();
    }

    @Override
    public List<TimeEntry> delete(String token, int timeEntryId) throws UserAndTimeEntryNotMatchException {
        if(checkTimeEntryAndToken(token, timeEntryId)) {
            timeEntryRepository.deleteById(timeEntryId);
            return timeEntryRepository.findAll().stream().filter(e -> e.getTask().getUser()!=null && e.getTask().getUser().getLogin().equals(jwtProvider.getLoginFromToken(token))).collect(Collectors.toList());
        }
        else
            throw new UserAndTimeEntryNotMatchException();
    }

    @Override
    public TimeEntry update(String token, int timeEntryId, TimeEntry newTimeEntry) throws UserAndTimeEntryNotMatchException {
        if(checkTimeEntryAndToken(token, timeEntryId)) {
            timeEntryRepository.updateTimeEntry(timeEntryId, newTimeEntry.getTask(), newTimeEntry.getHours(), newTimeEntry.getEntryDate());
            return timeEntryRepository.findByTimeEntryId(timeEntryId);
        }
        else
            throw new UserAndTimeEntryNotMatchException();
    }


    @Override
    public List<TimeEntry> getAll() {
        return timeEntryRepository.findAll();
    }

    @Override
    public List<TimeEntry> getAllByEntryDate(OffsetDateTime date) {
        return null;
    }

    @Override
    public List<TimeEntry> getAllByEntryDateAfter(String token, OffsetDateTime date) {
        return null;
    }

    @Override
    public List<TimeEntry> getAllByEntryDateBefore(String token, OffsetDateTime date) {
        return null;
    }

    @Override
    public List<TimeEntry> getAllByEntryDateIsBefore(String token, OffsetDateTime date) {
        return null;
    }

    @Override
    public List<TimeEntry> getAllByEntryDateIsAfter(String token, OffsetDateTime date) {
        return null;
    }

    @Override
    public List<TimeEntry> getUsersByEntryDateBetween(String token, OffsetDateTime min, OffsetDateTime max) {
        return timeEntryRepository.findAllByEntryDateBetween(min, max).stream().filter(e -> e.getTask().getUser()!=null && e.getTask().getUser().getLogin().equals(jwtProvider.getLoginFromToken(token))).collect(Collectors.toList());
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

    @Override
    public List<TimeEntry> getAllByUserToken(String token) {
        return timeEntryRepository.findAll().stream().filter(e -> e.getTask()!=null && e.getTask().getUser().getLogin().equals(jwtProvider.getLoginFromToken(token))).collect(Collectors.toList());
    }
}
