package com.MyWebsite.Entities.Room;

import com.MyWebsite.Entities.User.UserRequest;
import com.MyWebsite.Entities.User.UserResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Room {

    private String id;

    private String name;

    private List<UserResponse> participant;

    public Room(String id, String name, List<UserResponse> participant) {
        this.id = id;
        this.name = name;
        this.participant = participant;
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

    public List<UserResponse> getParticipant() {
        return participant;
    }

    public void setParticipant(List<UserResponse> participant) {
        this.participant = participant;
    }

    public void addParticipant(UserResponse userRequest) {
        this.participant.add(userRequest);
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
