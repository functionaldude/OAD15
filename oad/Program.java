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
		
		
		//login
		w_login = new LoginWindow(current_session);
		w_login.show();
		
		//TODO: Busy wait
		synchronized(w_login.visiblity){
			try {
				w_login.visiblity.wait();
			} catch (InterruptedException e) {}
		}

		w_main = new HomeWindow(current_session);
		w_main.show();
		
		//main
		//w_main = new AppWindow(current_session);
		
	}

}
