package com.openclassrooms.bibliotheque.service;

import com.openclassrooms.bibliotheque.models.User;
import com.openclassrooms.projects.bibliotheque.UserWs;

//TODO : ajouter des commentaires sur les classes et les méthodes
public interface UserService {

    User findByUsernameAndPassword(String username, String password);

    User create(UserWs user);

    void deleteUser(Long userId);
}

