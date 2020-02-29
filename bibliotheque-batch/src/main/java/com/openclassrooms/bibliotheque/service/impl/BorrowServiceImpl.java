package com.openclassrooms.bibliotheque.service.impl;

import com.openclassrooms.bibliotheque.service.BorrowService;
import com.openclassrooms.bibliotheque.soap.client.BorrowClient;
import com.openclassrooms.bibliotheque.ws.BorrowWs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private BorrowClient borrowClient;

    @Override
    public List<BorrowWs> getDelayBorrows() {
        return borrowClient.getDelayBorrows();
    }
}
