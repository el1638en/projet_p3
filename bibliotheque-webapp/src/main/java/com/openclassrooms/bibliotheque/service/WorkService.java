package com.openclassrooms.bibliotheque.service;

import com.openclassrooms.bibliotheque.ws.WorkWs;

import java.util.List;

public interface WorkService {

    List<WorkWs> findWorks(String author);

    List<WorkWs> findWorksByTitle(String title);

    List<WorkWs> findWorksByPublicationDate(String publicationDate);


}
