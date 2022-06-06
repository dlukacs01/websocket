package com.gfa.websocket.services;

import com.gfa.websocket.models.InputMessage;
import com.gfa.websocket.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    // DI
    private final MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    // TESTING
    @Override
    public void testing() {
        System.out.println("helokaaaaaaaaaaaaaaaa");
    }

    // READ
    @Override
    public List<InputMessage> findAllMessages() {
        return messageRepository.findAll();
    }

    // STORE
    @Override
    public void saveMessage(InputMessage inputMessage) {
        messageRepository.save(inputMessage);
    }
}
