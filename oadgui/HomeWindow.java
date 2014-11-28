package oadgui;

import java.awt.BorderLayout;
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
	
	public HomeWindow(session input_session){
		//setup vars
		this.current_session = input_session;
		
		//setup frame
		init();
		this.setName("Home Screen");
		this.setSize(800, 600);
		this.initSize();
		
		//init elements
		
		this.home_panel = new JPanel();
		
		this.menu = new JMenu();
		
		
		
		this.home_panel.setLayout(new BorderLayout());
		
		//add elements
		
		this.home_panel.add(this.menu, BorderLayout.PAGE_START);
		
		
		this.window.getContentPane().add(this.home_panel);

		

		
		this.initListeners();
	}
	
	private void initListeners(){
		
	}
}
