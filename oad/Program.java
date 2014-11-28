package oad;

import oadgui.LoginWindow;
import oadgui.RegisterWindow;


public class Program {
	
	//vars
	private static session current_session;
	
	//gui vars
	private static LoginWindow w_login;
	private static RegisterWindow w_register;
	
	public static void main(String[] args) {
		//init vars
		current_session = new session();
		
		//testuser
		try {
			current_session.addUser(new User("test", "test"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		
		//login
		w_login = new LoginWindow(current_session);
		w_login.show();
		
		
		
	}

}
