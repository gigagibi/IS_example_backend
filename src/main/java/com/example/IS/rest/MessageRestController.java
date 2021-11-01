package com.example.IS.rest;

import com.example.IS.models.Message;
import com.example.IS.serviceImpl.repoImpl.MessageServiceRepoImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/message")
@RequiredArgsConstructor
public class MessageRestController {
    private MessageServiceRepoImpl messageService;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/my")
    public List<Message> getMyMessages(@RequestHeader("Authorization") String token) {
        return messageService.getMessagesByReceiverToken(token);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping("/new")
    public List<Message> postMessage(@RequestHeader("Authorization") String token, @RequestBody Message message) {
        return messageService.create(token, message);
    }
}
