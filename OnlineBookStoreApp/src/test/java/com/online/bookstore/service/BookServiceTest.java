package com.online.bookstore.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.online.bookstore.model.Book;
import com.online.bookstore.model.CheckoutBody;

@SpringBootTest
public class BookServiceTest {

	@Autowired
	BookService bookService;

	private Book getBook() {
		Book book = new Book();
		book.setBookid(4);
		book.setBookName("Masha");
		book.setAuthor("TestAuthor");
		book.setDescription("This is a book");
		book.setIsbn(123453);
		book.setPrice(66);
		book.setType("Comic");

		return book;
	}

	private CheckoutBody body() {
		CheckoutBody body = new CheckoutBody();
		String[] names = { "Masha" };
		body.setBooks(names);
		body.setPromo("Fiction");
		return body;
	}

	@Test
	public void checkoutTest() {
		Book book = getBook();
		CheckoutBody body = body();
		String[] bookNames = body.getBooks();
		String promo = body.getPromo();
		float books = bookService.checkout(bookNames, promo);
		assertEquals(books, 0.0);
	}

}
