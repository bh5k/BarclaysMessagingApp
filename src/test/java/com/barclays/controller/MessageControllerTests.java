package com.barclays.controller;

import com.barclays.model.Message;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MessageControllerTests {

    @Test
    public void testGetAllMessages() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Message[]> response =
                restTemplate.getForEntity("http://localhost:8080/messages", Message[].class);
        Message[] messages = response.getBody();
        assertEquals(1, messages.length);
    }

    @Test
    public void testGetMessage() {
        RestTemplate restTemplate = new RestTemplate();
        Message message =
                restTemplate.getForObject("http://localhost:8080/messages/1?filter=unread", Message.class);

        assertEquals("Spring is cool: 1 with filter: unread", message.getContent());
    }
}
