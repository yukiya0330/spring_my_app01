package com.example.demo.app.bookers;

import javax.validation.constraints.NotNull;

public class BookForm {

	private int id;

	@NotNull
	private String title;

	@NotNull
	private String body;

	public BookForm() {
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}