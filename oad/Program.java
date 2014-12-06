package oad;

import oadgui.AdminWindow;
import oadgui.HomeWindow;
import oadgui.LoginWindow;


public class Program {
	
	//vars
	private static session current_session;
	
	//gui vars
	private static LoginWindow w_login;
	private static HomeWindow w_main;
	private static AdminWindow w_admin;
	
	public static void main(String[] args) {
		//init vars
		current_session = new session();
		
		
		//login
		w_login = new LoginWindow(current_session);
		w_login.show();
		
		synchronized(w_login.visiblity){
			try {
				w_login.visiblity.wait();
			} catch (InterruptedException e) {}
		}
		if (current_session.getUser().getUserName().equals("admin")){
			w_admin = new AdminWindow(current_session);
			w_admin.show();
		} else {
			w_main = new HomeWindow(current_session);
			w_main.show();
		}
	}

}
