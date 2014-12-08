package oad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import oadgui.AboutUsWindow;
import oadgui.AdminWindow;
import oadgui.ContactWindow;
import oadgui.FeedbackWindow;
import oadgui.GameSettingWindow;
import oadgui.HomeWindow;
import oadgui.LoginWindow;
import oadgui.RegisterWindow;
import oadgui.ResetPasswordWindow;
import oadgui.TutorialWindow;
import oadgui.UserSettingWindow;
import oadgui.UserTableModel;
import oadgui.Window;

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
	
	//vars
	public static session sessionvar;
	
	public GUIController(session input){
		sessionvar = input;
	}
	
	public void init(){
		w_login = new LoginWindow(sessionvar);
		w_admin = new AdminWindow(sessionvar);
		w_main = new HomeWindow(sessionvar);
		w_usersettings = new UserSettingWindow(sessionvar);
		w_gamesettings = new GameSettingWindow(sessionvar);
		w_contact = new ContactWindow(sessionvar);
		w_tutorial = new TutorialWindow(sessionvar);
		w_feedback = new FeedbackWindow(sessionvar);
		w_about = new AboutUsWindow(sessionvar);
		w_register = new RegisterWindow(sessionvar);
		w_resetpw = new ResetPasswordWindow(sessionvar);
		
	}
	
	//actionlisteners
	//login window
	public static ActionListener login = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String input_email = w_login.f_email.getText();
			String input_pw = new String(w_login.f_pw.getPassword());
			try {
				sessionvar.authenticate(input_email, input_pw);
			} catch (Exception e1) {
				System.out.println("Login error: " + e1.getMessage());
				if (e1.getMessage().equals("InvalidPW")){
					JOptionPane.showMessageDialog(w_login.window, "The Password is wrong!");
				}
				else if (e1.getMessage().equals("NoSuchUser")){
					JOptionPane.showMessageDialog(w_login.window, "No User in our Database!");					
				}
			}
			if (sessionvar.getLoginState()){
				w_login.hide();
				if (sessionvar.getUser().getUserName().equals("admin")){
					w_admin.show();
				} else {
					w_main.home_label.setText("Hello "+sessionvar.getUser().getUserName());
					w_main.show();
				}
			}
		}
	};
	public static ActionListener open_register = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e){
			w_register.show();
		}
	};
	public static ActionListener open_reset_pw = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e){
			w_resetpw.show();
		}
	};
	//register window
	public static ActionListener register = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e){
			try{
				sessionvar.addUser(w_register.f_username.getText(), new String(w_register.f_pw.getPassword()), w_register.f_email.getText());
			}
			catch (Exception e1){
				if (e1.getMessage() == "DuplicateUser"){
					JOptionPane.showMessageDialog(w_register.window, "Username already exists!");
					return;
				}
			}
			w_register.hide();
		}
	};
	//home window
	public static ActionListener open_usersettings = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e) 
		{
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
			w_feedback.show();
		}	
	};
	//admin window
	public static ActionListener search_users = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e){
			try {
				w_admin.user_table.setModel(new UserTableModel(sessionvar.searchUser(w_admin.search_user_field.getText())));
			} catch (SQLException e1) {
				System.out.println("SQLException: "+e1.getMessage());
			}
		}
	};
}
