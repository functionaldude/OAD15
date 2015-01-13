package oadgui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import oad.AudioHandler;
import oad.GUIController;
import oad.session;

import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JList;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;

import java.awt.*;

public class HomeWindow extends Window {
	//elements
	
	//panel
	public JPanel master_container;
	
	private JPanel master_container_switch;
	
	public JPanel home_panel;
	private JPanel home_notification_panel;
	public JPanel user_panel;
	public JPanel buttons_panel;
	
	public JPanel private_game_panel;
	public JPanel private_game_playground_panel;
	private JPanel private_game_button_panel;
	private JPanel private_game_right_side;
	
	public JPanel public_game_panel;
	public JPanel public_game_title_panel;
	public JPanel public_game_playground_panel;
	private JPanel public_game_button_panel;
	private JPanel public_game_right_side;
	private JPanel public_game_ranking_panel;
	
	private JPanel editor_panel;
	private JPanel editor_editor_panel;
	private JPanel editor_button_panel;
	private JPanel editor_right_side;
	private JPanel editor_title_panel;
	private JPanel editor_editor_button_panel;
	
	private JPanel ranking_panel;
	private JPanel ranking_button_panel;
	
	
	//labels
	public JLabel home_label;
	public JLabel photo_label;
	private JLabel private_game_titel;
	private JLabel public_game_titel;
	private JLabel public_rating_label;
	private JLabel public_rating_result_label;
	private JLabel editor_titel_label;
	private JLabel editor_game_titel_label;
	private JLabel editor_game_description_label;
	
	//table
	String columnName[] = {"First Name", "Last Name", "Sport", "# of Years", "Vegetarian"};
	String games[] = {"Private Game", "Public Game"};
	
	Object[][] data = {
		    {"Kathy", "Smith",
		     "Snowboarding", new Integer(5), new Boolean(false)},
		    {"John", "Doe",
		     "Rowing", new Integer(3), new Boolean(true)},
		    {"Sue", "Black",
		     "Knitting", new Integer(2), new Boolean(false)},
		    {"Jane", "White",
		     "Speed reading", new Integer(20), new Boolean(true)},
		    {"Joe", "Brown",
		     "Pool", new Integer(10), new Boolean(false)}
		};
	
	public int clickedButton = 0;
	
	
	
	
	private JTable notification_table;
	
	
	//buttons
	private JButton play_private_game_button;
	private JButton play_public_game_button;
	private JButton editor_button;
	private JButton rankings_button;
	
	private JButton private_game_back_button;
	private JButton public_game_back_button;
	private JButton editor_back_button;
	private JButton ranking_back_button;
	
	private JButton editor_save_button;
	private JButton editor_cancel_button;
	private JButton draw_circle_button;
	private JButton draw_connection_button;
	private JButton draw_figure_button;
	
	//radiobutton
	private JRadioButton ranking1;
	private JRadioButton ranking2;
	private JRadioButton ranking3;
	private JRadioButton ranking4;
	private JRadioButton ranking5;
		
	
	//menu
	private JMenuBar 	main_menu;
	
	private JMenu 		setting_menu;
	private JMenu		help_menu;
	private JMenu session_menu;
	
	private JMenuItem	setting_menu_item1;
	private JMenuItem	setting_menu_item2;
	
	private JMenuItem	help_menu_item1;
	private JMenuItem	help_menu_item2;
	private JMenuItem	help_menu_item3;
	private JMenuItem	help_menu_item4;
	
	private JMenuItem session_menu_item1;
	
	//combobox
	private JComboBox private_game_box;
	private JComboBox public_game_box;
	private JComboBox editor_box;
	
	//textpane
	private JTextPane private_game_description;
	private JTextPane public_game_description;
	private JTextPane editor_description;
	//textfield
	
	private JTextField editor_titel_textfield;	
	
	public HomeWindow(){

		
		//setup frame
		init();
		this.setName("Travel Sales");
		this.setSize(1024, 768);
		this.initSize();
		
		//init elements
		
		this.master_container = new JPanel();
		master_container.setLayout(new BorderLayout(5, 5));
		
		this.master_container_switch = new JPanel(new CardLayout());
				
		this.home_panel = new JPanel();
		home_panel.setLayout(new BorderLayout(5, 5));
		
		this.home_notification_panel = new JPanel();
		home_notification_panel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		home_notification_panel.setLayout(new BorderLayout(0, 0));
		
		this.user_panel = new JPanel();
		user_panel.setLayout(new BorderLayout(5, 5));
		
		this.buttons_panel = new JPanel();
		
		this.private_game_panel = new JPanel();
		private_game_panel.setLayout(new BorderLayout(5, 5));
		
		this.private_game_button_panel = new JPanel();
		this.private_game_playground_panel = new JPanel();
		private_game_playground_panel.setBorder(BorderFactory.createLoweredBevelBorder());
		
		this.private_game_right_side = new JPanel();
		private_game_right_side.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		private_game_right_side.setLayout(new BoxLayout(private_game_right_side, BoxLayout.PAGE_AXIS));
		
		this.public_game_panel = new JPanel();
		public_game_panel.setLayout(new BorderLayout(5, 5));
		
		this.public_game_button_panel = new JPanel();
		this.public_game_title_panel = new JPanel();
		this.public_game_ranking_panel = new JPanel();
		public_game_title_panel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		
		this.public_game_playground_panel = new JPanel();
		public_game_playground_panel.setBorder(BorderFactory.createLoweredBevelBorder());
		
		this.public_game_right_side = new JPanel();
		public_game_right_side.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		public_game_right_side.setLayout(new BoxLayout(public_game_right_side, BoxLayout.PAGE_AXIS));
		
		this.editor_panel = new JPanel();
		editor_panel.setLayout(new BorderLayout(5, 5));
		
		this.editor_button_panel = new JPanel();
		this.editor_editor_panel = new JPanel();
		editor_editor_panel.setBorder(BorderFactory.createLoweredBevelBorder());
		
		this.editor_right_side = new JPanel();
		editor_right_side.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		editor_right_side.setLayout(new BoxLayout(editor_right_side, BoxLayout.PAGE_AXIS));
		
		this.editor_title_panel = new JPanel();
		editor_title_panel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		
		
		this.editor_editor_button_panel = new JPanel();
		
		
		
		this.ranking_panel = new JPanel();
		ranking_panel.setLayout(new BorderLayout(5, 5));
		
		this.ranking_button_panel = new JPanel();
		
		
		
		
		
		this.main_menu = new JMenuBar();
		
		this.setting_menu = new JMenu("Settings");
		this.help_menu = new JMenu("Help");
		
		
		this.setting_menu_item1 = new JMenuItem("User Settings");
		this.setting_menu_item2 = new JMenuItem("Game Settings");
		
		
		this.help_menu_item1 = new JMenuItem("Tutorial");
		this.help_menu_item2 = new JMenuItem("Feedback");
		this.help_menu_item3 = new JMenuItem("Contact");
		this.help_menu_item4 = new JMenuItem("About Us");
		
		this.home_label = new JLabel();
		home_label.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		home_label.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		this.photo_label = new JLabel();
		photo_label.setVerticalAlignment(SwingConstants.TOP);
		photo_label.setHorizontalAlignment(SwingConstants.CENTER);
		
		this.private_game_titel = new JLabel("Hier kommt der Titel des Spiels rein");
		private_game_titel.setHorizontalAlignment(SwingConstants.CENTER);
		private_game_titel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		private_game_titel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		
		this.public_game_titel = new JLabel("Hier kommt der Titel des Spiels rein");
		this.public_rating_label = new JLabel("Ranking:");
		this.public_rating_result_label = new JLabel("Hier soll das Ergebnis rein");
		
		this.editor_titel_label = new JLabel("Editor");
		editor_titel_label.setHorizontalAlignment(SwingConstants.CENTER);
		editor_titel_label.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		editor_titel_label.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		
		this.editor_game_titel_label = new JLabel("Title:");
		this.editor_game_description_label = new JLabel("Description:");
		editor_game_description_label.setHorizontalAlignment(SwingConstants.LEFT);
		
		
		
		this.notification_table = new JTable(data,columnName);
		
		
		this.play_private_game_button = new JButton("Play Private Game");
		this.play_public_game_button = new JButton("Play Public Game");
		this.editor_button = new JButton("Editor");
		this.rankings_button = new JButton("Rankings");
		
		
		this.private_game_back_button = new JButton("Back");
		this.public_game_back_button = new JButton("Back");
		this.editor_back_button = new JButton("Back");
		this.ranking_back_button = new JButton("Back");
		
		this.draw_circle_button = new JButton("Circle");
		this.draw_connection_button = new JButton("Connection");
		this.draw_figure_button = new JButton("Figure");
		this.editor_save_button = new JButton("Save");
		this.editor_cancel_button = new JButton("Cancel");
		
		
		this.private_game_box = new JComboBox();
		this.private_game_description = new JTextPane();
		private_game_description.setText("Hier soll die Beschreibung\nstehen, die man im Editor\nerstellen kann");
		
		this.public_game_box = new JComboBox();
		this.public_game_description = new JTextPane();
		public_game_description.setText("Hier soll die Beschreibung\nstehen, die man im Editor\nerstellen kann");
		
		this.editor_box = new JComboBox(games);
		this.editor_description = new JTextPane();
		
		
		this.editor_titel_textfield = new JTextField();
		
		
		this.ranking1 = new JRadioButton("1");
		this.ranking2 = new JRadioButton("2");
		this.ranking3 = new JRadioButton("3");
		this.ranking4 = new JRadioButton("4");
		this.ranking5 = new JRadioButton("5");				
		
		//add elements
		
		this.setting_menu.add(this.setting_menu_item1);
		this.setting_menu.add(this.setting_menu_item2);
		
		
		this.help_menu.add(this.help_menu_item1);
		this.help_menu.add(this.help_menu_item2);
		this.help_menu.add(this.help_menu_item3);
		this.help_menu.add(this.help_menu_item4);
		this.session_menu = new JMenu("Session");
		
		this.session_menu_item1 = new JMenuItem("Logout");
		this.main_menu.add(this.session_menu);
		
		this.session_menu.add(this.session_menu_item1);
		
		
		this.main_menu.add(this.setting_menu);
		this.main_menu.add(this.help_menu);
		
		this.user_panel.add(this.home_label, BorderLayout.NORTH);
		this.user_panel.add(this.photo_label, BorderLayout.CENTER);
		this.user_panel.add(this.home_notification_panel, BorderLayout.EAST);
		
		this.home_notification_panel.add(this.notification_table, BorderLayout.CENTER);
		this.home_notification_panel.add(this.notification_table.getTableHeader(), BorderLayout.NORTH);
		
		
		this.buttons_panel.add(this.play_private_game_button);
		this.buttons_panel.add(this.play_public_game_button);
		this.buttons_panel.add(this.editor_button);
		this.buttons_panel.add(this.rankings_button);
		
		this.public_game_ranking_panel.add(this.ranking1);
		this.public_game_ranking_panel.add(this.ranking2);
		this.public_game_ranking_panel.add(this.ranking3);
		this.public_game_ranking_panel.add(this.ranking4);
		this.public_game_ranking_panel.add(this.ranking5);
		
	
		
		this.home_panel.add(this.user_panel, BorderLayout.CENTER);
		this.home_panel.add(this.buttons_panel, BorderLayout.SOUTH);
		
		
		
		this.private_game_right_side.add(this.private_game_box);
		this.private_game_right_side.add(this.private_game_description);
		
		this.public_game_right_side.add(this.public_game_box);
		this.public_game_right_side.add(this.public_game_description);
		this.public_game_right_side.add(this.public_game_ranking_panel);
		
		this.public_game_title_panel.add(this.public_game_titel);
		this.public_game_title_panel.add(this.public_rating_label);
		this.public_game_title_panel.add(this.public_rating_result_label);
		
		
		this.private_game_button_panel.add(this.private_game_back_button);
		this.public_game_button_panel.add(this.public_game_back_button);
		
		this.editor_button_panel.add(this.editor_back_button);
		this.editor_button_panel.add(this.editor_save_button);
		this.editor_button_panel.add(this.editor_cancel_button);
		
		this.ranking_button_panel.add(this.ranking_back_button);
		
		
		
		this.private_game_panel.add(this.private_game_titel, BorderLayout.NORTH);
		this.private_game_panel.add(this.private_game_button_panel, BorderLayout.SOUTH);
		this.private_game_panel.add(this.private_game_playground_panel, BorderLayout.CENTER);
		this.private_game_panel.add(this.private_game_right_side, BorderLayout.EAST);
		
		
		this.public_game_panel.add(this.public_game_title_panel, BorderLayout.NORTH);
		this.public_game_panel.add(this.public_game_button_panel, BorderLayout.SOUTH);
		this.public_game_panel.add(this.public_game_playground_panel, BorderLayout.CENTER);
		this.public_game_panel.add(this.public_game_right_side, BorderLayout.EAST);
		
		
		this.editor_panel.add(this.editor_button_panel, BorderLayout.SOUTH);
		
		this.ranking_panel.add(this.ranking_button_panel, BorderLayout.SOUTH);
		
		this.editor_editor_button_panel.add(this.draw_circle_button);
		this.editor_editor_button_panel.add(this.draw_connection_button);
		this.editor_editor_button_panel.add(this.draw_figure_button);
		editor_title_panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		this.editor_title_panel.add(this.editor_game_titel_label);
		this.editor_title_panel.add(this.editor_titel_textfield);
		
		this.editor_right_side.add(this.editor_box);
		//this.editor_right_side.add(this.editor_titel_textfield);
		this.editor_right_side.add(this.editor_title_panel);
		this.editor_right_side.add(this.editor_game_description_label);
		this.editor_right_side.add(this.editor_description);
		this.editor_right_side.add(this.editor_editor_button_panel);
		
		this.editor_panel.add(this.editor_titel_label, BorderLayout.NORTH);
		this.editor_panel.add(this.editor_editor_panel, BorderLayout.CENTER);
		this.editor_panel.add(this.editor_right_side, BorderLayout.EAST);
		
		
		
		
		this.master_container_switch.add(home_panel, "Karte1");
		this.master_container_switch.add(private_game_panel, "Karte2");
		this.master_container_switch.add(public_game_panel, "Karte3");
		this.master_container_switch.add(editor_panel, "Karte4");
		this.master_container_switch.add(ranking_panel, "Karte5");
		
		
		this.master_container.add(this.main_menu, BorderLayout.NORTH);
		this.master_container.add(this.master_container_switch, BorderLayout.CENTER);

		
		this.window.getContentPane().add(this.master_container);
		
		
		CardLayout cl = (CardLayout)(master_container_switch.getLayout());
        cl.show(master_container_switch,"Karte1" );
		
        
        
		
        
		this.initListeners();
		
		
		
	}
	
		
	private void initListeners()
	{
		this.play_private_game_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				CardLayout cl = (CardLayout)(master_container_switch.getLayout());
		        cl.show(master_container_switch,"Karte2" );	
		        GUIController.sessionvar.musicplayer.start();
		        
		        
		        
			}	
		});
		
		this.private_game_back_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				CardLayout cl = (CardLayout)(master_container_switch.getLayout());
		        cl.show(master_container_switch,"Karte1" );
		        GUIController.sessionvar.musicplayer.stop();
			}	
		});
		
		this.play_public_game_button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				CardLayout cl = (CardLayout)(master_container_switch.getLayout());
		        cl.show(master_container_switch,"Karte3" );
		        GUIController.sessionvar.musicplayer.start();
			}	
		});
		
		this.public_game_back_button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				CardLayout cl = (CardLayout)(master_container_switch.getLayout());
		        cl.show(master_container_switch,"Karte1" );
		        GUIController.sessionvar.musicplayer.stop();
			}	
		});
		
		this.editor_button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				CardLayout cl = (CardLayout)(master_container_switch.getLayout());
		        cl.show(master_container_switch,"Karte4" );
			}	
		});
		
		this.editor_back_button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				CardLayout cl = (CardLayout)(master_container_switch.getLayout());
		        cl.show(master_container_switch,"Karte1" );
			}	
		});
		
		this.rankings_button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				CardLayout cl = (CardLayout)(master_container_switch.getLayout());
		        cl.show(master_container_switch,"Karte5" );
			}	
		});
		
		this.ranking_back_button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				CardLayout cl = (CardLayout)(master_container_switch.getLayout());
		        cl.show(master_container_switch,"Karte1" );
			}	
		});
		
		this.draw_circle_button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				clickedButton = 1;
			}
			
		});
		
		this.draw_connection_button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				clickedButton = 2;
			}
			
		});
		
		this.draw_figure_button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				clickedButton = 3;
			}
			
		});
		
		this.editor_editor_panel.addMouseListener(new MouseListener(){

			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(clickedButton == 1)
				{
					System.out.println("Mouse Clicked (Circle): ("+e.getX()+", "+e.getY() +")");
										
				}
				else if(clickedButton == 2)
				{
					System.out.println("Mouse Clicked (Connection): ("+e.getX()+", "+e.getY() +")");
				}
				else
				{
					System.out.println("Mouse Clicked (Figure): ("+e.getX()+", "+e.getY() +")");
				}
			}
			
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		clickedButton = 0;

		
		
		
				
				
			
		
		
		
		this.setting_menu_item1.addActionListener(GUIController.open_usersettings);
		this.setting_menu_item2.addActionListener(GUIController.open_gamesettings);
		this.help_menu_item4.addActionListener(GUIController.open_about);
		this.help_menu_item3.addActionListener(GUIController.open_contact);
		this.help_menu_item1.addActionListener(GUIController.open_contact);
		this.help_menu_item2.addActionListener(GUIController.open_feedback);
		this.session_menu_item1.addActionListener(GUIController.logout);
	
	}



		
}
