package com.openclassrooms.bibliotheque.service.impl;

import com.openclassrooms.bibliotheque.beans.Mail;
import com.openclassrooms.bibliotheque.service.MailService;
import com.openclassrooms.bibliotheque.utils.DateUtils;
import com.openclassrooms.bibliotheque.ws.BorrowWs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

@Service
public class MailServiceImpl implements MailService {

    @Value("${mail.send.from}")
    private String mailFrom;

    @Value("${mail.send.subject}")
    private String mailReminderSubject;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Override
    public void sendMessage(Mail mail) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            message.setSubject(mail.getSubject());
            message.setFrom(mail.getFrom());
            message.setTo(mail.getTo());
            Context context = new Context();
            mail.getDatas().forEach((key, value) -> context.setVariable(key, value));
            String htmlContent = templateEngine.process(new ClassPathResource(mail.getTemplate()).getPath(), context);
            message.setText(htmlContent, true);
            javaMailSender.send(mimeMessage);
        } catch (javax.mail.MessagingException exception) {
            // TODO : logger l'erreur
        }
    }

    @Override
    public Mail buildReminderMessage(BorrowWs borrowWs) {
        if (borrowWs == null) {
            return null;
        }
        Mail mail = new Mail();
        mail.setFrom(mailFrom);
        mail.setSubject(mailReminderSubject);
        mail.setTo(borrowWs.getMember().getMailAdress());
        Map<String, Object> datas = new HashMap<>();
        datas.put("name", borrowWs.getMember().getName());
        datas.put("firstName", borrowWs.getMember().getFirstName());
        datas.put("workTitle", borrowWs.getWorkTitle());
        datas.put("endDate", DateUtils.formatDate(borrowWs.getEndBorrowDate()));
        mail.setDatas(datas);
        mail.setTemplate("mail-rappel");
        return mail;
    }
}
