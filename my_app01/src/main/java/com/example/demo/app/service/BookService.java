package com.example.demo.app.service;

import java.util.List;

import com.example.demo.entity.Book;

public interface BookService {

	void save(Book book);

	List<Book> getAll();

}
