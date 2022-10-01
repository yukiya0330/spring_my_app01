package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Book;

public interface BookDao {

	void insertBook(Book book);

	List<Book> getAll();

	Optional<Book> findById(int id);

	int update(Book book);

}
