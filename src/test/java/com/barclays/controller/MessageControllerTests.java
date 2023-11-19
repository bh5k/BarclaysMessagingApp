package com.barclays.controller;

import com.barclays.model.Message;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@SpringBootTest
public class MessageControllerTests {

    //@Test
    public void testGetAllMessages() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Message[]> response =
                restTemplate.getForEntity("http://localhost:8080/messages", Message[].class);
        assertEquals(200, response.getStatusCode());
        Message[] messages = response.getBody();

        List<Message> messagesList = Arrays.asList(messages);

        assertEquals(1, messagesList.size());
    }

    //@Test
    public void testGetMessage() {
        RestTemplate restTemplate = new RestTemplate();
        Message message =
                restTemplate.getForObject("http://localhost:8080/messages/1", Message.class);

        assertEquals("Spring is cool: 1", message.getContent());
    }
}
