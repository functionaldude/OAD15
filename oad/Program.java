package oad;

import oadgui.LoginWindow;
import oadgui.RegisterWindow;
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
			current_session.addUser(new User("test", "test"));
		} catch (Exception e) {}
		
		//login
		w_login = new LoginWindow(current_session);
		w_login.show();
		synchronized(w_login.thisObject){
			try {
				w_login.thisObject.wait();
			} catch (InterruptedException e) {
				System.out.println("Wake!");
			}
		}
		
		//main
		//w_main = new AppWindow(current_session);
		
	}

}
