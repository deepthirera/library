package com.thoughtworks.library;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Libr {
	public int copies = 0;
	ArrayList<Book> books = new ArrayList<Book>();
	Map<Integer, String> bookStatus = new HashMap<Integer, String>();
	Map<Integer, Integer> bookCopies = new HashMap<Integer, Integer>();

	public ArrayList addBooks(int sno, String title, String author) {
		// public int addBooks(int sno, String title, String author) {

		Book addedbook = new Book(sno, title, author);
		books.add(addedbook);
		bookStatus.put(sno, "available");
		int size = bookStatus.size();
		for (int j = 0; j < size; j++) {
			if (bookStatus.get(sno).equals("available")) {
				copies++;
			}
		}
		bookCopies.put(sno, copies);

		return this.books;
		// return copies;
	}

	public int get_no_of_books() {
		return books.size();
	}

	public String searchBook(int sno) throws IllegalArgumentException {
		int size = get_no_of_books();
		for (int j = 0; j < size; j++) {
			if ((books.get(j).sno == sno)
					&& bookStatus.get(sno).equals("available")
					&& bookCopies.get(sno) > 0) {
				return "available";
			}
		}
		throw new IllegalArgumentException("not available");

	}

	public String borrowBook(int sno) throws IllegalArgumentException {
		int size = get_no_of_books();
		for (int j = 0; j < size; j++) {
			if ((books.get(j).sno == sno)
					&& (bookStatus.get(sno).equals("available") && bookCopies
							.get(sno) > 0)) {
				copies--;
				bookCopies.put(sno, copies);
				if (copies <= 0) {
					bookStatus.put(sno, "notavailable");
					throw new IllegalArgumentException("not available");

				}
				return "borrowed";
			}
		}
		throw new IllegalArgumentException("not available");
	}

	public ArrayList returnBooks(int sno, String title, String author) {
		books.add(new Book(sno, title, author));
		bookStatus.put(sno, "available");
		int size = bookStatus.size();
		for (int j = 0; j < size; j++) {
			if (bookStatus.get(sno).equals("available")) {
				copies++;
			}
		}
		bookCopies.put(sno, copies);
		return this.books;

	}
}

class Book {
	public String title;
	public String author;
	public int sno;
	public int flag;

	public Book(int sno, String title, String author) {
		this.sno = sno;
		this.title = title;
		this.author = author;
	}

	public String get_tit(String title) {
		return title;
	}

	public String get_auth(String author) {
		return author;
	}

	public int get_sno(int sno) {
		return sno;
	}
}
/*
 * if (bookStatus.containsValue(sno)) { copies = (Integer) obMap.get(sno);
 * copies++; bookStatus.put(sno, copies); } else bookStatus.put(sno, 1); }
 */