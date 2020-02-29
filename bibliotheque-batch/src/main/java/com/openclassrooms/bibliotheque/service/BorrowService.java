package com.openclassrooms.bibliotheque.service;

import com.openclassrooms.bibliotheque.ws.BorrowWs;

import java.util.List;

public interface BorrowService {

    List<BorrowWs> getDelayBorrows();
}
