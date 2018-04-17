package ru.axbit.testtask.controller.datasource;

import ru.axbit.testtask.model.Author;
import java.util.List;

//TODO: make unification w BookDAO

public interface AuthorDAO {
	
	Author getById(long id);
	
	void insert(Author author);
	
	List<Author> getAll();
	
	void update(Author author);
	
	void deleteById(long id);
	
	void deleteAll();

}
