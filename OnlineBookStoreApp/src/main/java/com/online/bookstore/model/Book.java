package com.online.bookstore.model;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookid;

	@Column(name = "bookName")
	private String bookName;

	@Column(name = "description")
	private String description;

	@Column(name = "author")
	private String author;

	@Column(name = "type")
	private String type;

	@Column(name = "price")
	private float price;

	@Column(name = "isbn")
	private int isbn;

	public Book() {

	}

	public Book(int bookid, String bookName, String description, String author, String type, float price, int isbn) {
		this.bookid = bookid;
		this.bookName = bookName;
		this.description = description;
		this.author = author;
		this.type = type;
		this.price = price;
		this.isbn = isbn;
	}

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book [bookid=" + bookid + ", bookName=" + bookName + ", description=" + description + ", author="
				+ author + ", type=" + type + ", price=" + price + ", isbn=" + isbn + "]";
	}

}
