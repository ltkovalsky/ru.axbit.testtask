package ru.axbit.testtask.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import ru.axbit.testtask.model.Book;

public class BookDaoJdbc implements BookDAO {
	
	public static final String SELECT_BY_ID_QUERY = "SELECT * FROM books WHERE isbn = ?";
	public static final String INSERT_QUERY = "INSERT INTO books (isbn, theme) VALUES('?', '?')";
	public static final String UPDATE_QUERY = "UPDATE books SET theme = '?' WHERE isbn = ? ";
	public static final String DELETE_QUERY = "DELETE FROM books WHERE isbn = ?";	
	
	public static final String COL_ISBN = "isbn";
	public static final String COL_THEME = "theme";
	
	ConnectionFactory conFactory;
	
	public BookDaoJdbc(ConnectionFactory conFactory) {
		this.conFactory = conFactory;
	}

	@Override
	public Book getById(long id) {
		try (Connection con = conFactory.getConnection();
				PreparedStatement st = con.prepareStatement(SELECT_BY_ID_QUERY);) {
				st.setLong(1, id);
				try (ResultSet resSet = st.executeQuery();) {
					while(resSet.next()) {
						return new Book(resSet.getLong(COL_ISBN), resSet.getString(COL_THEME));
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
	}

	@Override
	public void insert(Book book) {
		try (Connection con = conFactory.getConnection();
				PreparedStatement st = con.prepareStatement(INSERT_QUERY);) {
			st.setLong(1, book.getIsbn());
			st.setString(2, book.getTheme());
			
			st.executeUpdate();			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Book> getAll() {
		List<Book> result = new LinkedList<Book>();
		
		try(Connection con = conFactory.getConnection();
				PreparedStatement st = con.prepareStatement("SELECT * FROM books");){
			
			ResultSet resSet = st.executeQuery();
			
			while(resSet.next()) {
				result.add(new Book(resSet.getLong(COL_ISBN), resSet.getString(COL_THEME)));
			}
			
			return result;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(Book book) {
		try (Connection con = conFactory.getConnection();
				PreparedStatement st = con.prepareStatement(UPDATE_QUERY);){
			
			st.setString(1, book.getTheme());
			st.setLong(2, book.getIsbn());
			
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

	// Really. I'm serious. Don't use this without REAL good reason.
	@Override
	public void deleteAll() {
		try (Connection con = conFactory.getConnection();
				PreparedStatement st = con.prepareStatement("DELETE FROM books")) {
			st.executeUpdate();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
