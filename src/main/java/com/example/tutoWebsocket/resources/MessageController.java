package com.example.tutoWebsocket.resources;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.tutoWebsocket.model.MessageBody;

@Controller
//@CrossOrigin
public class MessageController {

    @Autowired
    private SimpMessageSendingOperations simpMessageSendingOperations;

    @MessageMapping("/test")
    public void sendUserMessage(Principal principal, MessageBody messageBody) {
        messageBody.setFrom(principal.getName());
        System.err.println("1"+messageBody.getTargetUser());
        System.err.println("2"+messageBody.getContent());
        System.err.println("3"+messageBody.getDestination());
        System.err.println("4"+messageBody.getFrom());
        
        simpMessageSendingOperations.convertAndSendToUser(messageBody.getTargetUser(), messageBody.getDestination(), messageBody);
    }
    
}