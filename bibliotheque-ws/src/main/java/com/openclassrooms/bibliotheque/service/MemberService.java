package com.openclassrooms.bibliotheque.service;

import com.openclassrooms.bibliotheque.models.Member;
import com.openclassrooms.projects.bibliotheque.MemberWs;

//TODO : ajouter des commentaires sur les classes et les méthodes
public interface MemberService {

    Member findByNameAndMailAdress(String name, String mailAdress);

    Member create(MemberWs member);

    void deleteMember(Long memberId);

}
