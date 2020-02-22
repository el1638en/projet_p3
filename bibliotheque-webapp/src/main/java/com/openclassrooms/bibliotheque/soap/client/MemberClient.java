package com.openclassrooms.bibliotheque.soap.client;

import com.openclassrooms.bibliotheque.ws.GetMemberByNameAndMailAdressRequest;
import com.openclassrooms.bibliotheque.ws.GetMemberByNameAndMailAdressResponse;
import com.openclassrooms.bibliotheque.ws.MemberWs;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;


@Component
public class MemberClient extends WebServiceGatewaySupport {

    @Value(value = "${bibliotheque.ws.url}")
    private String bibliothequeWsUrl;

    public MemberWs getMemberByNameAndMailAdressResponse(String name, String mailAdress) {
        GetMemberByNameAndMailAdressRequest request = new GetMemberByNameAndMailAdressRequest();
        request.setName(name);
        request.setMailAdress(mailAdress);
        GetMemberByNameAndMailAdressResponse response = (GetMemberByNameAndMailAdressResponse) getWebServiceTemplate().marshalSendAndReceive(bibliothequeWsUrl, request,
                new SoapActionCallback("http://openclassrooms.com/projects/bibliotheque/GetMemberByNameAndMailAdressRequest"));
        return response.getMemberWs();
    }

}
