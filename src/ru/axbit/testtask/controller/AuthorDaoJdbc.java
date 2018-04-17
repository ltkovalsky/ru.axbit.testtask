package ru.axbit.testtask.controller;

import java.util.LinkedList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ru.axbit.testtask.model.Author;


public class AuthorDaoJdbc implements AuthorDAO {
	
	public static final String SELECT_BY_ID_QUERY = "SELECT * FROM authors WHERE id = ?";
	public static final String INSERT_QUERY = "INSERT INTO authors (name, secondName, lastName, birthDate) VALUES('?', '?', '?', '?')";
	public static final String UPDATE_QUERY = "UPDATE authors SET name = '?' secondName = '?' lastName = '?' birthDate = '?' WHERE id = ? ";
	public static final String DELETE_QUERY = "DELETE FROM authors WHERE id = ?";	
	
	public static final String COL_ID = "id";
	public static final String COL_NAME = "name";
	public static final String COL_SECONDNAME = "secondName";
	public static final String COL_LASTNAME = "lastname";
	public static final String COL_BIRTHDATE = "birthDate";
	
	/*
	 * I used connection factory for access to DB.
	 * Connection pool looks better, but HSQLDB in-process mode can't get more than one connection. 
	 */
	private ConnectionFactory conFactory;
	

	public AuthorDaoJdbc(ConnectionFactory conFactory) {
		this.conFactory = conFactory;
	}
	
	@Override
	public Author getById(long id) {
		try (Connection con = conFactory.getConnection();
			PreparedStatement st = con.prepareStatement(SELECT_BY_ID_QUERY);) {
			st.setLong(1, id);
			try (ResultSet resSet = st.executeQuery();) {
				while(resSet.next()) {
					return new Author(resSet.getString(COL_NAME), 
							resSet.getString(COL_SECONDNAME), 
							resSet.getString(COL_LASTNAME),
							resSet.getDate(COL_BIRTHDATE));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(Author author) {
		
		try (Connection con = conFactory.getConnection();
				PreparedStatement st = con.prepareStatement(INSERT_QUERY);) {
			st.setString(1, author.getName());
			st.setString(2, author.getSecondName());
			st.setString(3, author.getLastName());
			st.setDate(4, author.getBirthDate());
			
			st.executeUpdate();			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Author> getAll() {
		List<Author> result = new LinkedList<Author>();
		
		try(Connection con = conFactory.getConnection();
				PreparedStatement st = con.prepareStatement("SELECT * FROM authors");){
			
			ResultSet resSet = st.executeQuery();
			
			while(resSet.next()) {
				result.add(new Author(resSet.getLong(COL_ID),
						resSet.getString(COL_NAME),
						resSet.getString(COL_SECONDNAME),
						resSet.getString(COL_LASTNAME),
						resSet.getDate(COL_BIRTHDATE)));
			}
			
			return result;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void update(Author author) {
		try (Connection con = conFactory.getConnection();
				PreparedStatement st = con.prepareStatement(UPDATE_QUERY);){
			
			st.setString(1, author.getName());
			st.setString(2, author.getSecondName());
			st.setString(3, author.getLastName());
			st.setDate(4, author.getBirthDate());
			st.setLong(5, author.getId());
			
			st.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(long id) {
		try (Connection con = conFactory.getConnection();
				PreparedStatement st = con.prepareStatement(DELETE_QUERY)) {
			st.setLong(1, id);
			st.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//OK. Just don't use this shit without REAL NECESSITY
	@Override
	public void deleteAll() {
		try (Connection con = conFactory.getConnection();
				PreparedStatement st = con.prepareStatement("DELETE FROM authors")) {
			st.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
