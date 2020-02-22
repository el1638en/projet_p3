package com.openclassrooms.bibliotheque.repository;

import com.openclassrooms.bibliotheque.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//TODO : ajouter des commentaires sur les classes et les méthodes

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsernameAndPassword(String username, String password);

    User save(User user);

    void deleteById(Long userId);
}
