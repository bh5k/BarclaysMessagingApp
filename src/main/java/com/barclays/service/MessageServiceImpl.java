package com.barclays.service;

import com.barclays.model.Message;
import com.barclays.repository.MessageRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {

    private MessageRepository messageRepository;

//    public MessageServiceImpl(MessageRepository messageRepository) {
//        this.messageRepository = messageRepository;
//    }

    @Override
    public List<Message> findAll() {
        List<Message> messages = new ArrayList<>();
        Iterable<Message> messagesIts = messageRepository.findAll();
        messagesIts.forEach(messages::add);
        return messages;
    }

    @Override
    public Message findById(int id) {
        Message message = new Message();
        message.setContent("Spring is cool: " + id);
        return message;
    }

    @Autowired
    public void setMessageRepository(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

}