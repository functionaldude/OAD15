package oad;
import oad.User;

import java.lang.Exception;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class session {
	public int sessionID;
	public User current_user;
	private boolean logged_in;
	public SQLConnection server;
	
	//constructor
	public session(){
		//connect to SQL
		server = new SQLConnection("jdbc:mysql://127.0.0.1:8889/OAD");
		this.logged_in = false;
	}
	public void addUser(String input_username, String input_pw, String input_email) throws Exception{
		if (this.checkForUser(input_username) == false){
			Statement stmt;
			try {
				stmt = server.getConn().createStatement();
				stmt.executeUpdate("INSERT INTO user (username, password, email) VALUES ('" 
				+ input_username + "', '" + input_pw + "', '" + input_email + "')");
			} catch (SQLException ex) {
	        	System.out.println("SQLException(add): " + ex.getMessage());
			}
		} else {
			throw new Exception("DuplicateUser");
		}
	}
	public Boolean getLoginState(){
		return this.logged_in;
	}
	public Boolean checkForUser(String input_username){
		Statement stmt;
		ResultSet res;
		Boolean retval = false;
		try {
			stmt = server.getConn().createStatement();
			res = stmt.executeQuery("SELECT username FROM user WHERE username = '" + input_username + "'");
			retval = res.first() && res.getString("username") == input_username;
		} catch (SQLException ex) {
        	System.out.println("SQLException(check): " + ex.getMessage());
        	return false;
		}
		return retval;
	}
	public void authenticate(String input_username, String input_pw) throws Exception {
		if (logged_in){
			throw new Exception("UserAlreadyIn");
		}
		Statement stmt;
		ResultSet res;
		try{
			stmt = server.getConn().createStatement();
			res = stmt.executeQuery("SELECT id, password, email FROM user WHERE username = '" + input_username + "'");
		}
		catch (SQLException ex) {
        	System.out.println("SQLException(auth): " + ex.getMessage());
        	return;
		}
		if (!res.first()){
			throw new Exception("NoSuchUser");
		} else {
			System.out.println("User found!");
			if (input_pw.equals(res.getString("password"))){
				this.current_user = new User(input_username, input_pw, res.getString("email"), res.getInt("id"));
				logged_in = true;
				System.out.println("Auth success!");
			} else {
				System.out.println(input_pw + " != " + res.getString("password"));
				throw new Exception("InvalidPW");
			}
		}
	}
	public void updateDB(){
		Statement stmt;
		try {
			stmt = server.getConn().createStatement();
			stmt.executeUpdate("UPDATE user SET password='"
			+current_user.getPW()+"', email='"+current_user.getEmail()+"' WHERE username='"+current_user.getUserName()+"')");
		} catch (SQLException ex) {
        	System.out.println("SQLException(update): " + ex.getMessage());
		}
	}
	public void deauthenticate(){
		this.current_user = null;
		this.logged_in = false;
	}
	public SQLConnection getServer(){
		return server;
	}
}
