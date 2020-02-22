package com.openclassrooms.bibliotheque.repository;

import com.openclassrooms.bibliotheque.models.Borrow;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//TODO : ajouter des commentaires sur les classes et les méthodes

@Repository
public interface BorrowRepository extends CrudRepository<Borrow, Integer> {

    Iterable<Borrow> findAll();

    Borrow findById(Long borrowId);

    List<Borrow> findByMemberId(Long id);
}