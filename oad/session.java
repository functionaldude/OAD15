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
	private Set<User> user_db;
	
	//constructor
	public session(){
		this.logged_in = false;
		this.user_db = new HashSet<User>();
	}
	public void addUser(User input_user) throws Exception{
		if (this.checkForUser(input_user) == false){
			this.user_db.add(input_user);
		} else {
			throw new Exception("DuplicateUser");
		}
	}
	public Boolean getLoginState(){
		return this.logged_in;
	}
	public Boolean checkForUser(User input_user){
		Iterator<User> iterator = user_db.iterator();
		User iter_usr;
		while(iterator.hasNext()){
			iter_usr = iterator.next();
			if (iter_usr.getUserName() == input_user.getUserName()){
				return true;
			}
		}
		return false;
	}
	public void authenticate(String input_username, String input_pw) throws Exception{
		if (logged_in){
			throw new Exception("UserAlreadyIn");
		}
		Iterator<User> iterator = user_db.iterator();
		while (iterator.hasNext()){
			User current = iterator.next();
			if (current.getUserName().equals(input_username)){
				System.out.println("User found!");
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
