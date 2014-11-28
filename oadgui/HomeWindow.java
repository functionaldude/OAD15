package oadgui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
	private JMenuBar menu;
	
	private JMenu home;
	private JMenu games;
	private JMenu settings;
	private JMenu help;
	
	private JMenuItem menu_games_newgame;
	private JMenuItem menu_games_editor;
	private JMenuItem menu_games_topgames;
	
	private JMenuItem menu_settings_usersettings;
	
	private JMenuItem menu_help_contact;
	private JMenuItem menu_help_tutorial;
	private JMenuItem menu_help_forum;
	
	
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
		
		this.menu = new JMenuBar();
		
		this.home = new JMenu("Home");
		this.games = new JMenu("Games");
		this.settings = new JMenu("Settings");
		this.help = new JMenu("Help");
		
		this.menu_games_newgame = new JMenuItem("New Game");
		this.menu_games_editor = new JMenuItem("Editor");
		this.menu_games_topgames = new JMenuItem("Top Games");
		
		this.menu_settings_usersettings = new JMenuItem("User Settings");
		
		this.menu_help_contact = new JMenuItem("Contact");
		this.menu_help_tutorial = new JMenuItem("Tutorials");
		this.menu_help_forum = new JMenuItem("Forum");
		
		
		
		
		this.home_panel.setLayout(new BorderLayout());
		
		//add elements
		
		this.games.add(this.menu_games_newgame);
		this.games.add(this.menu_games_editor);
		this.games.add(this.menu_games_topgames);
		
		this.settings.add(this.menu_settings_usersettings);
		
		this.help.add(this.menu_help_contact);
		this.help.add(this.menu_help_tutorial);
		this.help.add(this.menu_help_forum);
		
		this.menu.add(this.home);
		this.menu.add(this.games);
		this.menu.add(this.settings);
		this.menu.add(this.help);
		
		this.home_panel.add(this.menu, BorderLayout.PAGE_START);
		
		
		this.window.getContentPane().add(this.home_panel);

		

		
		this.initListeners();
	}
	
	private void initListeners(){
		
	}
}
