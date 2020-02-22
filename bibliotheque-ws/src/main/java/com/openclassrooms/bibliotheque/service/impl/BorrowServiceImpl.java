package com.openclassrooms.bibliotheque.service.impl;


import com.openclassrooms.bibliotheque.enumType.BorrowStatusEnum;
import com.openclassrooms.bibliotheque.models.Book;
import com.openclassrooms.bibliotheque.models.Borrow;
import com.openclassrooms.bibliotheque.models.Member;
import com.openclassrooms.bibliotheque.models.Work;
import com.openclassrooms.bibliotheque.repository.BookRepository;
import com.openclassrooms.bibliotheque.repository.BorrowRepository;
import com.openclassrooms.bibliotheque.repository.MemberRepository;
import com.openclassrooms.bibliotheque.repository.WorkRepository;
import com.openclassrooms.bibliotheque.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private WorkRepository workRepository;
    @Autowired
    private BorrowRepository borrowRepository;
    @Autowired
    private BookRepository bookRepository;


    public Boolean borrowBook(Long workId, Long memberId) {
        // on recupère l'Id du membre passé en parametre
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        if (!optionalMember.isPresent()) {
            return false;
        }
        Member member = optionalMember.get();
        Boolean toReturn = false;
        // Recuperer le Work dont on connait l'ID (creer work repository)
        Work work = workRepository.findById(workId).get();
        // On parcours la bookList
        for (Book result : work.getBooksList()) {
            if (result.isAvailable()) {
                Borrow borrowToSave = new Borrow();
                borrowToSave.setBook(result);
                // On associe le member a borrow
                borrowToSave.setMember(member);
                borrowToSave.setStartBorrowDate(new Date());
                //Calcul de la date de fin d'emprunt
                Date borrowDate = borrowToSave.getStartBorrowDate();
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(borrowDate);
                calendar.add(Calendar.WEEK_OF_MONTH, 4);
                borrowToSave.setEndBorrowDate(calendar.getTime());

                //Set le statut de l'emprunt + Ajout du nom de l'oeuvre à l'emprunt
                borrowToSave.setStatus(BorrowStatusEnum.ENCOURS.value());
                borrowToSave.setWorkTitle(work.getTitle());

                // set extended
                borrowToSave.setExtended(false);

                //  Save le borrow dans le repository
                borrowRepository.save(borrowToSave);
                //Indique que le livre n'est plus disponible et on sauvegarde dans le bookRepository
                result.setAvailable(false);
                bookRepository.save(result);
                toReturn = true;
                break;
            }
        }
        return toReturn;
    }

    public Boolean extendBorrow(Long borrowId) {
        Boolean toReturn = false;
        // Recuperer le borrow dont on connait l'ID
        Borrow borrowToExtend = borrowRepository.findById(borrowId);
        Date endBorrowDate = borrowToExtend.getEndBorrowDate();
        // Recuperer la date du jour
        if (endBorrowDate.after(new Date()) && (borrowToExtend.isExtended() == false)) {
            // Rallonge de l'emprunt +4weeks
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(endBorrowDate);
            calendar.add(Calendar.WEEK_OF_MONTH, 4);
            borrowToExtend.setEndBorrowDate(calendar.getTime());
            // setExtended a true
            borrowToExtend.setExtended(true);
            borrowToExtend.setStatus(BorrowStatusEnum.PROLONGE.value());
            borrowRepository.save(borrowToExtend);
            toReturn = true;
        }
        return toReturn;
    }

    //public Boolean terminateBorrow(Long borrowId, Long memberId ) {
    public Boolean terminateBorrow(Long borrowId) {
        //Set le statut de l'emprunt a "rendu"
        Borrow borrowToEnd = borrowRepository.findById(borrowId);
        borrowToEnd.setStatus(BorrowStatusEnum.RENDU.value());
        //Set le book comme disponible
        Book returnedBook = borrowToEnd.getBook();
        returnedBook.setAvailable(true);
        //Sauvegarde du livre rendu
        bookRepository.save(returnedBook);
        borrowRepository.save(borrowToEnd);
        return true;
    }

    @Override
    public List<Borrow> findBorrowListByMemberId(Long memberId) {
        return borrowRepository.findByMemberId(memberId);
    }


}
