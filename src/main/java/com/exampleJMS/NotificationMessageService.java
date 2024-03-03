package com.exampleJMS;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationMessageService {

    private final JmsTemplate jmsTemplate;

    public Email sendNotification(Email email) throws JsonProcessingException {
        log.info("Email {}",email);

        ObjectMapper objectMapper = new ObjectMapper();
        String emailJson = objectMapper.writeValueAsString(email);
        jmsTemplate.convertAndSend("jmsQueue", emailJson);


        return email;
    }

}
