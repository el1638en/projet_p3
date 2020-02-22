import org.occ.bibliot.repository.BorrowRepository;
import org.occ.model.ENUM.BorrowStatusEnum;
import org.occ.model.beans.Borrow;
import org.occ.model.beans.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;


@Service
public class BatchServiceImpl implements BatchService {
    private static Logger logger = LoggerFactory.getLogger(BatchServiceImpl.class);
    @Autowired
    BorrowRepository borrowRepository;


    //Envoyer un mail a memberMail, appeler une methode privée a developper
    public void sendMailToLateBorrowMember() {



        //config connexion au serveur SMTP gmail avec TLS
        Properties props = new Properties();
        props.put("mail.smtp.host", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        //ouverture de la session avec mon mail
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("clem.biotteau@gmail.com", "SergeLeChat2015");
            }

        });
        //Recuperation de l'iterable
        Iterable<Borrow> borrowListGot = borrowRepository.findAll();
        Iterator<Borrow> listBorrowIterator = borrowListGot.iterator();

       /*  StreamSupport.stream(listBorrowIterator., false)
                .filter(String:: toUpperCase)
                .forEach(System.out::println); */


        while(listBorrowIterator.hasNext()) {

            Borrow currentBorrow = listBorrowIterator.next();

            Date dateFin = currentBorrow.getEndBorrowDate();
            Date currentDate = new Date();

            if (dateFin.before(currentDate) && BorrowStatusEnum.ENCOURS.value().equals(currentBorrow.getStatus())){

                Member memberToMail = currentBorrow.getMemberBorrowing();
                String memberMail = memberToMail.getMailAdress();
                try {
                    //Creation objet mimeMessage
                    MimeMessage msg = new MimeMessage(session);

                    //Setting the recepients from the address variable
                    msg.setRecipients(Message.RecipientType.TO, memberMail);
                    String timeStamp = new SimpleDateFormat("yyyymmdd_hh-mm-ss").format(new Date());
                    msg.setSubject("Mail de relance Automatique : " + timeStamp);
                    msg.setSentDate(new Date());
                    msg.setText("Ceci est un message de relance automatique blabla a completer (WorkName etc..)");
                    msg.setHeader("XPriority", "1");
                    Transport.send(msg);
                    logger.info("Mail has been sent successfully");
                } catch (MessagingException mex) {
                    logger.error("Unable to send an email", mex);
                }



            }
        }


    }
}

