package com.MyWebsite.Services;

import com.MyWebsite.Entities.Room.Room;
import com.MyWebsite.Entities.User.UserRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RoomService {
    private final Set<Room> roomMap = new HashSet<>();

    public List<Room> getRooms() {
        return this.roomMap.stream().collect(Collectors.toList());
    }

    public Room getRoom(String roomId) {
        return this.roomMap.stream().filter(room -> room.getId().equals(roomId)).findFirst().get();
    }

    public void addRooms(List<Room> rooms) {
        for(Room room: rooms) {
            this.roomMap.add(room);
        }
    }
}
