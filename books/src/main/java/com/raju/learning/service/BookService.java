package com.raju.learning.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.raju.learning.model.Author;
import com.raju.learning.model.Book;
import com.raju.learning.repository.AuthorRepository;
import com.raju.learning.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookService {

	private final BookRepository bookRepository;
	private final AuthorRepository authorRepository;

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public Book getBookById(Integer id) {
		return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found with ID: " + id));
	}

	public List<Author> getAllAuthors() {
		return authorRepository.findAll();
	}

	public Author getAuthorById(Integer id) {
		return authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found with ID: " + id));
	}
	
	public Author getAuthorByName(String name) {
		return authorRepository.findByName(name).orElseThrow(() -> new RuntimeException("Author not found with name: " + name));
	}

}