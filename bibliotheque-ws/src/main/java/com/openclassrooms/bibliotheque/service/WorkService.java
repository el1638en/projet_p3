package com.openclassrooms.bibliotheque.service;

import com.openclassrooms.bibliotheque.models.Work;
import com.openclassrooms.projects.bibliotheque.WorkWs;

import java.util.List;

//TODO : ajouter des commentaires sur les classes et les méthodes
public interface WorkService {

    List<Work> getWorksByAuthor(String author);

    List<Work> getWorksByTitle(String title);

    List<Work> getWorksByPublicationDate(String publicationDate);

    Work create(WorkWs work);

    Work deleteWork(Long workId);


}