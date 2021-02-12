package com.MyWebsite.Controllers;

import com.MyWebsite.Constants.APIConstants;
import com.MyWebsite.Entities.ResponseContent;
import com.MyWebsite.Entities.Room.Room;
import com.MyWebsite.Entities.User.UserRequest;
import com.MyWebsite.Entities.User.UserResponse;
import com.MyWebsite.Services.MessageForwardCenter;
import com.MyWebsite.Services.RoomService;
import com.MyWebsite.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = APIConstants.API_ROOM, produces = "application/json")
public class RoomController {

    @Autowired
    private UserService userService;

    @Autowired
    private MessageForwardCenter messageForwardCenter;

    @Autowired
    private RoomService roomService;

    @GetMapping
    public ResponseEntity<ResponseContent<List<Room>>> loadRooms() {

        List<Room> fakeRooms = new ArrayList<Room>();
        Room fake1 = new Room("room1", "TestChat1");
        Room fake2 = new Room("room2", "TestChat2");
        Room fake3 = new Room("room3", "TestChat3");

        fakeRooms.add(fake1);
        fakeRooms.add(fake2);
        fakeRooms.add(fake3);

        this.roomService.addRooms(fakeRooms);
             ResponseContent<List<Room>> rc = new ResponseContent<>("test", fakeRooms);

        return ResponseEntity.ok(rc);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseContent<Room>> loadRoom() {

        Room fake1 = new Room("room1", "TestChat1");

        return ResponseEntity.ok(new ResponseContent<>(fake1));
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<ResponseContent<Room>> addNewUserToRoom(final @PathVariable("id") String roomId, final @NonNull @RequestBody UserRequest userRequest) {
        UserResponse userResponse = this.userService.getUser(userRequest.getId());
        this.roomService.getRoom(roomId).addParticipant(userResponse);

        return ResponseEntity.ok(new ResponseContent<>(this.roomService.getRoom(roomId)));
    }

}
