package com.MyWebsite.Entities.Room;

import com.MyWebsite.Entities.User.UserResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Room {

    private String id;

    private String name;

    private List<UserResponse> participants;

    public Room(String id, String name, List<UserResponse> participant) {
        this.id = id;
        this.name = name;
        this.participants = participant;
    }

    public Room(String id, String name) {
       this(id, name, new ArrayList<UserResponse>());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<UserResponse> getParticipants() {
        return participants;
    }

    public void setParticipants(List<UserResponse> participants) {
        this.participants = participants;
    }

    public void addParticipant(UserResponse userRequest) {
        this.participants.add(userRequest);
        this.participants = this.participants.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Room other = (Room) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
