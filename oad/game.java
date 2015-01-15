package oad;
import java.lang.Exception;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class game {
	//initial data
	private int id;
	private int user_id;
	private String name;
	private int rating[];
	private int privacy;
	private String desc;
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
	public void getFromServer() throws Exception{
		Statement stmt;
		ResultSet res = null;
		stmt = Program.current_session.server.getConn().createStatement();
		res = stmt.executeQuery("SELECT * FROM game WHERE Name = '"+this.name+"'");
		if (res.first()){
			if (res.getInt("user_id") != Program.current_session.getUser().getID() && res.getInt("privacy") != 1){
				stmt.close();
				throw new Exception("AccessDenied");
			} else {
				this.id = res.getInt("id");
				this.user_id = res.getInt("user_id");
				this.rating[0] = res.getInt("rating_sum");
				this.rating[1] = res.getInt("rating_count");
				this.privacy = res.getInt("privacy");
				this.desc = res.getString("desc");
				stmt = Program.current_session.server.getConn().createStatement();
				res = stmt.executeQuery("SELECT x, y FROM coordinates WHERE game_id="+this.id);
				while (res.next()) {
					circles.add(new Coordinate(res.getInt("x"), res.getInt("y")));
				}
				stmt.close();
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
				", desc='"+this.desc+"'"+
				" WHERE id="+this.id);
		stmt.close();
	}
	public void addGame() throws Exception{
		//check for name duplicate
		this.user_id = Program.current_session.getUser().getID();
		Statement stmt;
		ResultSet res = null;
		stmt = Program.current_session.server.getConn().createStatement();
		res = stmt.executeQuery("SELECT id FROM game WHERE Name = '"+this.name+"'");
		if (res.first()){
			stmt.close();
			throw new Exception("DuplicateGame");
		} else {
			stmt = Program.current_session.server.getConn().createStatement();
			stmt.executeUpdate("INSERT INTO game (user_id, name, rating_sum, rating_count, privacy, `desc`) VALUES ("+
					this.user_id+", "+
					"'"+this.name+"', "+
					this.rating[0]+", "+
					this.rating[1]+", "+
					this.privacy+", "+
					"'"+this.desc+"'"+
					")");
			stmt.close();
			//get the game id -> auto inc from sql server
			stmt = Program.current_session.server.getConn().createStatement();
			res = stmt.executeQuery("SELECT * FROM game WHERE name = '"+this.name+"'");
			res.first();
			id = res.getInt("id");
			stmt.close();
			stmt = Program.current_session.server.getConn().createStatement();
			Iterator<Coordinate> iter = circles.iterator();
			Coordinate circle;
			while(iter.hasNext()){
				circle = iter.next();
				stmt.addBatch("INSERT INTO coordinates (game_id, x, y) VALUES ("+id+", "+circle.getX()+", "+circle.getY()+")");
			}
			stmt.executeBatch();
			stmt.close();
		}
	}
	public void addCircle(int x, int y){
		this.circles.add(new Coordinate(x,y));
	}
	public void setName(String input){
		name = input;
	}
	public void setDescription(String input){
		desc = input;
	}
	public void setPrivacy(int input){
		privacy = input;
	}
}
