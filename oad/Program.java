package oad;

import oadgui.LoginWindow;
import oadgui.AppWindow;


public class Program {
	
	//vars
	private static session current_session;
	
	//gui vars
	private static LoginWindow w_login;
	private static AppWindow w_main;
	
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
	
		
		//main
		//w_main = new AppWindow(current_session);
		
	}

}
