package com.openclassrooms.bibliotheque.service;

import com.openclassrooms.bibliotheque.beans.Mail;
import com.openclassrooms.bibliotheque.ws.BorrowWs;

public interface MailService {

    void sendMessage(Mail mail);

    Mail buildReminderMessage(BorrowWs borrowWs);

}
