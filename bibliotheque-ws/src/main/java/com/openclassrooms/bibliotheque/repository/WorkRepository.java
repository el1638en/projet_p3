package com.openclassrooms.bibliotheque.repository;

import com.openclassrooms.bibliotheque.models.Work;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//TODO : ajouter des commentaires sur les classes et les méthodes

@Repository
public interface WorkRepository extends CrudRepository<Work, Long> {

    List<Work> findByPublicationDate(String publicationDate);

    List<Work> findByAuthorIsContainingIgnoreCase(String author);

    List<Work> findByTitleIsContainingIgnoreCase(String title);

    void deleteById(Long workId);

    Work save(Work work);

}
