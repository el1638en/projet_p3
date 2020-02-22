package com.openclassrooms.bibliotheque.soap;


import com.openclassrooms.bibliotheque.models.User;
import com.openclassrooms.bibliotheque.service.UserService;
import com.openclassrooms.projects.bibliotheque.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

//TODO : ajouter des commentaires sur les classes et les méthodes
@Endpoint
public class UserEndpoint {

    private static final String NAMESPACE_URI = "http://openclassrooms.com/projects/bibliotheque";

    @Autowired
    private UserService userService;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getUserByUsernameAndPasswordRequest")
    @ResponsePayload
    public GetUserByUsernameAndPasswordResponse getUserByUsernameAndPassword(@RequestPayload GetUserByUsernameAndPasswordRequest request) {
        GetUserByUsernameAndPasswordResponse response = new GetUserByUsernameAndPasswordResponse();
        User user = userService.findByUsernameAndPassword(request.getUsername(), request.getPassword());
        if (user != null) {
            UserWs userWs = new UserWs();
            BeanUtils.copyProperties(user, userWs);
            response.setUserWs(userWs);
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createUserRequest")
    @ResponsePayload
    public CreateUserResponse createUser(@RequestPayload CreateUserRequest request) {
        CreateUserResponse createUserResponse = new CreateUserResponse();
        User user = new User();
        BeanUtils.copyProperties(request.getUserWs(), user);
        User userCreated = userService.create(request.getUserWs());
        if (userCreated != null) {
            UserWs userWs = new UserWs();
            BeanUtils.copyProperties(userCreated, userWs);
            createUserResponse.setUserWs(userWs);
        }
        return createUserResponse;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDeleteUserRequest")
    @ResponsePayload
    public GetDeleteUserResponse getDeleteUser(@RequestPayload GetDeleteUserRequest request) {
        GetDeleteUserResponse response = new GetDeleteUserResponse();
        userService.deleteUser(request.getId());
//        TODO : code à enlever
//        if (userToDelete != null) {
//            UserWs userWs = new UserWs();
//            BeanUtils.copyProperties(userToDelete, userWs);
//            response.setUserWs(userWs);
//        }
        return response;
    }

}

