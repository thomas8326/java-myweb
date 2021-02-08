package com.MyWebsite.Entities.User;

import java.util.UUID;

public class UserResponse {
    private String id;
    private String name;

    private String socketSessionId;

    public UserResponse(UUID id, String name) {
        this.id=id.toString();
        this.name = name;
    }

    public UserResponse(UUID id) {
        this(id, null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSocketSessionId() {
        return socketSessionId;
    }

    public void setSocketSessionId(String socketSessionId) {
        this.socketSessionId = socketSessionId;
    }
}
