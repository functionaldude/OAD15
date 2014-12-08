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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


public class AdminWindow extends Window{
	//elements
	
	//labels
	private JLabel search_label; 
	private JLabel search_notification_label;
	
	//panels
	private JPanel master_container;
	
	private JPanel user_panel;
	private JPanel user_buttons_panel;
	private JPanel user_search_panel;
	
	private JPanel game_panel;
	private JPanel game_buttons_panel;
	
	private JPanel notification_panel;
	private JPanel notification_buttons_panel;
	private JPanel notification_search_panel;
	
	
	//buttons
	private JButton delete_user;
	private JButton reset_user_passwort;
	private JButton send_user_message;
	private JButton search_user;
	
	private JButton delete_game;
	private JButton add_new_game;
	
	private JButton answer_notification;
	private JButton delete_notification;
	private JButton search_notification;
	
	
	//table
	private JTable user_table;
	private JTable game_table;
	private JTable notification_table;
	
	
	//textfields
	
	private JTabbedPane admin_pane;
	private JTextField search_user_field;
	private JTextField search_notification_field;
	
	
	//string
	//private String[] columnNames = {"ID", "Username", "PW", "E-Mail"};

	
	
	//vars
	session current_session;
	UserTableModel user_table_content;
	
	public AdminWindow(session input_session){
		//setup vars
		this.current_session = input_session;
		try {
			this.user_table_content = new UserTableModel(current_session.searchUser(null));
		} catch (SQLException e) {}
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
		game_panel.setLayout(new BorderLayout(5, 5));
		
		this.game_buttons_panel = new JPanel();
		game_buttons_panel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		game_buttons_panel.setLayout(new BoxLayout(game_buttons_panel, BoxLayout.PAGE_AXIS));
		
		this.notification_panel = new JPanel();
		notification_panel.setLayout(new BorderLayout(5, 5));
		
		this.notification_buttons_panel = new JPanel();
		notification_buttons_panel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		notification_buttons_panel.setLayout(new BoxLayout(notification_buttons_panel, BoxLayout.PAGE_AXIS));
		
		this.notification_search_panel = new JPanel();
		notification_search_panel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		notification_search_panel.setLayout(new BoxLayout(notification_search_panel, BoxLayout.LINE_AXIS));
		
		
		this.delete_user = new JButton("Delete User");
		this.reset_user_passwort = new JButton("Reset User Password");
		this.send_user_message = new JButton("Send User Message");
		this.search_user = new JButton("Search");

		this.delete_game = new JButton("Delete Game");
		this.add_new_game = new JButton("Add New Game");
		
		this.answer_notification = new JButton("Answer");
		this.delete_notification = new JButton("Delete");
		this.search_notification = new JButton("Search");
		
		
		this.search_label = new JLabel("Enter Nickname:");
		this.search_notification_label = new JLabel("Enter Message:");
		
		
		this.admin_pane = new JTabbedPane();
		
		this.search_user_field = new JTextField();
		this.search_notification_field = new JTextField();
		
		this.user_table = new JTable(user_table_content.getData(), new String[] {"ID", "Username", "PW", "E-Mail"});
		user_table.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		
		this.game_table = new JTable();
		game_table.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		
		this.notification_table = new JTable();
		notification_table.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		
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
		
		this.game_buttons_panel.add(this.delete_game);
		this.game_buttons_panel.add(this.add_new_game);
		
		this.game_panel.add(this.game_table, BorderLayout.CENTER);
		this.game_panel.add(this.game_buttons_panel, BorderLayout.EAST);
		
		
		
		this.admin_pane.addTab("Notification", notification_panel);
		
		this.notification_search_panel.add(this.search_notification_label);
		this.notification_search_panel.add(this.search_notification_field);
		this.notification_search_panel.add(this.search_notification);
		
		this.notification_buttons_panel.add(this.answer_notification);
		this.notification_buttons_panel.add(this.delete_notification);
		
		this.notification_panel.add(this.notification_search_panel, BorderLayout.NORTH);
		this.notification_panel.add(this.notification_buttons_panel, BorderLayout.EAST);
		this.notification_panel.add(this.notification_table, BorderLayout.CENTER);
		
		this.master_container.add(this.admin_pane);
		
		this.window.getContentPane().add(this.master_container);
		
		
		this.initListeners();
	}

	
	
	private void initListeners(){
		this.search_user.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				try {
					user_table.setModel(new UserTableModel(current_session.searchUser(search_user_field.getText())));
				} catch (SQLException e1) {
					System.out.println("SQLException: "+e1.getMessage());
				}
			}
		});
	}
	
}
