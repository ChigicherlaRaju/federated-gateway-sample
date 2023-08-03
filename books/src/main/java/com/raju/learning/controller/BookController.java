package com.raju.learning.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.raju.learning.model.Author;
import com.raju.learning.model.Book;
import com.raju.learning.service.BookService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class BookController {

	private final BookService bookService;

	@SchemaMapping(typeName = "Query", value = "allBooks")
	public List<Book> allBooks() {
		return bookService.getAllBooks();
	}

	@QueryMapping
	public Book findOne(@Argument Integer id) {
		return bookService.getBookById(id);
	}

	@QueryMapping
	public List<Author> allAuthors() {
		return bookService.getAllAuthors();
	}

	@QueryMapping
	public Author findAuthor(@Argument Integer id) {
		return bookService.getAuthorById(id);
	}

	public Author findAuthorByName(@Argument String name) {
		return bookService.getAuthorByName(name);
	}

}