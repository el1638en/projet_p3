package com.openclassrooms.bibliotheque.soap.client;

import com.openclassrooms.bibliotheque.ws.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

/**
 * Client SOAP qui envoie des requets SOAP Web Service
 */
public class UserClient extends WebServiceGatewaySupport {

   @Value(value = "${bibliotheque.ws.url}")
    private String bibliothequeWsUrl;


    public UserWs getUserByUsernameAndPasswordResponse(String username, String password) {
        GetUserByUsernameAndPasswordRequest request = new GetUserByUsernameAndPasswordRequest();
        request.setUsername(username);
        request.setPassword(password);
        GetUserByUsernameAndPasswordResponse response = (GetUserByUsernameAndPasswordResponse) getWebServiceTemplate().marshalSendAndReceive(bibliothequeWsUrl, request,
                new SoapActionCallback("http://openclassrooms.com/projects/bibliotheque/GetUserByLoginAndPasswordRequest"));
        return response.getUserWs();
    }

    public UserWs createUserResponse(String login, String firstName, String name, String password) {
        CreateUserRequest request = new CreateUserRequest();
        UserWs user = new UserWs();
        user.setFirstName(firstName);
        user.setName(name);
        user.setUsername(login);
        user.setPassword(password);
        request.setUserWs(user);
        CreateUserResponse response = (CreateUserResponse) getWebServiceTemplate()
                .marshalSendAndReceive(bibliothequeWsUrl, request,
                        new SoapActionCallback(
                                "http://openclassrooms.com/projects/bibliotheque/CreateUserRequest"));
        return response.getUserWs();
    }
}
