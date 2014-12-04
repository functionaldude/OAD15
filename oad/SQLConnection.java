package oad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection{
    private String url;
    private static String user = "root";
    private static String passwd = "root";
    private Connection connect;
    public SQLConnection(String input_url){
    	url = input_url;
    	try {
    		Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			System.out.println("forName error: " + e.getMessage());
		}
    }
    public Connection getInstance(){
        if(connect == null){
            try {
                connect = DriverManager.getConnection(url, user, passwd);
            } catch (SQLException ex) {
            	System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
        }       
        return connect; 
    }
}