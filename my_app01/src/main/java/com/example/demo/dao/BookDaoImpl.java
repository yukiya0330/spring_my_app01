package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Book;

@Repository
public class BookDaoImpl implements BookDao {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public BookDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insertBook(Book book) {
		jdbcTemplate.update("INSERT INTO book(title, body) VALUES(?, ?)",
				book.getTitle(), book.getBody());
	}

	@Override
	public List<Book> getAll() {
		String sql = "SELECT id, title, body FROM book";
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		List<Book> list = new ArrayList<Book>();
		for(Map<String, Object> result : resultList) {
			Book book = new Book();
			book.setId((int)result.get("id"));
			book.setTitle((String)result.get("title"));
			book.setBody((String)result.get("body"));
			list.add(book);
		}
		return list;
	}

	@Override
	public Optional<Book> findById(int id) {
		String sql = "SELECT book.id, title, body FROM book WHERE book.id = ?";
		Map<String, Object> result = jdbcTemplate.queryForMap(sql, id);
		Book book = new Book();
		book.setId((int)result.get("id"));
		book.setTitle((String)result.get("title"));
		book.setBody((String)result.get("body"));

		Optional<Book> bookOpt = Optional.ofNullable(book);
		return bookOpt;
	}

	@Override
	public int update(Book book) {
		return jdbcTemplate.update("UPDATE book SET id = ?, title = ?, body = ? WHERE id = ?",
				book.getBody(), book.getTitle());
	}

}
