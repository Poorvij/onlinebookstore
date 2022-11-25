package com.online.bookstore.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.online.bookstore.Application;
import com.online.bookstore.model.Book;

@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest(classes = Application.class)
public class BookRepositoryTest {	
	 
	   @Autowired
	   private BookRepository bookRepository;
	 
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
	   
	   @Test
	   public void testFindById() {
	      Book book = getBook();	     
	      bookRepository.save(book);
	      Book result = bookRepository.findById(book.getBookid()).get();
	      assertEquals(book.getBookid(), result.getBookid());	     
	   }
	   
	   @Test
	   public void testFindAll() {
		   Book book = getBook();
	      bookRepository.save(book);
	      List<Book> result = new ArrayList<>();
	      bookRepository.findAll().forEach(e -> result.add(e));
	      assertEquals(result.size(), 5);	     
	   }
	   @Test
	   public void testSave() {
		   Book book = getBook();
	      bookRepository.save(book);
	      Book found = bookRepository.findById(book.getBookid()).get();
	      assertEquals(book.getBookid(), found.getBookid());	     
	   }
	   
	   @Test
	   public void testDeleteById() {
		   Book book = getBook();
	      bookRepository.save(book);
	      bookRepository.deleteById(book.getBookid());
	      List<Book> result = new ArrayList<>();
	      bookRepository.findAll().forEach(e -> result.add(e));
	      assertEquals(result.size(), 4);
	   }
	   
	   @Test
	   public void testFindByName() {
		   Book book = getBook();
	      bookRepository.save(book);
	      List<Book> result = new ArrayList<>();
	      bookRepository.findByBookName(book.getBookName()).forEach(e -> result.add(e));
	      assertEquals(result.size(), 1);	     
	   }
	   
	
}
