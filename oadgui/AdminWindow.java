package oadgui;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import oad.session;

import java.awt.CardLayout;
import java.awt.BorderLayout;

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;


public class AdminWindow extends Window{
	//elements
	
	//labels
	private JLabel search_label; 
	
	//panels
	private JPanel master_container;
	private JPanel user_panel;
	private JPanel user_buttons_panel;
	private JPanel user_search_panel;
	private JPanel game_panel;
	private JPanel notification_panel;
	
	
	//buttons
	private JButton delete_user;
	private JButton reset_user_passwort;
	private JButton send_user_message;
	private JButton search_user;
	
	
	//table
	private JTable user_table;
	
	
	//textfields
	
	private JTabbedPane admin_pane;
	private JTextField search_user_field;
	
	
	//string
	
	
	
	//vars
	session current_session;
	private JTable table;
	
	public AdminWindow(session input_session){
		//setup bars
		this.current_session = input_session;
		//setup frame
		init();
		this.setName("Admin-Window");
		this.setSize(800, 600);
		this.initSize();
		
		//setup elements
		
		this.master_container = new JPanel(new CardLayout());
		
		this.user_panel = new JPanel();
		user_panel.setLayout(new BorderLayout(5, 5));
		
		this.user_buttons_panel = new JPanel();
		user_buttons_panel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		user_buttons_panel.setLayout(new BoxLayout(user_buttons_panel, BoxLayout.PAGE_AXIS));
		
		this.user_search_panel = new JPanel();
		user_search_panel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		user_search_panel.setLayout(new BoxLayout(user_search_panel, BoxLayout.LINE_AXIS));
		
		this.game_panel = new JPanel();
		this.notification_panel = new JPanel();
		
		
		this.delete_user = new JButton("Delete User");
		this.reset_user_passwort = new JButton("Reset User Password");
		this.send_user_message = new JButton("Send User Message");
		this.search_user = new JButton("Search");
		
		this.search_label = new JLabel("Enter Nickname:");
		
		
		this.admin_pane = new JTabbedPane();
		
		this.search_user_field = new JTextField();
		
		this.user_table = new JTable();
		user_table.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		
		
		//add elements
		
		this.admin_pane.addTab("User", user_panel);
		
		this.user_buttons_panel.add(this.delete_user);
		this.user_buttons_panel.add(this.reset_user_passwort);
		this.user_buttons_panel.add(this.send_user_message);
		
		this.user_search_panel.add(this.search_label);
		this.user_search_panel.add(this.search_user_field);
		this.user_search_panel.add(this.search_user);
		
		this.user_panel.add(this.user_table, BorderLayout.CENTER);
		this.user_panel.add(this.user_buttons_panel, BorderLayout.EAST);
		this.user_panel.add(this.user_search_panel, BorderLayout.NORTH);
		
		
		this.admin_pane.addTab("Game", game_panel);
		this.admin_pane.addTab("Notification", notification_panel);
		
		this.master_container.add(this.admin_pane);
		
		this.window.getContentPane().add(this.master_container);
		
		
		//this.initListeners();
	}

	
	
	/*private void initListeners(){
		
	}*/
	
}
