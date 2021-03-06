package com.example.IS.repositories;

import com.example.IS.models.Message;
import com.example.IS.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findAllByReceiver(User receiver);

    List<Message> findAllByReceiverAndSender(User receiver, User sender);

    List<Message> findAllBySender(User sender);
}
