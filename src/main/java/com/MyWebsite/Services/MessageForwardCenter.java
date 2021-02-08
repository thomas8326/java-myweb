package com.MyWebsite.Services;

import com.MyWebsite.Entities.Message.OutputMessage;
import com.MyWebsite.Entities.Room.Room;
import com.MyWebsite.Entities.User.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MessageForwardCenter {
    public static final String BROADCAST_DESTINATION = "/all";

    public static final String SECURED_CHAT_ROOM = "/room";
    public static final String SECURED_CHAT_SPECIFIC_USER = "/user/queue/specific-user";

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private RoomService roomService;

    @Autowired
    private UserService userService;

    public void sendMessageBy(String destination, OutputMessage message) {
        messagingTemplate.convertAndSend(destination, message);
    }

    public void sendMessageToUsers(OutputMessage message) {
        for(UserResponse user :userService.getUsers().values()) {
            if(user.getSocketSessionId() != null) {
//                messagingTemplate.convertAndSendToUser(user.getSocketSessionId(), "/user/queue/subscribe", message);
//                messagingTemplate.convertAndSendToUser(user.getSocketSessionId(), "/user/user/queue/subscribe", message);
                messagingTemplate.convertAndSendToUser(user.getSocketSessionId(), "/queue/subscribe", message);
            }
        }
    }

    public void sendMessageToRoomUsers(String roomId, OutputMessage message) {
        for(UserResponse user: this.roomService.getRoom(roomId).getParticipant()) {
            if(user.getSocketSessionId() != null) {
                messagingTemplate.convertAndSendToUser(user.getSocketSessionId(), "/queue/subscribe", message);
            }

        }
    }
    
    public void sendMessageToAll(OutputMessage message) {
        sendMessageBy(BROADCAST_DESTINATION ,message);

    }


}
