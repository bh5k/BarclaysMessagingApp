package com.barclays.controller;

import com.barclays.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class MessageController {

    @GetMapping("/messages")
    public List<Message> getAllMessages() {
        log.debug("In the getAll Messages method");
        List<Message> messages = new ArrayList<>();
        Message message = new Message();
        message.setContent("Spring is cool");
        messages.add(message);
        return messages;
    }

    @GetMapping("/messages/{id}")
    public Message getMessage(@PathVariable int id, @RequestParam(value = "filter") String filter) {
        Message message = new Message();
        message.setContent("Spring is cool: " + id + " with filter: " + filter);
        return message;
    }
}
