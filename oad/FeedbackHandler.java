package oad;

import java.sql.SQLException;
import java.sql.Statement;

public class FeedbackHandler {
	
	public FeedbackHandler(){
	}
	
	public void addFeedback(String title, String msg) throws SQLException{
		Statement stmt;
		stmt = Program.current_session.server.getConn().createStatement();
		stmt.executeUpdate("INSERT INTO feedback (user_id, title, msg) VALUES ("+
				Program.current_session.getUser().getID() + ", '"+
				title + "' ,'" +
				msg + "' )");
	}
}
