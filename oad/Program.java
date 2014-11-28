package oad;

import oadgui.HomeWindow;
import oadgui.LoginWindow;


public class Program {
	
	//vars
	private static session current_session;
	
	//gui vars
	private static LoginWindow w_login;
	private static HomeWindow w_main;
	
	public static void main(String[] args) {
		//init vars
		current_session = new session();
		
		//testuser
		try {
			current_session.addUser(new User("test", "test", "test"));
		} catch (Exception e) {}
		
		//login
		w_login = new LoginWindow(current_session);
		w_login.show();
		
		//TODO: Busy wait
		while(w_login.window.isVisible()){
			System.out.println("Login");
		}
		
		w_main = new HomeWindow(current_session);
		w_main.show();
		System.out.println("test");
	
		
		//main
		//w_main = new AppWindow(current_session);
		
	}

}
