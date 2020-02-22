package com.openclassrooms.bibliotheque.soap;

import com.openclassrooms.bibliotheque.models.Book;
import com.openclassrooms.bibliotheque.service.BookService;
import com.openclassrooms.projects.bibliotheque.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

//TODO : ajouter des commentaires sur les classes et les méthodes
@Endpoint
public class BookEndpoint {

    private static final String NAMESPACE_URI = "http://openclassrooms.com/projects/bibliotheque";

    @Autowired
    private BookService bookService;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getBookByIdRequest")
    @ResponsePayload
    public GetBookByIdResponse getBookById(@RequestPayload GetBookByIdRequest request) {
        GetBookByIdResponse response = new GetBookByIdResponse();
        Book book = bookService.getBookById(request.getId());
        if (book != null) {
            BookWs bookWs = new BookWs();
            BeanUtils.copyProperties(book, bookWs);
            response.setBookWs(bookWs);
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createBookRequest")
    @ResponsePayload
    public CreateBookResponse createBook(@RequestPayload CreateBookRequest request) {
        CreateBookResponse createBookResponse = new CreateBookResponse();
        Book book = new Book();
        BeanUtils.copyProperties(request.getBookWs(), book);
        Book bookCreated = bookService.create(request.getBookWs());
        if (bookCreated != null) {
            BookWs bookWs = new BookWs();
            BeanUtils.copyProperties(bookCreated, bookWs);
            createBookResponse.setBookWs(bookWs);
        }
        return createBookResponse;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDeleteBookRequest")
    @ResponsePayload
    public GetDeleteBookResponse getDeleteBook(@RequestPayload GetDeleteBookRequest request) {
        GetDeleteBookResponse response = new GetDeleteBookResponse();
        bookService.deleteBook(request.getId());
//        TODO : à enlever
//        if (bookToDelete != null) {
//            BookWs bookWs = new BookWs();
//            BeanUtils.copyProperties(bookToDelete, bookWs);
//            response.setBookWs(bookWs);
//        }
        return response;
    }

}

