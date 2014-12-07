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
		SQLConnection sqlserver = new SQLConnection("jdbc:mysql://127.0.0.1:3306/OAD");
		AudioHandler musicplayer = new AudioHandler();
		current_session = new session();
		FeedbackHandler feedbackhandler = new FeedbackHandler(current_session);
		current_session.server = sqlserver;
		current_session.feedbackhandler = feedbackhandler;
		current_session.musicplayer = musicplayer;
		
		
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
