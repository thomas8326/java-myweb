package com.MyWebsite.Controllers;

import com.MyWebsite.Entities.Message.InputMessage;
import com.MyWebsite.Entities.Message.OutputMessage;
import com.MyWebsite.Services.MessageForwardCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class WebSocketController {

    @Autowired
    private MessageForwardCenter messageForwardCenter;

    @MessageMapping("/chat/all")
    @SendTo(MessageForwardCenter.BROADCAST_DESTINATION)
    public OutputMessage send(@Payload InputMessage message) {
        Date date = new Date();
        return new OutputMessage(date.toString(), message);
    }

    @MessageMapping("/chat/room/{roomId}")
    public void sendToRoomUser(@DestinationVariable String roomId,  @Payload InputMessage msg) {
        Date date = new Date();
        OutputMessage outMessage = new OutputMessage(date.toString(), msg);
        messageForwardCenter.sendMessageToRoomUsers(roomId, outMessage);
    }
}
