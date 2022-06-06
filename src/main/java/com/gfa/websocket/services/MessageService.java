package com.gfa.websocket.services;

import com.gfa.websocket.models.InputMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageService {
    void testing();

    void saveMessage(InputMessage inputMessage);

    List<InputMessage> findAllMessages();
}
