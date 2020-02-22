package com.openclassrooms.bibliotheque.service;

import com.openclassrooms.bibliotheque.models.Book;
import com.openclassrooms.projects.bibliotheque.BookWs;

//TODO : ajouter des commentaires sur les classes et les méthodes
public interface BookService {


    Book getBookById(Long bookId);

    void deleteBook(Long bookId);

    Book create(BookWs book);

}
