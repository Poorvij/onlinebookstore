package com.online.bookstore.model;

import java.util.Arrays;

public class CheckoutBody {

	private String[] books;
	private String promo;

	public CheckoutBody() {

	}

	public CheckoutBody(String[] books, String promo) {
		this.books = books;
		this.promo = promo;
	}

	public String[] getBooks() {
		return books;
	}

	public void setBooks(String[] books) {
		this.books = books;
	}

	public String getPromo() {
		return promo;
	}

	public void setPromo(String promo) {
		this.promo = promo;
	}

	@Override
	public String toString() {
		return "CheckoutBody [books=" + Arrays.toString(books) + ", promo=" + promo + "]";
	}

}
