package com.MyWebsite.Controllers;

import com.MyWebsite.Constants.APIConstants;
import com.MyWebsite.Entities.ResponseContent;
import com.MyWebsite.Entities.User.UserResponse;
import com.MyWebsite.Entities.User.UserRequest;
import com.MyWebsite.Services.UserService;
import com.MyWebsite.Utils.URIHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = APIConstants.API_LOGIN, produces = "application/json")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<ResponseContent<UserResponse>> loginUser(@RequestBody final UserRequest userRequest) {
        UUID uuid = UUID.randomUUID();
        UserResponse userResponse = new UserResponse(uuid, userRequest.getName());
        userService.registerUser(userResponse);
        return ResponseEntity.created(URIHandler.getURI("/{id}", userResponse.getId())).body(new ResponseContent<>(userResponse));
    }
}
