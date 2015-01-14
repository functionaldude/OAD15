package oad;
import java.lang.Exception;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class game {
	//initial data
	private int id;
	private int user_id;
	private String name;
	private int rating[];
	private int privacy;
	private Boolean editable;
	public ArrayList<Coordinate> circles;
	public ArrayList<Coordinate> lines;
	
	//constructors
	public game(String input_name){
		this.name = input_name;
		this.rating = new int[] {0,0};
		this.circles = new ArrayList<Coordinate>();
		this.lines = new ArrayList<Coordinate>();
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
			stmt = cur_session.server.getConn().createStatement();
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
				//TODO: get rawdata!!!
			}
		} else {
			throw new Exception("NoSuchGameOnServer");
		}
	}
	public void syncBack(SQLConnection server) throws Exception{
		Statement stmt;
		ResultSet res = null;
		stmt = server.getConn().createStatement();
		res = stmt.executeQuery("SELECT id FROM game WHERE Name = '"+this.name+"'");
		if (!res.first()){ //game deleted on remote during editing
			stmt.close();
			throw new Exception("NoSuchGameOnServer");
		} 
		stmt.close();
		stmt = server.getConn().createStatement();
		stmt.executeUpdate("UPDATE game SET name='"+this.name+
				", rating_sum="+this.rating[0]+
				", rating_count="+this.rating[1]+
				", privacy="+this.privacy+
				" WHERE id="+this.id);
		stmt.close();
	}
	public void addGame(session cur_session) throws Exception{
		//check for name duplicate
		Statement stmt;
		ResultSet res = null;
		stmt = cur_session.server.getConn().createStatement();
		res = stmt.executeQuery("SELECT id FROM game WHERE Name = '"+this.name+"'");
		if (res.first()){
			stmt.close();
			throw new Exception("DuplicateGame");
		} else {
			stmt = cur_session.server.getConn().createStatement();
			stmt.executeUpdate("INSERT INTO game (user_id, name, rating_sum, rating_count, privacy) VALUES ("+
					this.user_id+", "+
					"'"+this.name+"', "+
					this.rating[0]+", "+
					this.rating[1]+", "+
					this.privacy+
					")");
			stmt.close();
		}
	}
	public void addCircle(int x, int y){
		this.circles.add(new Coordinate(x,y));
	}
}
