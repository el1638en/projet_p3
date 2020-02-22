package com.openclassrooms.bibliotheque.service.impl;

import com.openclassrooms.bibliotheque.models.Book;
import com.openclassrooms.bibliotheque.repository.BookRepository;
import com.openclassrooms.bibliotheque.service.BookService;
import com.openclassrooms.projects.bibliotheque.BookWs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class BookServiceImpl implements BookService {

    private static Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    private BookRepository bookRepository;

    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId).get();
    }

    public void deleteBook(Long bookId) {
        LOGGER.info("suppression d'un livre: {}", bookId);
        bookRepository.deleteById(bookId);
    }

    @Override
    public Book create(BookWs book) {
        Book bookCreated = new Book();
        BeanUtils.copyProperties(book, bookCreated);
        return bookRepository.save(bookCreated);
    }
}

