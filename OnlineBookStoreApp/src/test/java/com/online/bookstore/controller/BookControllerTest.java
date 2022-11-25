package com.online.bookstore.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import com.online.bookstore.model.Book;
import com.online.bookstore.service.BookService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	BookService bookService;

	@InjectMocks
	private BookController bookcontroller;

	private static ObjectMapper mapper = new ObjectMapper();

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

}
