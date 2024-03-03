package com.exampleJMS;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Slf4j
@Component
@RequiredArgsConstructor
public class Receiver {


    private final ObjectMapper objectMapper;

    @JmsListener(destination = "jmsQueue")
    public void receiveMessage(String messageJson) {
        Email email;
        try {
            email = objectMapper.readValue(messageJson, Email.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        log.info("Received <" + email + ">");
    }


}
