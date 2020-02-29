package com.openclassrooms.bibliotheque.service;

import com.openclassrooms.bibliotheque.models.Borrow;

import java.util.List;

//TODO : ajouter des commentaires sur les classes et les méthodes
public interface BorrowService {

    boolean borrowBook(Long workId, Long memberId);

    boolean extendBorrow(Long borrowId);

    boolean terminateBorrow(Long borrowId);

    List<Borrow> findBorrowListByMemberId(Long memberId);

    List<Borrow> findDelayBorrows();

}