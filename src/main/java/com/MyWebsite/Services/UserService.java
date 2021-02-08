package com.MyWebsite.Services;

import com.MyWebsite.Entities.User.UserResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private Map<String, UserResponse> userMap = new HashMap<>();

    public void registerUser(UserResponse userResponse) {
        this.userMap.put(userResponse.getId(), userResponse);
    }

    public UserResponse getUser(String uuid) {
        return this.userMap.get(uuid);
    }

    public Map<String, UserResponse>  getUsers() { return this.userMap; }

}
