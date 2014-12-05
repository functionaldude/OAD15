package oad;

import java.lang.Exception;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Set;

import oad.game;

public class User {
	
	//initial data
	private String username;
	private String email;
	private String password;
	private int type;
	private int ID;

	//constructor
	public User(String input_name, String input_pw, String input_email){
		this.username = input_name;
		this.password = input_pw;
		this.email = input_email;
	}
	public User(String input_name, String input_pw, String input_email, int input_ID){
		this.username = input_name;
		this.password = input_pw;
		this.email = input_email;
		this.ID = input_ID;
	} 

	//user methods
	public String getUserName(){
		return this.username;
	}
	public String getEmail(){
		return this.email;
	}
	public int getType(){
		return this.type;
	}
	public String getPW(){
		return this.password;
	}
	public int getID(){
		return this.ID;
	}
	public void changePW(String input_pw, String new_pw) throws Exception{
		if (input_pw != this.password){
			throw new Exception("InvalidPW");
		} else {
			this.password = new_pw;
		}
	}
	public void changeEmail(String input){
		this.email = input;
	}
}
