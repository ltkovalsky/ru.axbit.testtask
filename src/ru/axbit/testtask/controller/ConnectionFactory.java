package ru.axbit.testtask.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory {

    public static final String DRIVER = "org.hsqldb.jdbcDriver";
    public static final String DB_URL = "jdbc:hsqldb:file:test/mydb";
    public static final String LOGIN = "sa";
    public static final String PASSWORD = "";

    private static ConnectionFactory instance;

    private ConnectionFactory() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Not found class " + DRIVER, e);
        }
    }

    public static synchronized ConnectionFactory getInstance() {
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, LOGIN, PASSWORD);
    }
    
    public void closeConnection() throws SQLException {
    	PreparedStatement st = this.getConnection().prepareStatement("SHUTDOWN");
    	st.executeQuery();
    }
    
    @Override
    protected void finalize() throws Throwable {
    	this.closeConnection();
    	super.finalize();
    }
    
}