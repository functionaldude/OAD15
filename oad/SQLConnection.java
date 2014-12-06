package oad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class SQLConnection{
    private String url;
    private static final String user = "root";
    private static final String passwd = "root";
    private Connection connect;
    public SQLConnection(String input_url){
    	url = input_url;
    	try {
    		Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			System.out.println("Exception at referencing MySQL Driver");
			System.out.println(e.getMessage());
		}
    }
    public Connection getConn(){
        if(connect == null){
            try {
                connect = DriverManager.getConnection(url, user, passwd);
            } catch (SQLException ex) {
            	JOptionPane.showMessageDialog(null, "Server error!");
            	System.out.println("Error at creating SQL connection");
            	System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
        }       
        return connect; 
    }
    public void closeConn(){
    	try {
			connect.close();
		} catch (SQLException ex) {
        	System.out.println("SQLException(close): " + ex.getMessage());
		}
    }
}
