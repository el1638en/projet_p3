package com.openclassrooms.bibliotheque.service.impl;

import com.openclassrooms.bibliotheque.service.MemberService;
import com.openclassrooms.bibliotheque.soap.client.MemberClient;
import com.openclassrooms.bibliotheque.ws.MemberWs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberClient memberClient;

    @Override
    public MemberWs findMember(String name, String mailAdress) {
        Assert.notNull(name, "name must not be null. name is mandatory.");
        Assert.notNull(mailAdress, "mailAdress must not be null. mailAdress is mandatory.");
        return memberClient.getMemberByNameAndMailAdressResponse(name, mailAdress);
    }
}

