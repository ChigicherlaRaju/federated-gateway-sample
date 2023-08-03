package com.raju.learning.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raju.learning.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

	@EntityGraph(attributePaths = { "books" })
	List<Author> findAll();

	Optional<Author> findByName(String name);

}