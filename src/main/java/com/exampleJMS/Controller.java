package com.exampleJMS;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/jms")
@Slf4j
@RequiredArgsConstructor
public class Controller {

//    @Autowired
    private final NotificationMessageService notificationMessageService;

    @PostMapping
    public ResponseEntity<Email> sendNotification(@RequestBody Email emailMessage) throws JsonProcessingException {
        Email email = notificationMessageService.sendNotification(emailMessage);

        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(email);
    }

}
