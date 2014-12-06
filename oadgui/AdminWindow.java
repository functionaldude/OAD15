package oadgui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import oad.session;

import java.awt.CardLayout;
import java.awt.BorderLayout;
import javax.swing.JList;


public class AdminWindow extends Window{
	//elements
	
	//labels
	
	//panels
	private JPanel master_container;
	private JPanel user_panel;
	private JPanel game_panel;
	private JPanel notification_panel;
	
	
	//buttons
	
	
	//textfields
	
	private JTabbedPane admin_pane;
	
	
	//frames
	
	
	//vars
	session current_session;
	
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
		this.game_panel = new JPanel();
		this.notification_panel = new JPanel();
		
		this.admin_pane = new JTabbedPane();
		
		
		//add elements
		
		this.admin_pane.addTab("User", user_panel);
		user_panel.setLayout(new BorderLayout(0, 0));
		
		
		
		
		this.admin_pane.addTab("Game", game_panel);
		this.admin_pane.addTab("Notification", notification_panel);
		
		this.master_container.add(this.admin_pane);
		
		this.window.getContentPane().add(this.master_container);
		
		
		//this.initListeners();
	}

	
	
	/*private void initListeners(){
		
	}*/
	
}
