package com.openclassrooms.bibliotheque.service.impl;

import com.openclassrooms.bibliotheque.service.UserService;
import com.openclassrooms.bibliotheque.soap.client.UserClient;
import com.openclassrooms.bibliotheque.ws.UserWs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserClient userClient;

   @Override
    public UserWs findUser(String username, String password) {
        Assert.notNull(username, "Login must not be null. Login is mandatory.");
        Assert.notNull(password, "Password must not be null. Password is mandatory.");
        return userClient.getUserByUsernameAndPasswordResponse(username, password);
    }
}


