package oadgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import oad.User;
import oad.session;

import javax.swing.SwingConstants;

public class HomeWindow extends Window{
	//elements
	
	//panel
	private JPanel home_panel;
	
	//labels
	private JLabel l_welcome;

	
	//buttons
	
	
	//textfields
	
	
	//menu
	private JMenu menu;
	
	//vars
	session current_session;
	
	HomeWindow(session input_session){
		//setup vars
		this.current_session = input_session;
		
		//setup frame
		init();
		this.setName("Home Screen");
		this.setSize(800, 600);
		this.initSize();
		
		//init elements
		
		this.menu = new JMenu();
		
		
		
		//add elements
		

		
		this.initListeners();
	}
	
	/*private void initListeners(){
		this.register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				created_user = new User(f_email.toString(), f_pw.toString());
				try{
					current_session.addUser(created_user);
				}
				catch (Exception e1){
					if (e1.getMessage() == "DuplicateUser"){
						//TODO: Pop-up
						return;
					}
				}
				hide();
			}
		});
	}*/
}
