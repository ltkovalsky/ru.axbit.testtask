package ru.axbit.testtask.controller;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ru.axbit.testtask.controller.datasource.*;
import ru.axbit.testtask.model.Author;
import ru.axbit.testtask.model.Book;

public class TableController {
	
	
	public static void fillTable(JTable table) {
		DefaultTableModel tModel = (DefaultTableModel) table.getModel();
		ConnectionFactory conFactory = new ConnectionFactory();
		
		if(tModel.getColumnName(0).equals("ISBN")) {
			BookDAO bookDao = new BookDaoJdbc(conFactory);
			LinkedList<Book> books = (LinkedList<Book>) bookDao.getAll();
			for(Book b : books) {
				tModel.addRow(new Object[] {String.valueOf(b.getIsbn()), b.getTheme()});
			}
			
		} else if(tModel.getColumnName(0).equals("Name")) {
			AuthorDAO authorDao = new AuthorDaoJdbc(conFactory);
			LinkedList<Author> authors = (LinkedList<Author>) authorDao.getAll();
			for(Author a : authors) {
				tModel.addRow(new Object[] {a.getName(), a.getSecondName(), a.getLastName(), a.getBirthDate()});
			}
		}
		
	}
}
