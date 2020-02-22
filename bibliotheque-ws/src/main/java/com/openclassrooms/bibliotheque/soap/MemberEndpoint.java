package com.openclassrooms.bibliotheque.soap;

import com.openclassrooms.bibliotheque.models.Member;
import com.openclassrooms.bibliotheque.service.MemberService;
import com.openclassrooms.projects.bibliotheque.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

//TODO : ajouter des commentaires sur les classes et les méthodes

@Endpoint
public class MemberEndpoint {

    private static final String NAMESPACE_URI = "http://openclassrooms.com/projects/bibliotheque";

    @Autowired
    private MemberService memberService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMemberByNameAndMailAdressRequest")
    @ResponsePayload
    public GetMemberByNameAndMailAdressResponse getMemberByNameAndMailAdress(@RequestPayload GetMemberByNameAndMailAdressRequest request) {
        GetMemberByNameAndMailAdressResponse response = new GetMemberByNameAndMailAdressResponse();
        Member member = memberService.findByNameAndMailAdress(request.getName(), request.getMailAdress());
        if (member != null) {
            MemberWs memberWs = new MemberWs();
            BeanUtils.copyProperties(member, memberWs);
            response.setMemberWs(memberWs);
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createMemberRequest")
    @ResponsePayload
    public CreateMemberResponse createMember(@RequestPayload CreateMemberRequest request) {
        CreateMemberResponse createMemberResponse = new CreateMemberResponse();
        Member member = new Member();
        BeanUtils.copyProperties(request.getMemberWs(), member);
        Member memberCreated = memberService.create(request.getMemberWs());
        if (memberCreated != null) {
            MemberWs memberWs = new MemberWs();
            BeanUtils.copyProperties(memberCreated, memberWs);
            createMemberResponse.setMemberWs(memberWs);
        }
        return createMemberResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDeleteMemberRequest")
    @ResponsePayload
    public GetDeleteMemberResponse getDeleteMember(@RequestPayload GetDeleteMemberRequest request) {
        GetDeleteMemberResponse response = new GetDeleteMemberResponse();
        memberService.deleteMember(request.getId());
//       TODO
//        if (memberToDelete != null) {
//            MemberWs memberWs = new MemberWs();
//            BeanUtils.copyProperties(memberToDelete, memberWs);
//            response.setMemberWs(memberWs);
//        }
        return response;
    }

}
