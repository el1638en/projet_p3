package com.openclassrooms.bibliotheque.soap.client;


import com.openclassrooms.bibliotheque.ws.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.util.List;

@Component
public class BorrowClient extends WebServiceGatewaySupport {

    @Value(value = "${bibliotheque.ws.url}")
    private String bibliothequeWsUrl;

    public BorrowWs getBorrowBookResponse(Long workId, Long memberId) {
        GetBorrowBookRequest request = new GetBorrowBookRequest();
        request.setWorkId(workId);
        request.setMemberId(memberId);
        GetBorrowBookResponse response = (GetBorrowBookResponse) getWebServiceTemplate().marshalSendAndReceive(bibliothequeWsUrl, request,
                new SoapActionCallback("http://openclassrooms.com/projects/bibliotheque/GetBorrowBookRequest"));
        return response.getBorrowWs();
    }

    public BorrowWs getExtendBorrowResponse(Long borrowId) {
        GetExtendBorrowRequest request = new GetExtendBorrowRequest();
        request.setId(borrowId);

        GetExtendBorrowResponse response = (GetExtendBorrowResponse) getWebServiceTemplate().marshalSendAndReceive(bibliothequeWsUrl, request,
                new SoapActionCallback("http://openclassrooms.com/projects/bibliotheque/GetExtendBorrowRequest"));
        return response.getBorrowWs();
    }

    public BorrowWs getTerminateBorrowResponse(Long borrowId) {
        GetTerminateBorrowRequest request = new GetTerminateBorrowRequest();
        request.setId(borrowId);

        GetTerminateBorrowResponse response = (GetTerminateBorrowResponse) getWebServiceTemplate().marshalSendAndReceive(bibliothequeWsUrl, request,
                new SoapActionCallback("http://openclassrooms.com/projects/bibliotheque/GetTerminateBorrowRequest"));
        return response.getBorrowWs();
    }

    public List<BorrowWs> getBorrowListByMemberIdResponse(Long memberId) {
        GetBorrowListByMemberIdRequest request = new GetBorrowListByMemberIdRequest();
        request.setMemberId(memberId);

        GetBorrowListByMemberIdResponse response = (GetBorrowListByMemberIdResponse) getWebServiceTemplate().marshalSendAndReceive(bibliothequeWsUrl, request,
                new SoapActionCallback("http://openclassrooms.com/projects/bibliotheque/GetBorrowListByMemberIdRequest"));
        return response.getBorrowWs();
    }

}
