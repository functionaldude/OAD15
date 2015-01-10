package oad;


public class Program {
	
	//vars
	private static session current_session;
	private static GUIController guicontrol;
	
	public static void main(String[] args) {
		//init vars
		SQLConnection sqlserver = new SQLConnection("jdbc:mysql://127.0.0.1:8889/OAD");
		AudioHandler musicplayer = new AudioHandler();
		current_session = new session();
		FeedbackHandler feedbackhandler = new FeedbackHandler(current_session);
		current_session.server = sqlserver;
		current_session.feedbackhandler = feedbackhandler;
		current_session.musicplayer = musicplayer;
		guicontrol = new GUIController(current_session);
		guicontrol.init();
		GUIController.w_login.show();
	}

}
