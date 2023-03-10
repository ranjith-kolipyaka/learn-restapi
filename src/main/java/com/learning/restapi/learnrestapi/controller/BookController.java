package com.learning.restapi.learnrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.restapi.learnrestapi.entity.Book;
import com.learning.restapi.learnrestapi.repository.BookRepository;
import com.learning.restapi.learnrestapi.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookService bookService;

	@GetMapping("")
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	@GetMapping("filter")
	public List<Book> getAllBooksById() {
		return bookService.filterByName("Rana naidu");
	}
	@GetMapping("filterByPublish")
	public List<Book> yearPublished(Integer yearPublished){
		return bookService.yearPublished(2021);
	}

	@GetMapping("/{id}")
	public Book getBookById(@PathVariable Long id) {
		return bookRepository.findById(id).orElse(null);

	}

	@PostMapping("")
	public Book createBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}

	@PutMapping("")
	public Book updateBook(@RequestBody Book book) {
		return bookRepository.save(book);
	}

	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable Long id) {
		bookRepository.deleteById(id);
	}
}
