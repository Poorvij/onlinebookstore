package com.online.bookstore.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.bookstore.model.Book;
import com.online.bookstore.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;

	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<Book>();
		bookRepository.findAll().forEach(books1 -> books.add(books1));
		System.out.println("Books: " + books);
		return books;
	}

	public Book getBookById(int bookid) {
		return bookRepository.findById(bookid).get();
	}

	public void saveOrUpdate(Book books) {
		bookRepository.save(books);
	}

	public void delete(int bookid) {
		bookRepository.deleteById(bookid);
	}

	public void update(Book books, int bookid) {
		bookRepository.save(books);
	}

	public float checkout(String[] bookNames, String promo) {
		float totalAmount = 0;

		for (String bookName : bookNames) {

			List<Book> books = bookRepository.findByBookName(bookName);
			for (Book book : books) {
				System.out.println("Book Name: " + book.getBookName());
				System.out.println(book.getBookName() + " - " + book.getPrice());
				if (promo.contains("fiction") && book.getType().equalsIgnoreCase("Fiction")) {
					totalAmount += (book.getPrice() - (book.getPrice() * 10 / 100));
				} else {
					totalAmount += book.getPrice();
				}
			}
		}
		return totalAmount;
	}

}
