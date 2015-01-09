package oad;

import java.awt.Image;
import java.lang.Exception;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.table.AbstractTableModel;

import oad.game;

public class User {
	
	//initial data
	private String username;
	private String email;
	private String password;
	private int type;
	private int ID;
	public int[] settings;
	public Image userimage;

	//constructor
	public User(String input_name, String input_pw, String input_email){
		this.username = input_name;
		this.password = input_pw;
		this.email = input_email;
		this.settings = new int[2];
	}
	public User(String input_name, String input_pw, String input_email, int input_ID){
		this.username = input_name;
		this.password = input_pw;
		this.email = input_email;
		this.ID = input_ID;
		this.settings = new int[2];
	} 
	public User(String input_name, String input_pw, String input_email, int input_ID, int bg, int music, Image inputimage){
		this.username = input_name;
		this.password = input_pw;
		this.email = input_email;
		this.ID = input_ID;
		this.settings = new int[2];
		this.settings[0] = bg;
		this.settings[1] = music;
		this.userimage = inputimage;
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
	public void changePW(String input){
		this.password = input;
	}
	public void changeUserName(String input){
		this.username = input;
	}
	public void changeEmail(String input){
		this.email = input;
	}
	public Boolean checkPW(String input){
		return this.password.equals(input);
	}
}