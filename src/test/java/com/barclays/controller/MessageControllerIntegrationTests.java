package com.barclays.controller;

import com.barclays.model.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MessageControllerIntegrationTests {

    @Autowired
    MessageController messageController;

    @Test
    void testGetAllMessages() {
        List<Message> messages = messageController.getAllMessages("");
        assertEquals(4, messages.size());
    }

    @Test
    void testGetMessage() {
        Message message = messageController.getMessage(150);
        assertEquals("My first message out of the data file", message.getContent());
    }

}
