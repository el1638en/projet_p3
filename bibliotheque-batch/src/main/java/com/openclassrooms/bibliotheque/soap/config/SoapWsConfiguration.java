package com.openclassrooms.bibliotheque.soap.config;

import com.openclassrooms.bibliotheque.soap.client.BorrowClient;
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
        marshaller.setPackagesToScan("com.openclassrooms.bibliotheque");
        return marshaller;
    }

    @Bean
    public BorrowClient borrowClient(Jaxb2Marshaller marshaller) {
        BorrowClient borrowClient = new BorrowClient();
        borrowClient.setDefaultUri(bibliothequeWs);
        borrowClient.setMarshaller(marshaller);
        borrowClient.setUnmarshaller(marshaller);
        return borrowClient;
    }
}
