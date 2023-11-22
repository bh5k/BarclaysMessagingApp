package com.barclays.controller;

import com.barclays.model.Message;
import com.barclays.service.MessageService;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/messages")
    public List<Message> getAllMessages(@PathParam("filter") String filter) {
        log.debug("In the getAll Messages method");
        List<Message> messages;
        if(StringUtils.isNotBlank(filter)) {
            log.debug("In the getAll Messages method: " + filter);
            messages = messageService.findByContentContains(filter);
        }
        else {
            messages = messageService.findAll();
        }
        return messages;
    }

    @GetMapping("/messages/{id}")
    public Message getMessage(@PathVariable int id) {
        log.debug("In the getMessage Messages method: " + id);
        return messageService.findById(id);
    }
}
