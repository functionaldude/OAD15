package oad;
import oad.User;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.Exception;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;




public class session {
	public int sessionID;
	private boolean logged_in;
	private User current_user;
	public SQLConnection server;
	public FeedbackHandler feedbackhandler;
	public AudioHandler musicplayer;
	
	//constructor
	public session(){
		this.logged_in = false;
	}
	public void addUser(String input_username, String input_pw, String input_email) throws Exception{
		if (this.checkForUser(input_username) == false){
			PreparedStatement stmt;
			stmt = server.getConn().prepareStatement("INSERT INTO user (username, password, email) VALUES (?,?,?");
			stmt.setString(1, input_username);
			stmt.setString(2, input_pw);
			stmt.setString(3, input_email);
			stmt.executeUpdate();
			stmt.close();
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
			stmt.close();
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
		stmt = server.getConn().createStatement();
		res = stmt.executeQuery("SELECT id, password, email, bg, music, img FROM user WHERE username = '" + input_username + "'");
		if (!res.first()){
			stmt.close();
			throw new Exception("NoSuchUser");
		} else {
			System.out.println("User found!");
			if (input_pw.equals(res.getString("password"))){
				Image userimage = null;
				try {
					userimage = ImageIO.read(res.getBinaryStream("img"));
				} catch (Exception e) {
					System.out.println("No user image at login!");
				}
				this.current_user = new User(input_username, input_pw, res.getString("email"), res.getInt("id"), res.getInt("bg"), res.getInt("music"), userimage);
				logged_in = true;
				System.out.println("Auth success!");
				stmt.close();
			} else {
				stmt.close();
				throw new Exception("InvalidPW");
			}
		}
	}
	public void syncBackUserData() throws SQLException{
		PreparedStatement stmt;
		String query = "UPDATE user SET password = ?, email = ?, username = ?, bg= ?, music= ? WHERE id= ?";
		stmt = server.getConn().prepareStatement(query);
		stmt.setString(1, current_user.getPW());
		stmt.setString(2, current_user.getEmail());
		stmt.setString(3, current_user.getUserName());
		stmt.setInt(4, current_user.settings[0]);
		stmt.setInt(5, current_user.settings[1]);
		stmt.setInt(6, current_user.getID());
		stmt.executeUpdate();
		stmt.close();
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
			Statement stmt = server.getConn().createStatement();
			stmt.executeUpdate("UPDATE user SET password='default' WHERE username='"+username+"'");
			stmt.close();
		} else {
			throw new Exception("NoSuchUser");
		}
	}
	public void registerPWreset(String input_username, String input_email) throws Exception{
		if (checkForUser(input_username)){
			Statement stmt = server.getConn().createStatement();
			ResultSet res = stmt.executeQuery("SELECT id FROM user WHERE username = '"+input_username+"' AND email = '"+input_email+"'");
			if (res.first()){
				stmt.executeUpdate("INSERT INTO pwresets (user_id) VALUES (" + res.getInt(1) + ")");
				stmt.close();
			} else {
				stmt.close();
				throw new Exception("InvalidEmail");
			}
		} else {
			throw new Exception("NoSuchUser");
		}
	}
	public void set_user_image(File file) throws Exception{
		//get the file
		BufferedImage rawimage = ImageIO.read(file);
		System.out.println(rawimage.getHeight());
		double scalingfactor = 1.0;
		if(rawimage.getHeight() > 500 || rawimage.getWidth() > 500){
			if(rawimage.getHeight() < rawimage.getWidth()){
				scalingfactor = (double)500 / rawimage.getWidth();
			} else {
				scalingfactor = (double)500 / rawimage.getHeight();
			}
		}
		int scaled_width = (int)(rawimage.getWidth() * scalingfactor);
		int scaled_heigh = (int)(rawimage.getHeight() * scalingfactor);
		System.out.println(scaled_width);
		BufferedImage scaledimage = new BufferedImage(scaled_width, scaled_heigh, rawimage.getType());
		Graphics2D g2d = scaledimage.createGraphics();
        g2d.drawImage(rawimage, 0, 0, scaled_width, scaled_heigh, null);
        g2d.dispose();
        
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		ImageIO.write(scaledimage, "jpg", stream);
		
		//send it to the server
		PreparedStatement stmt = server.getConn().prepareStatement("UPDATE user SET img = ? WHERE id = ?");
		stmt.setBytes(1, stream.toByteArray());
		stmt.setInt(2, current_user.getID());
		stmt.executeUpdate();
		
		//save it locally
		current_user.userimage = scaledimage;
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
		stmt.close();
		return ret_val;
	}
	public void deleteUser(String username) throws SQLException{
		Statement stmt = server.getConn().createStatement();
		stmt.executeUpdate("DELETE FROM user WHERE username = '" + username +"'");
		stmt.close();
	}
	public void sendMSG(int userid, String msg) throws SQLException {
		Statement stmt = server.getConn().createStatement();
		stmt.executeUpdate("INSERT INTO messages (`from`, `to`, msg) VALUES (1, "+ userid +", '"+ msg +"')");
		stmt.close();
	}
	public void sendMSGalluser(String msg) throws SQLException{
		Statement stmt = server.getConn().createStatement();
		ResultSet res = stmt.executeQuery("SELECT id FROM user WHERE username != 'admin'");
		Statement stmt2 = server.getConn().createStatement();
		while(res.next()){
			stmt2.addBatch("INSERT INTO messages (`from`, msg, `to`) VALUES (1, '"+ msg +"', "+ res.getInt("id") +")"); 
		}
		stmt2.executeBatch();
		stmt.close();
		stmt2.close();
	}
}
