package oad;
import oad.User;

import java.lang.Exception;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class session {
	public int sessionID;
	private boolean logged_in;
	private User current_user;
	private game current_game;
	public SQLConnection server;
	public FeedbackHandler feedbackhandler;
	public AudioHandler musicplayer;
	
	//constructor
	public session(){
		this.logged_in = false;
	}
	public void addUser(String input_username, String input_pw, String input_email) throws Exception{
		if (this.checkForUser(input_username) == false){
			Statement stmt;
			try {
				stmt = server.getConn().createStatement();
				stmt.executeUpdate("INSERT INTO user (username, password, email) VALUES ('"+ 
						input_username+"', '"+
						input_pw+"', '"+
						input_email+
						"')");
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
			res = stmt.executeQuery("SELECT id FROM user WHERE username = '" + input_username + "'");
			retval = res.first();
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
	public void syncBackUserData(){
		Statement stmt;
		try {
			stmt = server.getConn().createStatement();
			stmt.executeUpdate("UPDATE user SET password='"+current_user.getPW()+
					"', email='"+current_user.getEmail()+
					"', username='"+current_user.getUserName()+
					"' WHERE id="+current_user.getID());
		} catch (SQLException ex) {
        	System.out.println("Error at pushing userdata");
        	System.out.println("SQLException: " + ex.getMessage());
		}
	}
	public void deauthenticate(){
		this.current_user = null;
		this.logged_in = false;
	}
	public User getUser(){
		return current_user;
	}
	
	public void resetPW(String username) throws Exception{
		if (checkForUser(username)){
			
		} else {
			throw new Exception("NoSuchUser");
		}
	}
	public void registerPWreset(String input_username, String input_email) throws Exception{
		if (checkForUser(input_username)){
			Statement stmt = server.getConn().createStatement();
			ResultSet res = stmt.executeQuery("SELECT id FROM user WHERE username = '"+input_username+"' AND email = '"+input_email+"'");
			res.next();
			stmt.executeUpdate("INSERT INTO pwresets (user_id) VALUES (" + res.getInt(1) + ")");
		} else {
			throw new Exception("NoSuchUser");
		}
	}
	
	//admin functions
	public List<User> searchUser(String input) throws SQLException{
		List<User> ret_val = new ArrayList<User>();
		Statement stmt = server.getConn().createStatement();
		ResultSet res;
		if (input == null){ // null -> all users
			res = stmt.executeQuery("SELECT * FROM user");
		} else {
			res = stmt.executeQuery("SELECT * FROM user WHERE username LIKE '"+input+"%'");
		}
		while(res.next()){
			ret_val.add(new User(res.getString("username"), res.getString("password"), res.getString("email"), res.getInt("id")));
		}
		return ret_val;
	}
	public void deleteUser(String username) throws SQLException{
		Statement stmt = server.getConn().createStatement();
		stmt.executeUpdate("DELETE FROM user WHERE username = '" + username +"'");
	}
}
