package com.example.demo.app.bookers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.app.service.BookService;
import com.example.demo.entity.Book;

@Controller
@RequestMapping("/books")
public class BookController {

	private final BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

//	一覧画面
	@GetMapping
	public String index(BookForm bookForm,
			BindingResult result,
			Model model) {
		List<Book> list = bookService.getAll();
		model.addAttribute("bookList", list);
		return "books/index";
	}

//	保存
	@PostMapping("/create")
	public String create(@Validated BookForm bookForm,
			BindingResult result,
			Model model,
//			@PathVariable("id") int id,
			RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			List<Book> list = bookService.getAll();
			model.addAttribute("bookList", list);
			return "books/index";
		}
		Book book = new Book();
		book.setTitle(bookForm.getTitle());
		book.setBody(bookForm.getBody());
		bookService.save(book);
//		redirectAttributes.addAttribute("complete", "Book was successfully created.");
//		redirectAttributes.addAttribute("id", id);
		return "redirect:/books/show";
	}

//	詳細画面
	@GetMapping("/{id}")
	public String show(Model model,
			@PathVariable("id") int id,
			@ModelAttribute("complete") String complete) {
		Book book = bookService.findById(id);
		model.addAttribute("bookData", book);
		return "books/show";
	}

//	編集画面
	@GetMapping("/edit/{id}")
	public String edit(BookForm bookForm,
			Model model,
			@PathVariable int id) {
		Book book = bookService.findById(id);
		model.addAttribute("bookForm", book);
		return "books/edit";
	}

//	アップデート
	@PostMapping("/update")
	public String update(BookForm bookForm,
			BindingResult result,
			Model model,
			RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			List<Book> list = bookService.getAll();
			model.addAttribute("bookList", list);
			return "books/edit";
		}
		Book book = new Book();
		book.setTitle(book.getTitle());
		book.setBody(book.getBody());
		bookService.update(book);
//		redirectAttributes.addAttribute("show", 1);
		return "redirect:/books";
	}

}
