package com.learning.restapi.learnrestapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.restapi.learnrestapi.entity.Book;
import com.learning.restapi.learnrestapi.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;

	public List<Book> filterByName(String author) {
		List<Book> books = bookRepository.findAll();
		books.removeIf(book -> book.getAuthor().equalsIgnoreCase(author));
		return books;
	}
	
	public List<Book> yearPublished(int yearPublished){
		List<Book> books = bookRepository.findAll();
		books.retainAll(books);
		return books;
	}
}
