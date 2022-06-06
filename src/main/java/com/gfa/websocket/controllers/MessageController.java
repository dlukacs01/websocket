package com.gfa.websocket.controllers;

import com.gfa.websocket.models.InputMessage;
import com.gfa.websocket.models.OutputMessage;
import com.gfa.websocket.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@Controller
public class MessageController {

    // DI
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<InputMessage> inputMessages = messageService.findAllMessages();
        model.addAttribute("messages", inputMessages);
        return "index";
    }

    @MessageMapping("/input")
    @SendTo("/topic/output")
    public OutputMessage sending(InputMessage message) throws Exception {

        messageService.testing();
        messageService.saveMessage(message);

        Thread.sleep(1000); // simulated delay
        return new OutputMessage(message.getUsername(), message.getBody());
    }

}
