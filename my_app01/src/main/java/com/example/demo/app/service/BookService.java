package com.example.demo.app.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Book;

public interface BookService {

	void save(Book book);

	List<Book> getAll();

	Optional<Book> getBook(int id);

	Book findById(int id);

	void update(Book book);

}
