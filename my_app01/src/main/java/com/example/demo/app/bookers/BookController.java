package com.example.demo.app.bookers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.app.service.BookService;
import com.example.demo.entity.Book;

@Controller
@RequestMapping("/bookers")
public class BookController {

	private final BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

//	一覧画面遷移
	@GetMapping
	public String index(Model model) {

		List<Book> list = bookService.getAll();
		model.addAttribute("bookList", list);
		return "bookers/index";
	}

}
