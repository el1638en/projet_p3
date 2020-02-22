/*package com.openclassrooms.bibliotheque.controllers;

import org.occ.bibliot.client.endpoint.Book;
import org.occ.bibliot.client.endpoint.BookWeb;
import org.occ.bibliot.client.endpoint.BookWs;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class BookController {


	BookWeb bookWsService = new BookWeb();
	BookWs bookWs;

	public BookController() {
		this.bookWs = this.bookWsService.getBookWsPort();
	}

	@RequestMapping(value = {"/book/{bookId}"}, method = {RequestMethod.GET})

	@ResponseBody
	public Book sayHello (@PathVariable Integer bookId) {
		return bookWs.getBookById(bookId);
	}


}
*/

	
	
	

