package com.openclassrooms.bibliotheque.soap;

import com.openclassrooms.bibliotheque.models.Work;
import com.openclassrooms.bibliotheque.service.WorkService;
import com.openclassrooms.projects.bibliotheque.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

//TODO : ajouter des commentaires sur les classes et les méthodes

@Endpoint
public class WorkEndpoint {

    private static final String NAMESPACE_URI = "http://openclassrooms.com/projects/bibliotheque";

    @Autowired
    private WorkService workService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getWorkByAuthorRequest")
    @ResponsePayload
    public GetWorkByAuthorResponse getWorksByAuthor(@RequestPayload GetWorkByAuthorRequest request) {
        GetWorkByAuthorResponse response = new GetWorkByAuthorResponse();
        List<Work> works = workService.getWorksByAuthor(request.getAuthor());
        if (works != null && !works.isEmpty()) {
            List<WorkWs> listworkWs = new ArrayList<>();
            for (Work work : works) {
                WorkWs workWs = new WorkWs();
                BeanUtils.copyProperties(work, workWs);
                listworkWs.add(workWs);
            }
            response.getWorkWs().addAll(listworkWs);
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getWorkByTitleRequest")
    @ResponsePayload
    public GetWorkByTitleResponse getWorksByTitle(@RequestPayload GetWorkByTitleRequest request) {
        GetWorkByTitleResponse response = new GetWorkByTitleResponse();
        List<Work> works = workService.getWorksByTitle(request.getTitle());
        if (works != null && !works.isEmpty()) {
            List<WorkWs> listworkWs = new ArrayList<>();
            for (Work work : works) {
                WorkWs workWs = new WorkWs();
                BeanUtils.copyProperties(work, workWs);
                listworkWs.add(workWs);
            }
            response.getWorkWs().addAll(listworkWs);
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getWorkByPublicationDateRequest")
    @ResponsePayload
    public GetWorkByPublicationDateResponse getWorksByPublicationDate(@RequestPayload GetWorkByPublicationDateRequest request) {
        GetWorkByPublicationDateResponse response = new GetWorkByPublicationDateResponse();
        List<Work> works = workService.getWorksByPublicationDate(request.getPublicationDate());
        if (works != null && !works.isEmpty()) {
            List<WorkWs> listworkWs = new ArrayList<>();
            for (Work work : works) {
                WorkWs workWs = new WorkWs();
                BeanUtils.copyProperties(work, workWs);
                listworkWs.add(workWs);
            }
            response.getWorkWs().addAll(listworkWs);
        }
        return response;
    }
}

