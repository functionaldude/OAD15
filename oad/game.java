package oad;
import java.awt.Point;
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
	private String username;
	private int rating[];
	private int privacy;
	private String desc;
	public ArrayList<Point> circles;
	public ArrayList<Connection> lines;
	
	//constructors
	public game(String input_name){
		this.name = input_name;
		this.rating = new int[] {0,0};
		this.circles = new ArrayList<Point>();
		this.lines = new ArrayList<Connection>();
	}
	public game(int id, String name, String username, int rating1, int rating2, int privacy){
		this.id = id;
		this.name = name;
		this.username = username;
		this.rating = new int[] {0,0};
		this.rating[0] = rating1;
		this.rating[1] = rating2;
		this.privacy = privacy;
	}
	
	public String getName(){
		return name;
	}
	public int getID(){
		return id;
	}
	public String getPrivacy(){
		if(privacy == 1){
			return "Private";
		} else {
			return "Public";
		}
	}
	public String getUserName(){
		return username;
	}
	public float getRating() throws Exception{
		if (this.rating[1] >= 5){
			return this.rating[0] / this.rating[1];
		} else {
			throw new Exception("NotEnoughRating");
		}
	}
	public void addRating(int input_rating){
		this.rating[0] += input_rating;
		this.rating[1]++;
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
					circles.add(new Point(res.getInt("x"), res.getInt("y")));
				}
				stmt.close();
				stmt = Program.current_session.server.getConn().createStatement();
				res = stmt.executeQuery("SELECT beginX, beginY, endX, endY FROM (SELECT connections.id, x AS beginX ,y AS beginY FROM connections CROSS JOIN coordinates ON connections.begin = coordinates.id WHERE connections.game_id = "+this.id+") c1 INNER JOIN (SELECT connections.id, x AS endX ,y AS endY FROM connections CROSS JOIN coordinates ON connections.end = coordinates.id WHERE connections.game_id = "+this.id+") c2 ON c1.id = c2.id");
				while (res.next()){
					lines.add(new Connection(new Point(res.getInt("beginX"), res.getInt("beginY")), new Point(res.getInt("endX"), res.getInt("endY"))));
				}
				stmt.close();
			}
		} else {
			throw new Exception("NoSuchGameOnServer");
		}
	}
	public void syncBack() throws Exception{
		Statement stmt;
		ResultSet res = null;
		stmt = Program.current_session.server.getConn().createStatement();
		res = stmt.executeQuery("SELECT id FROM game WHERE Name = '"+this.name+"'");
		if (!res.first()){ //game deleted on remote during editing
			stmt.close();
			throw new Exception("NoSuchGameOnServer");
		} 
		stmt.close();
		stmt = Program.current_session.server.getConn().createStatement();
		stmt.executeUpdate("UPDATE game SET name='"+this.name+"', rating_sum="+this.rating[0]+", rating_count="+this.rating[1]+", privacy="+this.privacy+", `desc`='"+this.desc+"' WHERE id="+this.id);
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
			Iterator<Point> circle_iter = circles.iterator();
			Point circle;
			while(circle_iter.hasNext()){
				circle = circle_iter.next();
				stmt.addBatch("INSERT INTO coordinates (game_id, x, y) VALUES ("+id+", "+circle.getX()+", "+circle.getY()+")");
			}
			stmt.executeBatch();
			stmt.close();
			stmt = Program.current_session.server.getConn().createStatement();
			Iterator<Connection>conn_iter = lines.iterator();
	        Connection line = null;
	        while(conn_iter.hasNext()){
	        	line = conn_iter.next();
	        	stmt.addBatch("INSERT INTO connections(game_id, begin, end) VALUES ("+id+", (SELECT id FROM coordinates WHERE x = "+line.getBegin().x+" AND y = "+line.getBegin().y+"), (SELECT id FROM coordinates WHERE x = "+line.getEnd().x+" AND y = "+line.getEnd().y+"))");
	        }
	        stmt.executeBatch();
			stmt.close();
		}
	}
	public void addCircle(int x, int y){
		this.circles.add(new Point(x,y));
	}
	public void addLine(Connection input){
		this.lines.add(input);
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
