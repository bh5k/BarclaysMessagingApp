package com.barclays.controller;

import com.barclays.model.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MessageControllerIntegrationTests {

    @Autowired
    MessageController messageController;

    @Test
    public void testGetAllMessages() {
        List<Message> messages = messageController.getAllMessages();
        assertEquals(1, messages.size());
    }

    @Test
    public void testGetMessage() {
        Message message = messageController.getMessage(1,"unread");
        assertEquals("Spring is cool: 1 with filter: unread", message.getContent());
    }

}
