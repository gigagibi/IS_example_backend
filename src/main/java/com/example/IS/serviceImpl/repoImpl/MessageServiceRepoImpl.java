package com.example.IS.serviceImpl.repoImpl;

import com.example.IS.models.Message;
import com.example.IS.models.User;
import com.example.IS.repositories.MessageRepository;
import com.example.IS.repositories.UserRepository;
import com.example.IS.security.JwtProvider;
import com.example.IS.services.MessageService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.OffsetDateTime;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
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
    public List<Message> getMessagesBySenderTokenAndReceiver(String token, User receiver) {
        User sender = userRepository.findByLogin(jwtProvider.getLoginFromToken(token));
        return messageRepository.findAllByReceiverAndSender(receiver, sender);
    }

    @Override
    public List<Message> getMessagesByReceiverTokenAndSender(String token, User sender) {
        User receiver = userRepository.findByLogin(jwtProvider.getLoginFromToken(token));
        return messageRepository.findAllByReceiverAndSender(receiver, sender);
    }

    @Override
    public List<Message> create(String token, Message message) {
        message.setTime(OffsetDateTime.now());
        User sender = userRepository.findByLogin(jwtProvider.getLoginFromToken(token));
        message.setSender(sender);
        messageRepository.saveAndFlush(message);
        return messageRepository.findAllByReceiver(sender);
    }

}
