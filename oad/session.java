package oad;
import oad.User;

import java.lang.Exception;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class session {
	public int sessionID;
	public User current_user;
	private boolean logged_in;
	Set<User> user_db;
	
	//constructor
	public session(){
		this.logged_in = false;
		this.user_db = new HashSet<User>();
	}
	public void addUser(User input_user){
		this.user_db.add(input_user);
	}
	public Boolean getLoginState(){
		return this.logged_in;
	}
	public void authenticate(String input_username, String input_pw) throws Exception{
		if (logged_in){
			throw new Exception("UserAlreadyIn");
		}
		Iterator<User> iterator = user_db.iterator();
		while (iterator.hasNext()){
			User current = iterator.next();
			if (current.getUserName().equals(input_username)){
				if (current.checkPW(input_pw)){
					this.current_user = current;
					this.logged_in = true;
					return;
				} else {
					throw new Exception("InvalidPW");
				}
			}
		}
		throw new Exception("NoSuchUser");
	}
	public void deauthenticate(){
		this.current_user = null;
		this.logged_in = false;
	}
	
}
