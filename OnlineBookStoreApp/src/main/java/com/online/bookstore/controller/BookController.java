package com.online.bookstore.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.bookstore.model.Book;
import com.online.bookstore.model.CheckoutBody;
import com.online.bookstore.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping("/book")
	private List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

	@GetMapping("/book/{bookid}")
	private Book getBook(@PathVariable("bookid") int bookid) {
		return bookService.getBookById(bookid);
	}
	
	@DeleteMapping("/book/{bookid}")
	private void deleteBook(@PathVariable("bookid") int bookid) {
		bookService.delete(bookid);
	}

	@PostMapping("/book")
	public int saveBook(@RequestBody Book book) {
		bookService.saveOrUpdate(book);
		return book.getBookid();
	}

	@PutMapping("/book")
	public Book update(@RequestBody Book book) {
		bookService.saveOrUpdate(book);
		return book;
	}
	
	@PostMapping("/checkout")
	public float checkout(@RequestBody CheckoutBody body) throws InterruptedException, ExecutionException {		
		String[] bookNames = body.getBooks();
		String promo = body.getPromo() != null ? body.getPromo() : "";
		return bookService.checkout(bookNames, promo);
	} 

}