package oad;
import java.lang.Exception;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class game {
	//initial data
	private int id;
	private int user_id;
	private String name;
	private int rating[];
	private int privacy;
	private String rawdata;
	private Boolean editable;
	
	//constructors
	public game(String input_name){
		this.name = input_name;
		this.rating = new int[] {0,0};
	}
	
	public String getName(){
		return name;
	}
	public float getRating() throws Exception{
		if (this.rating[1] > 5){
			return this.rating[0] / this.rating[1];
		} else {
			throw new Exception("NotEnoughRating");
		}
	}
	public void addRating(int input_rating) throws Exception{
		if (input_rating > 5 || input_rating < 1){
			throw new Exception("Invalid_Rating");
		} else {
			this.rating[0] += input_rating;
			this.rating[1]++;
		}
	}
	public void resetRating(){
		this.rating[0] = 0;
		this.rating[1] = 0;
	}
	
	//server functions
	public void getFromServer(session cur_session) throws Exception{
		Statement stmt;
		ResultSet res = null;
		try {
			stmt = cur_session.getServer().getConn().createStatement();
			res = stmt.executeQuery("SELECT * FROM game WHERE Name = '"+this.name+"'");
		} catch (SQLException ex) {
		    System.out.println("SQLException: " + ex.getMessage());
		}
		if (res.first()){
			if (res.getInt("user_id") != cur_session.getUser().getID() && res.getInt("privacy") != 1){
				throw new Exception("AccessDenied");
			} else {
				this.id = res.getInt("id");
				this.user_id = res.getInt("user_id");
				this.rating[0] = res.getInt("rating_sum");
				this.rating[1] = res.getInt("rating_count");
				this.privacy = res.getInt("privacy");
				this.editable = (res.getInt("user_id") == cur_session.getUser().getID());
				//get rawdata
			}
		} else {
			throw new Exception("NoSuchGameOnServer");
		}
	}
	public void syncBack(SQLConnection server) throws Exception{
		Statement stmt;
		ResultSet res = null;
		try {
			stmt = server.getConn().createStatement();
			res = stmt.executeQuery("SELECT id FROM game WHERE Name = '"+this.name+"'");
		} catch (SQLException ex) {
		    System.out.println("SQLException: " + ex.getMessage());
		}
		if (!res.first()){throw new Exception("NoSuchGameOnServer");} //game deleted on remote during editing
		try {
			stmt = server.getConn().createStatement();
			stmt.executeUpdate("UPDATE game SET name='"+this.name+
					", rating_sum="+this.rating[0]+
					", rating_count="+this.rating[1]+
					", privacy="+this.privacy+
					" WHERE id="+this.id);
		} catch (SQLException ex) {
		    System.out.println("SQLException: " + ex.getMessage());
		}
	}
	public void addGame(session cur_session) throws Exception{
		//check for name duplicate
		Statement stmt;
		ResultSet res = null;
		try {
			stmt = cur_session.getServer().getConn().createStatement();
			res = stmt.executeQuery("SELECT id FROM game WHERE Name = '"+this.name+"'");
		} catch (SQLException ex) {
			System.out.println("Error at checking for duplicate game");
		    System.out.println("SQLException: " + ex.getMessage());
		}
		if (res.first()){
			throw new Exception("DuplicateGame");
		} else {
			try {
				stmt = cur_session.getServer().getConn().createStatement();
				stmt.executeUpdate("INSERT INTO game (user_id, name, rating_sum, rating_count, privacy) VALUES ("+
						this.user_id+", "+
						"'"+this.name+"', "+
						this.rating[0]+", "+
						this.rating[1]+", "+
						this.privacy+
						")");
			} catch (SQLException ex) {
				System.out.println("Error at inserting game in db");
			    System.out.println("SQLException: " + ex.getMessage());
			}
		}
	}
}
