package ru.axbit.testtask.model;

import java.sql.Date;
import java.util.LinkedList;

public class Author {
	private long id;	// task doesn't contains this field. Added for better interaction with DB
	private String name;
	private String secondName;
	private String lastName;
	private Date birthDate;		// used java.sql.Date for better compatibility with DB format
	private LinkedList<Book> books;	
	
	/**
	 * Creates Author w/o id. Use this in GUI.
	 * @param name
	 * @param secondName
	 * @param lastName
	 * @param birthDate 
	 */
	public Author(String name, String secondName, String lastName, Date birthDate) {
		this.setName(name);
		this.setSecondName(secondName);
		this.setLastName(lastName);
		this.setBirthDate(birthDate);
		this.setBooks(new LinkedList<Book>());
	}
	
	/**
	 * Creates Author with id. Use this in DB interaction.
	 * @param id - Get this parameter from DB.
	 * @param name
	 * @param secondName
	 * @param lastName
	 * @param birthDate
	 */
	public Author(long id, String name, String secondName, String lastName, Date birthDate) {
		this.id = id;
		this.setName(name);
		this.setSecondName(secondName);
		this.setLastName(lastName);
		this.setBirthDate(birthDate);
		this.setBooks(new LinkedList<Book>());
	}
	
	public long getId() {
		return this.id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public LinkedList<Book> getBooks() {
		return books;
	}

	public void setBooks(LinkedList<Book> books) {
		this.books = books;
	}	
	
}
