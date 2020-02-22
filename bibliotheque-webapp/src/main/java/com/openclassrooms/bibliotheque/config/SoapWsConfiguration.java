package com.openclassrooms.bibliotheque.config;

import com.openclassrooms.bibliotheque.soap.client.BorrowClient;
import com.openclassrooms.bibliotheque.soap.client.MemberClient;
import com.openclassrooms.bibliotheque.soap.client.UserClient;
import com.openclassrooms.bibliotheque.soap.client.WorkClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapWsConfiguration {

    @Value("${bibliotheque.ws}")
    private String bibliothequeWs;
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in pom.xml
        marshaller.setPackagesToScan("com.openclassrooms.bibliotheque.ws");
        return marshaller;
    }

    @Bean
    public UserClient userClient(Jaxb2Marshaller marshaller) {
        UserClient client = new UserClient();
        client.setDefaultUri(bibliothequeWs);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

    @Bean
    public WorkClient workClient(Jaxb2Marshaller marshaller) {
        WorkClient client = new WorkClient();
        client.setDefaultUri(bibliothequeWs);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

    @Bean
    public MemberClient memberClient(Jaxb2Marshaller marshaller) {
        MemberClient client = new MemberClient();
        client.setDefaultUri(bibliothequeWs);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

    @Bean
    public BorrowClient borrowClient(Jaxb2Marshaller marshaller) {
        BorrowClient borrow = new BorrowClient();
        borrow.setDefaultUri(bibliothequeWs);
        borrow.setMarshaller(marshaller);
        borrow.setUnmarshaller(marshaller);
        return borrow;
    }
}