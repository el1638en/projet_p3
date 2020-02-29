package com.openclassrooms.bibliotheque.soap.client;

import com.openclassrooms.bibliotheque.ws.BorrowWs;
import com.openclassrooms.bibliotheque.ws.GetDelayBorrowsRequest;
import com.openclassrooms.bibliotheque.ws.GetDelayBorrowsResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.util.List;

public class BorrowClient extends WebServiceGatewaySupport {

    @Value(value = "${bibliotheque.ws.url}")
    private String bibliothequeWsUrl;

    public List<BorrowWs> getDelayBorrows() {
        GetDelayBorrowsRequest request = new GetDelayBorrowsRequest();
        GetDelayBorrowsResponse response = (GetDelayBorrowsResponse) getWebServiceTemplate().marshalSendAndReceive(bibliothequeWsUrl, request,
                new SoapActionCallback("http://openclassrooms.com/projects/bibliotheque/GetDelayBorrowsRequest"));
        return response.getBorrowWs();
    }

}