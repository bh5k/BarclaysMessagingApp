package com.barclays.controller;

import com.barclays.model.Message;
import com.barclays.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/messages")
    public List<Message> getAllMessages() {
        log.debug("In the getAll Messages method");
        return messageService.findAll();
    }

    @GetMapping("/messages/{id}")
    public Message getMessage(@PathVariable int id) {
        log.debug("In the getMessage Messages method: " + id);
        return messageService.findById(id);
    }
}
