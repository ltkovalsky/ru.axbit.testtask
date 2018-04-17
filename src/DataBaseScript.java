import java.sql.Connection;
import java.sql.Statement;
import java.util.Calendar;
import java.sql.Date;

import ru.axbit.testtask.controller.datasource.ConnectionFactory;

public class DataBaseScript {
	
	public static void run() {
		Connection con = null;
	    Statement st = null;
	      
	    try {
	    	
	    	con = new ConnectionFactory().getConnection();
	    	st = con.createStatement();
	    	
	    	
	    	st.executeQuery("CREATE TABLE IF NOT EXISTS authors (id BIGINT IDENTITY PRIMARY KEY, "
	    			+ "name VARCHAR(50), "
	    			+ "secondName VARCHAR(50), "
	    			+ "lastName VARCHAR(50), "
	    			+ "birthDate DATE) ");
	    	Date date = new Date(Calendar.getInstance().getTimeInMillis());
	    	st.executeUpdate("INSERT INTO authors (name, secondName, lastName, birthDate) VALUES('a', 'a', 'a', '2000-09-12')");
	    	
	    	
	    	st.executeUpdate("CREATE TABLE IF NOT EXISTS books (isbn BIGINT PRIMARY KEY, theme VARCHAR(50))");	    	
	    	
	    	st.executeUpdate("DELETE FROM books");
			
			st.executeUpdate("INSERT INTO books (isbn, theme) VALUES('1234567890000', 'Триллер')");
			st.executeUpdate("INSERT INTO books (isbn, theme) VALUES('1234567890001', 'Триллер')");
			st.executeUpdate("INSERT INTO books (isbn, theme) VALUES('1234567890002', 'Триллер')");
			st.executeUpdate("INSERT INTO books (isbn, theme) VALUES('1234567890003', 'Триллер')");
			
			st.close();
	    	con.close();
			
	      }  catch (Exception e) {
	         e.printStackTrace(System.out);
	      } finally {
	    	  
	      }
	      System.out.println("Table created successfully");
	}
	
}
