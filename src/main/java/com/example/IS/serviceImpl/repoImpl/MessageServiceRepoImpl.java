package com.example.IS.serviceImpl.repoImpl;

import com.example.IS.models.Message;
import com.example.IS.models.User;
import com.example.IS.repositories.MessageRepository;
import com.example.IS.repositories.UserRepository;
import com.example.IS.security.JwtProvider;
import com.example.IS.services.MessageService;

import java.util.List;

public class MessageServiceRepoImpl implements MessageService {
    private MessageRepository messageRepository;
    private UserRepository userRepository;
    private JwtProvider jwtProvider;

    @Override
    public boolean checkMessageAndReceiverMatch(Message message, User receiver) {
        return message.getReceiver().getUserId()==receiver.getUserId();
    }

    @Override
    public List<Message> getMessagesByReceiverToken(String token) {
        User receiver = userRepository.findByLogin(jwtProvider.getLoginFromToken(token));
        return messageRepository.findAllByReceiver(receiver);
    }

    @Override
    public List<Message> create(String token, Message message) {
        User sender = userRepository.findByLogin(jwtProvider.getLoginFromToken(token));
        message.setSender(sender);
        messageRepository.saveAndFlush(message);
        return messageRepository.findAllByReceiver(sender);
    }
}
