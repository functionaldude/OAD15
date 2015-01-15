package oad;


public class Program {
	
	//vars
	public static session current_session;
	private static GUIController guicontrol;
	
	public static void main(String[] args) {
		//init vars
		SQLConnection sqlserver = new SQLConnection("jdbc:mysql://127.0.0.1:8889/OAD");
		current_session = new session();
		current_session.server = sqlserver;
		current_session.feedbackhandler = new FeedbackHandler();
		current_session.musicplayer = new AudioHandler();
		guicontrol = new GUIController();
		guicontrol.init();
		GUIController.w_login.show();
	}

}
