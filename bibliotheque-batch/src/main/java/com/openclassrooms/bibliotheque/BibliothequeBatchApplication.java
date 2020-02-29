package com.openclassrooms.bibliotheque;

import com.openclassrooms.bibliotheque.beans.Mail;
import com.openclassrooms.bibliotheque.service.BorrowService;
import com.openclassrooms.bibliotheque.service.MailService;
import com.openclassrooms.bibliotheque.ws.BorrowWs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class BibliothequeBatchApplication implements CommandLineRunner {

    @Autowired
    private BorrowService borrowService;

    @Autowired
    private MailService mailService;

    public static void main(String[] args) {
        SpringApplication.run(BibliothequeBatchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<BorrowWs> borrowWs = borrowService.getDelayBorrows();
        if (!CollectionUtils.isEmpty(borrowWs)) {
            List<Mail> mails = borrowWs.stream().map(borrow -> mailService.buildReminderMessage(borrow)).collect(Collectors.toList());
            mails.forEach(mail -> mailService.sendMessage(mail));
        }
    }
}
