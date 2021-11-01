package com.example.IS.rest;

import com.example.IS.models.Message;
import com.example.IS.models.User;
import com.example.IS.serviceImpl.repoImpl.MessageServiceRepoImpl;
import com.example.IS.serviceImpl.repoImpl.UserServiceRepoImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/message")
@AllArgsConstructor
public class MessageRestController {
    private MessageServiceRepoImpl messageService;
    private UserServiceRepoImpl userService;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/my/all")
    public List<Message> getMyMessages(@RequestHeader("Authorization") String token) {
        return messageService.getMessagesByReceiverToken(token.substring(7));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping("/new")
    public List<Message> postMessage(@RequestHeader("Authorization") String token, @RequestBody Message message) {
        return messageService.create(token.substring(7), message);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/sent_to/")
    public List<Message> getMessagesSentTo(@RequestHeader("Authorization") String token, @RequestBody User receiver) {
        return messageService.getMessagesBySenderTokenAndReceiver(token.substring(7), receiver);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/received_from/")
    public List<Message> getMessagesReceivedFrom(@RequestHeader("Authorization") String token, @RequestBody User sender) {
        return messageService.getMessagesByReceiverTokenAndSender(token.substring(7), sender);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/my")
    public List<Message> getDialog(@RequestHeader("Authorization") String token, @RequestParam int userId) {
        User user = userService.getById(userId);
        List<Message> sentMessages = messageService.getMessagesBySenderTokenAndReceiver(token.substring(7), user);
        List<Message> receivedMessages = messageService.getMessagesByReceiverTokenAndSender(token.substring(7), user);
        return Stream.concat(sentMessages.stream(), receivedMessages.stream()).sorted(Comparator.comparing(Message::getTime)).collect(Collectors.toList());
    }
}
