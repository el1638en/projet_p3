package com.openclassrooms.bibliotheque.repository;

import com.openclassrooms.bibliotheque.models.Borrow;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

//TODO : ajouter des commentaires sur les classes et les méthodes

@Repository
public interface BorrowRepository extends CrudRepository<Borrow, Integer> {

    Iterable<Borrow> findAll();

    Borrow findById(Long borrowId);

    List<Borrow> findByMemberId(Long id);

    @Query("select borrow from Borrow borrow left join fetch borrow.member where borrow.status =:status and borrow.endBorrowDate < :endBorrowDate")
    List<Borrow> findByStatusAndEndBorrowDate(@Param("status") String status, @Param("endBorrowDate") Date endBorrowDate);
}