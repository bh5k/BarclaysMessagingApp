package com.barclays.util;

import com.barclays.model.Message;
import com.barclays.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Populator {

    private MessageRepository messageRepository;

    //@EventListener(ContextRefreshedEvent.class)
    public void populate(){
        Message m1 = new Message();
        m1.setContent("Bryan is Best");
        messageRepository.save(m1);

        Message m2 = new Message("May the Force be with you");
        messageRepository.save(m2);

        Message m3 = new Message("Rubber Baby Buggy Bumpers");
        messageRepository.save(m3);

        Message m4 = new Message("Unique New York");
        messageRepository.save(m4);
    }
}
