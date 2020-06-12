package com.team11.charityserver.controller;

import com.team11.charityserver.model.Media;
import com.team11.charityserver.model.Message;
import com.team11.charityserver.model.Messagevo;
import com.team11.charityserver.model.RespBean;
import com.team11.charityserver.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @Autowired
    MessageService messageService;

    @PostMapping("/message")
    public RespBean sendMessage(@RequestBody Message message) {
        String phoneNumber = "+44" + message.getPhoneNumber();
        String text = message.getText();
        messageService.sendMessage(phoneNumber, text);
        return RespBean.ok("Send message successfully!");
    }

    @PostMapping("/email")
    public RespBean sendEmail(@RequestBody Messagevo messagevo) throws Exception {
        messageService.sendEmail(messagevo);
        return RespBean.ok("Send email successfully!");
    }

    @PostMapping("/twitter")
    public RespBean sendTwitter(@RequestBody Media media) {
        messageService.sendTwitter(media);
        return RespBean.ok("Send twitter successfully!");
    }
}
