package oad;

import java.sql.SQLException;
import java.sql.Statement;

public class FeedbackHandler {
	private session current_session;
	
	public FeedbackHandler(session input){
		current_session = input;
	}
	
	public void addFeedback(String title, String msg){
		Statement stmt;
		try {
			stmt = current_session.getServer().getConn().createStatement();
			stmt.executeUpdate("INSERT INTO feedback (user_id, title, msg) VALUES ("+
					current_session.getUser().getID() + ", '"+
					title + "' ,'" +
					msg + "' )");
		} catch (SQLException ex) {
		    System.out.println("Error at creating feedback");
		    System.out.println("SQLException: " + ex.getMessage());
		}
	}
}
