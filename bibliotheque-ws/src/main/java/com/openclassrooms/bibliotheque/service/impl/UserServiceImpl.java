package com.openclassrooms.bibliotheque.service.impl;

import com.openclassrooms.bibliotheque.models.User;
import com.openclassrooms.bibliotheque.repository.UserRepository;
import com.openclassrooms.bibliotheque.service.UserService;
import com.openclassrooms.projects.bibliotheque.UserWs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    public UserRepository userRepository;

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public User create(UserWs user) {
        User userCreated = new User();
        BeanUtils.copyProperties(user, userCreated);
        return userRepository.save(userCreated);
    }

    public void deleteUser(Long userId) {
        logger.info("suppression d'un livre: {}", userId);
        userRepository.deleteById(userId);
    }
}