package ru.axbit.testtask.model;

public class Book {
	private long isbn;
	private String theme;
	
	public Book(long isbn) {
		this.setIsbn(isbn);
		this.setTheme(null);
	}
	
	public Book(long isbn, String theme) {
		this.setIsbn(isbn);
		this.setTheme(theme);
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		if(isbn>=0 && String.valueOf(isbn).length() >= 13) {
			this.isbn = isbn;
		}  else {
			throw new IllegalArgumentException("ISBN can't be less than 0");
		}
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
}
