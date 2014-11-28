package oad;

import java.lang.Exception;
import java.util.Iterator;
import java.util.Set;

import oad.game;

public class User {
	
	//initial data
	private String username;
	private String password;
	public int type;

	//games
	Set<game> user_games;
	
	//constructor
	public User(String input_name, String input_pw){
		this.username = input_name;
		this.password = input_pw;
	}

	//user methods
	public String getUserName(){
		return this.username;
	}
	public Boolean checkPW(String input_PW){
		if (this.password.equals(input_PW)){
			System.out.println("Pw OK!");
			return true;
		} else {
			return false;
		}
	}
	public void changePW(String input_pw, String new_pw) throws Exception{
		if (input_pw != this.password){
			throw new Exception("InvalidPW");
		} else {
			this.password = new_pw;
		}
	}
	//game methods
	public void addGame(game input_game){
		this.user_games.add(input_game);
	}
	public void deleteGame(game input_game) throws Exception{
		Iterator<game> iterator = this.user_games.iterator();
		while (iterator.hasNext()){
			if (iterator.equals(input_game)){
				iterator.remove();
				return;
			} else {
				iterator.next();
			}
		}
		throw new Exception("NoSuchElement");
	}
}
