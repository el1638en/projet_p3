package com.openclassrooms.bibliotheque.service;

import com.openclassrooms.bibliotheque.ws.MemberWs;

public interface MemberService {


    MemberWs findMember(String name, String mailAdress);

}

