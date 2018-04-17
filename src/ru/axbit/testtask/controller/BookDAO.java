package ru.axbit.testtask.controller;

import java.util.List;

import ru.axbit.testtask.model.Book;

//TODO: make unification w AuthorDAO

public interface BookDAO {
	
	Book getById(long id);
	
	void insert(Book book);
	
	List<Book> getAll();
	
	void update(Book book);
	
	void deleteById(long id);
	
	void deleteAll();

}
