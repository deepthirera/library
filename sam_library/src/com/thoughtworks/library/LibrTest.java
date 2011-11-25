package com.thoughtworks.library;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.junit.Test;

public class LibrTest {

	int sno = 0;
	String name = "", auth = "";

	@Test
	public void testsetdetails() throws IOException {
		Book b = new Book(1, "one", "authone");
		assertEquals(1, b.sno);
		assertEquals("one", b.title);
		assertEquals("authone", b.author);
	}

	@Test
	public void testaddbook() throws IOException {
		Libr library = new Libr();
		// assertEquals(library.addBooks(1, "one", "oneauth"),1);
		// assertEquals(library.addBooks(1, "one", "oneauth"),2);
		ArrayList<Book> books = new ArrayList<Book>();
		books = library.addBooks(1, "one", "oneauth");
		assertEquals(books.get(0).sno, 1);
		assertEquals(books.get(0).title, "one");
		assertEquals(books.get(0).author, "oneauth");

	}

	@Test(expected = IllegalArgumentException.class)
	public void testSearchbook() throws IllegalArgumentException {
		Libr library = new Libr();
		library.searchBook(1);
		library.addBooks(1, "one", "oneauth");
		library.addBooks(2, "two", "twoauth");
		assertEquals(library.searchBook(1), "available");
		library.searchBook(10);
		library.addBooks(10, "ten", "tenauth");
		assertEquals(library.searchBook(10), "available");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testborrowBook() throws IllegalArgumentException {
		Libr library = new Libr();
		library.addBooks(1, "one", "oneauth");
		library.addBooks(2, "two", "twoauth");
		library.addBooks(3, "three", "thauth");
		assertEquals(library.borrowBook(2), "borrowed");
		library.borrowBook(5);
		library.borrowBook(2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testreturnBook() throws IllegalArgumentException {
		Libr library = new Libr();
		library.addBooks(1, "one", "oneauth");
		library.addBooks(2, "two", "twoauth");
		library.searchBook(5);
		ArrayList<Book> books = new ArrayList<Book>();
		books = library.returnBooks(5, "three", "thauth");
		assertEquals(library.searchBook(5), 5);
	}

}
