package oad;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import oadgui.AboutUsWindow;
import oadgui.AdminWindow;
import oadgui.ContactWindow;
import oadgui.FeedbackWindow;
import oadgui.GameSettingWindow;
import oadgui.HomeWindow;
import oadgui.LoginWindow;
import oadgui.PrivateDescriptionGameWindow;
import oadgui.PrivateNewGameWindow;
import oadgui.PublicDescriptionGameWindow;
import oadgui.PublicNewGameWindow;
import oadgui.PublicRankingGameWindow;
import oadgui.RegisterWindow;
import oadgui.ResetPasswordWindow;
import oadgui.SaveEditorWindow;
import oadgui.TutorialWindow;
import oadgui.UserSettingWindow;
import oadgui.UserTableModel;

public class GUIController {
	//windows
	public static LoginWindow w_login;
	public static HomeWindow w_main;
	public static AdminWindow w_admin;
	public static ContactWindow w_contact;
	public static FeedbackWindow w_feedback;
	public static GameSettingWindow w_gamesettings;
	public static RegisterWindow w_register;
	public static ResetPasswordWindow w_resetpw;
	public static TutorialWindow w_tutorial;
	public static UserSettingWindow w_usersettings;
	public static AboutUsWindow w_about;
	public static PrivateNewGameWindow w_private_new_game;
	public static PrivateDescriptionGameWindow w_private_description;
	public static PublicNewGameWindow w_public_new_game;
	public static PublicDescriptionGameWindow w_public_description;
	public static PublicRankingGameWindow w_public_ranking;
	public static SaveEditorWindow w_save_editor;
	
	public GUIController(){
	}
	
	public void init(){
		w_login = new LoginWindow();
		w_admin = new AdminWindow();
		w_main = new HomeWindow();
		w_usersettings = new UserSettingWindow();
		w_gamesettings = new GameSettingWindow();
		w_contact = new ContactWindow();
		w_tutorial = new TutorialWindow();
		w_feedback = new FeedbackWindow();
		w_about = new AboutUsWindow();
		w_register = new RegisterWindow();
		w_resetpw = new ResetPasswordWindow();
		w_private_new_game = new PrivateNewGameWindow();
		w_private_description = new PrivateDescriptionGameWindow();
		w_public_new_game = new PublicNewGameWindow();
		w_public_description = new PublicDescriptionGameWindow();
		w_public_ranking = new PublicRankingGameWindow();
		w_save_editor = new SaveEditorWindow();
		
		
	}
	
	//login window
	public static ActionListener login = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String input_email = w_login.f_email.getText();
			String input_pw = new String(w_login.f_pw.getPassword());
			try {
				Program.current_session.authenticate(input_email, input_pw);
			}
			catch (SQLException e1){
				JOptionPane.showMessageDialog(w_main.window, "Server error: "+ e1.getMessage());
			}
			catch (Exception e1) {
				System.out.println("Login error: " + e1.getMessage());
				if (e1.getMessage().equals("InvalidPW")){
					JOptionPane.showMessageDialog(w_login.window, "The password is wrong!");
				}
				else if (e1.getMessage().equals("NoSuchUser")){
					JOptionPane.showMessageDialog(w_login.window, "No such user in our Database!");					
				}
			}
			if (Program.current_session.getLoginState()){
				w_login.hide();
				// bg color
				Color bg;
				int color = Program.current_session.getUser().settings[0];
				switch (color){
				case 1: bg = Color.red; break;
				case 2: bg = Color.black; break;
				case 3: bg = Color.white; break;
				case 4: bg = Color.blue; break;
				case 5: bg = Color.green; break;
				default: bg = Color.lightGray; break;
				}
				w_gamesettings.background_color_box.setSelectedIndex(color);
				w_main.public_game_playground_panel.setBackground(bg);
				w_main.private_game_playground_panel.setBackground(bg);
			
				//bg music
				int music = Program.current_session.getUser().settings[1]; 
				String music_path = null;
				switch (Program.current_session.getUser().settings[1]){
				case 1: music_path = ResourceHandler.music1; break;
				case 2: music_path = ResourceHandler.music2; break;
				case 3: music_path = ResourceHandler.music3; break;
				default: music_path = null;
				}
				w_gamesettings.background_music_box.setSelectedIndex(music);
				Program.current_session.musicplayer.setAudioData(music_path);
				if(Program.current_session.getUser().userimage != null){
					w_main.photo_label.setText(null);
					w_main.photo_label.setIcon(new ImageIcon(Program.current_session.getUser().userimage));
				} else {
					w_main.photo_label.setIcon(null);
					w_main.photo_label.setText("No image found! Please uplouad an avatar.");
				}
				if (Program.current_session.getUser().getUserName().equals("admin")){
					w_admin.show();
				} else {
					w_main.home_label.setText("Hello "+Program.current_session.getUser().getUserName());
					w_main.show();
				}
			}
		}
	};
	public static ActionListener open_register = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e){
			w_register.f_email.setText(null);
			w_register.f_pw.setText(null);
			w_register.f_pw_repeat.setText(null);
			w_register.f_username.setText(null);
			w_register.show();
		}
	};
	public static ActionListener open_reset_pw = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e){
			w_resetpw.nickname_field.setText(null);
			w_resetpw.email_field.setText(null);
			w_resetpw.show();
		}
	};
	
	public static ActionListener open_private_new_game = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e){
			ArrayList<String> games = null;
			try {
				games = Program.current_session.listGames(1);
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(w_admin.window, "Server error: "+ e1.getMessage());
			}
			Iterator<String> iter = games.iterator();
			while(iter.hasNext()){
				w_private_new_game.list_of_private_games.addItem(iter.next());
			}
			w_private_new_game.show();
		}
	};
	
	public static ActionListener open_private_description_game = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e){
			w_private_description.show();
		}
	};
	
	public static ActionListener open_public_new_game = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e){
			ArrayList<String> games = null;
			try {
				games = Program.current_session.listGames(2);
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(w_admin.window, "Server error: "+ e1.getMessage());
			}
			Iterator<String> iter = games.iterator();
			while(iter.hasNext()){
				w_public_new_game.list_of_public_games.addItem(iter.next());
			}
			w_public_new_game.show();
		}
	};
	public static ActionListener load_public_game = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e){
			GameController.current_game = new game((String)w_public_new_game.list_of_public_games.getSelectedItem());
			try {
				GameController.current_game.getFromServer();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(w_admin.window, "Server error: "+ e1.getMessage());
			} catch (Exception e1) {
				if(e1.getMessage().equals("AccessDenied")){
					JOptionPane.showMessageDialog(w_admin.window, "Error: Access Denied");
				}
				else if(e1.getMessage().equals("NoSuchGameOnServer")){
					JOptionPane.showMessageDialog(w_admin.window, "Error: No such game on the server");
				}
			}
			w_main.public_game_playground_panel.repaint();
			w_public_new_game.hide();
		}
	};
	public static ActionListener load_private_game = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e){
			GameController.current_game = new game((String)w_private_new_game.list_of_private_games.getSelectedItem());
			try {
				GameController.current_game.getFromServer();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(w_admin.window, "Server error: "+ e1.getMessage());
			} catch (Exception e1) {
				if(e1.getMessage().equals("AccessDenied")){
					JOptionPane.showMessageDialog(w_admin.window, "Error: Access Denied");
				}
				else if(e1.getMessage().equals("NoSuchGameOnServer")){
					JOptionPane.showMessageDialog(w_admin.window, "Error: No such game on the server");
				}
			}
			w_main.private_game_playground_panel.repaint();
			w_private_new_game.hide();
		}
	};
	public static ActionListener open_public_ranking_game = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e){
			w_public_ranking.show();
		}
	};
	
	public static ActionListener open_public_description_game = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e){
			w_public_description.show();
		}
	};
	
	public static ActionListener open_save_editor = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e){
			w_save_editor.show();
		}
	};
	
	//register window
	public static ActionListener register = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e){
			try{
				Program.current_session.addUser(w_register.f_username.getText(), new String(w_register.f_pw.getPassword()), w_register.f_email.getText());
			}
			catch (SQLException e1){
				JOptionPane.showMessageDialog(w_main.window, "Server error: "+ e1.getMessage());
			}
			catch (Exception e1){
				if (e1.getMessage().equals("DuplicateUser")){
					JOptionPane.showMessageDialog(w_register.window, "Username already exists!");
					return;
				}
			}
			w_register.hide();
		}
	};
	//home window
	public static ActionListener logout = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			w_main.hide();
			Program.current_session.deauthenticate();
			w_login.f_email.setText(null);
			w_login.f_pw.setText(null);
			w_login.show();
		}	
	};
	public static ActionListener open_usersettings = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			w_usersettings.new_nickname_field.setText(null);
			w_usersettings.new_password_field.setText(null);
			w_usersettings.old_password_field.setText(null);
			if (Program.current_session.getUser().userimage != null){
				w_usersettings.usrimg.setIcon(new ImageIcon(Program.current_session.getUser().userimage.getScaledInstance(50, 50, Image.SCALE_FAST)));
				w_usersettings.usrimg.setText(null);
			} else {
				w_usersettings.usrimg.setText("No image");
				w_usersettings.usrimg.setIcon(null);
			}
			w_usersettings.show();
		}	
	};
	public static ActionListener open_gamesettings = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			w_gamesettings.show();
		}	
	};
	public static ActionListener open_about = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			w_about.show();
		}	
	};
	public static ActionListener open_contact = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			w_contact.show();
		}	
	};
	public static ActionListener open_tutorial = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			w_tutorial.show();
		}	
	};
	public static ActionListener open_feedback = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			w_feedback.feedback_email_field.setText(null);
			w_feedback.feedback_message_field.setText(null);
			w_feedback.feedback_name_field.setText(null);
			w_feedback.feedback_titel_field.setText(null);
			w_feedback.show();
		}	
	};
	//editor
	public static ActionListener open_editor = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			CardLayout cl = (CardLayout)(w_main.master_container_switch.getLayout());
	        cl.show(w_main.master_container_switch,"Karte4" );
	        GameController.current_panel = w_main.editor_editor_panel;
	        GameController.current_game = new game("Untitled");
		}	
	};
	public static ActionListener editor_back = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			CardLayout cl = (CardLayout)(w_main.master_container_switch.getLayout());
	        cl.show(w_main.master_container_switch,"Karte1" );
	        GameController.current_panel = null;
	        GameController.current_game = null;
		}	
	};
	public static ActionListener editor_cancel = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) 
		{
	        GameController.current_game = new game("Untitled");
	        GameController.current_panel.repaint();
		}	
	};
	public static ActionListener editor_save = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			GameController.current_game.setPrivacy(w_save_editor.editor_privacy_list.getSelectedIndex()+1);
			GameController.current_game.setName(w_save_editor.editor_title_field.getText());
			GameController.current_game.setDescription(w_save_editor.editor_description_field.getText());
			try {
				GameController.current_game.addGame();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(w_admin.window, "Server error: "+ e1.getMessage());
				return;
			} catch (Exception e1) {
				if(e1.getMessage().equals("DuplicateGame")){
					JOptionPane.showMessageDialog(w_admin.window, "Error: Title already taken");
					return;
				}
			}
			w_save_editor.hide();
			w_save_editor.editor_description_field.setText(null);
			w_save_editor.editor_title_field.setText(null);
		}	
	};
	//admin window
	public static ActionListener search_users = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e){
			try {
				w_admin.user_table_content = new UserTableModel(Program.current_session.searchUser(w_admin.search_user_field.getText()));
				w_admin.user_table.setModel(w_admin.user_table_content);
			} catch (SQLException e1) {
				System.out.println("SQLException: "+e1.getMessage());
				JOptionPane.showMessageDialog(w_admin.window, "Server error: "+ e1.getMessage());
			}
		}
	};
	public static ActionListener delete_user = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e){
			int selected = w_admin.user_table.getSelectedRow();
			if (selected == -1){
				return;
			}
			String username = (String)w_admin.user_table_content.getValueAt(selected, 1);
			try {
				Program.current_session.deleteUser(username);
			} catch (SQLException e1) {
				System.out.println("SQLException: "+e1.getMessage());
				JOptionPane.showMessageDialog(w_admin.window, "Server error: "+ e1.getMessage());
			}
			search_users.actionPerformed(null);
		}
	};
	//feedback window
	public static ActionListener feedback_cancel = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e){
			w_feedback.hide();
		}
	};
	public static ActionListener send_feedback = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e){
			try {
				Program.current_session.feedbackhandler.addFeedback(w_feedback.feedback_titel_field.getText(), w_feedback.feedback_message_field.getText());
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(w_admin.window, "Server error: "+ e1.getMessage());
			}
			w_feedback.hide();
		}
	};
	
	//user setting window
	public static ActionListener change_usr_settings = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e){
			String old_pw = new String(w_usersettings.old_password_field.getPassword());
			if (Program.current_session.getUser().checkPW(old_pw)){
				if(!w_usersettings.new_nickname_field.getText().isEmpty()){
					String new_username = w_usersettings.new_nickname_field.getText();
					if(Program.current_session.checkForUser(new_username)){
						JOptionPane.showMessageDialog(w_usersettings.window, "Username already taken!");
					} else {
						Program.current_session.getUser().changeUserName(new_username);
					}
				}
				if (! new String(w_usersettings.new_password_field.getPassword()).isEmpty()){
					Program.current_session.getUser().changePW(new String(w_usersettings.new_password_field.getPassword()));
				}
				w_main.photo_label.setIcon(new ImageIcon(Program.current_session.getUser().userimage));
				w_main.photo_label.setText(null);
				try {
					Program.current_session.syncBackUserData();
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(w_usersettings.window, "Server error: "+ ex.getMessage());
				}
				w_usersettings.hide();
			} else {
				if(new String(w_usersettings.old_password_field.getPassword()).isEmpty()){
					JOptionPane.showMessageDialog(w_usersettings.window, "You have to submit your password in order to make changes!");
				} else {
					JOptionPane.showMessageDialog(w_usersettings.window, "The password is wrong!");
				}
			}
		}
	};
	public static ActionListener set_image = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			int retval = w_usersettings.image_chooser.showOpenDialog(w_usersettings.window);
			if(retval == JFileChooser.APPROVE_OPTION){
				try {
					Program.current_session.set_user_image(w_usersettings.image_chooser.getSelectedFile());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(w_usersettings.window, ex.getClass()+" error: "+ ex.getMessage());
				}
			}
			w_usersettings.usrimg.setIcon(new ImageIcon(Program.current_session.getUser().userimage.getScaledInstance(50, 50, Image.SCALE_FAST)));
		}	
	};
	//game settings
	public static ActionListener save_game_settings = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e){
			// bg color
			int newcolor = w_gamesettings.background_color_box.getSelectedIndex();
			if (newcolor != Program.current_session.getUser().settings[0]){
				Color bg;
				switch (newcolor){
				case 1: bg = Color.red; break;
				case 2: bg = Color.black; break;
				case 3: bg = Color.white; break;
				case 4: bg = Color.blue; break;
				case 5: bg = Color.green; break;
				default: bg = Color.lightGray; break;
				}
				Program.current_session.getUser().settings[0] = newcolor;
				w_main.public_game_playground_panel.setBackground(bg);
				w_main.private_game_playground_panel.setBackground(bg);
			}
			//bg music
			int newmusic = w_gamesettings.background_music_box.getSelectedIndex();
			if(newmusic != Program.current_session.getUser().settings[1]){
				String music_path = null;
				switch (newmusic){
				case 1: music_path = ResourceHandler.music1; break;
				case 2: music_path = ResourceHandler.music2; break;
				case 3: music_path = ResourceHandler.music3; break;
				default: music_path = null;
				}
				Program.current_session.getUser().settings[1] = newmusic;
				Program.current_session.musicplayer.setAudioData(music_path);
			}
			w_gamesettings.hide();
			try {
				Program.current_session.syncBackUserData();
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(w_gamesettings.window, "Server error: "+ ex.getMessage());
			}
		}
	};
	
	//resetPW window
	public static ActionListener resetPWregister = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e){
			String usr = w_resetpw.nickname_field.getText();
			String email = w_resetpw.email_field.getText();
			try {
				Program.current_session.registerPWreset(usr, email);
			} 
			catch (SQLException ex) {
	        	System.out.println("SQLException: " + ex.getMessage());
				JOptionPane.showMessageDialog(w_resetpw.window, "Server error: "+ ex.getMessage());
			}
			catch (Exception ex) {
				System.out.println("Exception: " + ex.getMessage());
				if (ex.getMessage().equals("NoSuchUser")){
					JOptionPane.showMessageDialog(w_resetpw.window, "No such user in our Database!");					
				}
				else if (ex.getMessage().equals("InvalidEmail")){
					JOptionPane.showMessageDialog(w_resetpw.window, "Data mismatch!");					
				}
			}
			w_resetpw.hide();
		}
	};
	public static ActionListener resetPW = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e){
			int selected = w_admin.user_table.getSelectedRow();
			if (selected == -1){
				return;
			}
			String username = (String)w_admin.user_table_content.getValueAt(selected, 1);
			try {
				Program.current_session.resetPW(username);
			} catch (SQLException e1) {
				System.out.println("SQLException: "+e1.getMessage());
				JOptionPane.showMessageDialog(w_main.window, "Server error: "+ e1.getMessage());
			} catch (Exception ex) {
				System.out.println("Exception: " + ex.getMessage());
				if (ex.getMessage().equals("NoSuchUser")){
					JOptionPane.showMessageDialog(w_admin.window, "No such user in our Database!");					
				}
			}
			search_users.actionPerformed(null);
		}
	};
}