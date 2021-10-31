package com.example.IS.services;

import com.example.IS.models.Message;
import com.example.IS.models.User;

import java.util.List;

public interface MessageService {
    boolean checkMessageAndReceiverMatch(Message message, User receiver);

    List<Message> getMessagesByReceiverToken(String token);

    List<Message> create(String token, Message message);
}
