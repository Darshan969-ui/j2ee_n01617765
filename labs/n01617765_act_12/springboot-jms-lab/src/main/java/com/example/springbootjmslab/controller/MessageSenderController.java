package com.example.springbootjmslab.controller;

import com.example.springbootjmslab.Model.Message;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lab")
public class MessageSenderController {
    private final JmsTemplate jmsTemplate;

    public MessageSenderController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestBody Message message) {
        jmsTemplate.convertAndSend("lab-queue", message.getMessage());
        return "Message sent: " + message.getMessage();
    }
}
