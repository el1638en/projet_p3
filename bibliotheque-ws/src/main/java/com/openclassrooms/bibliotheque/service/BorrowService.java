package com.openclassrooms.bibliotheque.service;

import com.openclassrooms.bibliotheque.models.Borrow;

import java.util.List;

//TODO : ajouter des commentaires sur les classes et les méthodes
public interface BorrowService {

    Boolean borrowBook(Long workId, Long memberId);

    Boolean extendBorrow(Long borrowId);

    Boolean terminateBorrow(Long borrowId);

    List<Borrow> findBorrowListByMemberId(Long memberId);

}