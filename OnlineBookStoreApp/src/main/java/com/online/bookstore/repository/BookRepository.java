package com.online.bookstore.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.online.bookstore.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer>  {

	public List<Book> findByBookName(String bookName);
}