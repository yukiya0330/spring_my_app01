package com.example.demo.app.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookDao;
import com.example.demo.entity.Book;

@Service
public class BookServiceImpl implements BookService {

	private final BookDao dao;

	@Autowired public BookServiceImpl(BookDao dao) {
		this.dao = dao;
	}

	@Override
	public void save(Book book) {
		dao.insertBook(book);
	}

	@Override
	public List<Book> getAll() {
		return dao.getAll();
	}

	@Override
	public Optional<Book> getBook(int id) {
		return dao.findById(id);
	}

	@Override
	public Book findById(int id) {
		return dao.findById(id).get();
	}

	@Override
	public void update(Book book) {
	}

	@Override
	public Optional<Book> getId(int id) {
		return dao.findById(id);
	}

}
