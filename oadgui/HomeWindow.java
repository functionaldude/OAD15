package oadgui;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


import oad.User;
import oad.session;

import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import java.awt.Component;
import java.awt.Font;

public class HomeWindow extends Window {
	//elements
	
	//panel
	private JPanel master_container;
	
	private JPanel master_container_switch;
	
	private JPanel home_panel;
	private JPanel user_panel;
	private JPanel buttons_panel;
	
	private JPanel private_game_panel;
	private JPanel private_game_button_panel;
	
	private JPanel public_game_panel;
	private JPanel public_game_button_panel;
	
	private JPanel editor_panel;
	private JPanel editor_button_panel;
	
	private JPanel ranking_panel;
	private JPanel ranking_button_panel;
	
	
	//labels
	private JLabel home_label;
	private JLabel photo_label;
	
	
	
	//buttons
	private JButton play_private_game_button;
	private JButton play_public_game_button;
	private JButton editor_button;
	private JButton rankings_button;
	
	private JButton private_game_back_button;
	private JButton public_game_back_button;
	private JButton editor_back_button;
	private JButton ranking_back_button;
	

	
	
	//textfields/passwordfields
	
	
	//menu
	private JMenuBar 	main_menu;
	
	private JMenu 		setting_menu;
	private JMenu		help_menu;
	
	private JMenuItem	setting_menu_item1;
	private JMenuItem	setting_menu_item2;
	
	private JMenuItem	help_menu_item1;
	private JMenuItem	help_menu_item2;
	private JMenuItem	help_menu_item3;
	private JMenuItem	help_menu_item4;
	
	
		
	
	//vars
	session current_session;
	
	public HomeWindow(session input_session){
		//setup vars
		this.current_session = input_session;
		
		//setup frame
		init();
		this.setName("Travel Sales");
		this.setSize(1024, 768);
		this.initSize();
		
		//init elements
		
		this.master_container = new JPanel();
		master_container.setLayout(new BorderLayout(0, 0));
		
		this.master_container_switch = new JPanel(new CardLayout());
				
		this.home_panel = new JPanel();
		home_panel.setLayout(new BorderLayout(0, 0));
		
		this.user_panel = new JPanel();
		user_panel.setLayout(new BorderLayout(0, 0));
		
		this.buttons_panel = new JPanel();
		
		this.private_game_panel = new JPanel();
		private_game_panel.setLayout(new BorderLayout(0, 0));
		
		this.private_game_button_panel = new JPanel();
		
		this.public_game_panel = new JPanel();
		public_game_panel.setLayout(new BorderLayout(0, 0));
		
		this.public_game_button_panel = new JPanel();
		
		this.editor_panel = new JPanel();
		editor_panel.setLayout(new BorderLayout(0, 0));
		
		this.editor_button_panel = new JPanel();
		
		this.ranking_panel = new JPanel();
		ranking_panel.setLayout(new BorderLayout(0, 0));
		
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
		
		
		this.home_label = new JLabel("Hello User");
		home_label.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		home_label.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		this.photo_label = new JLabel(new ImageIcon("/Users/martinzagar/Documents/oad_images/fb_punisher.jpg"));
		photo_label.setVerticalAlignment(SwingConstants.TOP);
		
		
		this.play_private_game_button = new JButton("Play Private Game");
		this.play_public_game_button = new JButton("Play Public Game");
		this.editor_button = new JButton("Editor");
		this.rankings_button = new JButton("Rankings");
		
		
		this.private_game_back_button = new JButton("Back");
		this.public_game_back_button = new JButton("Back");
		this.editor_back_button = new JButton("Back");
		this.ranking_back_button = new JButton("Back");
		
		
		
		//add elements
		
		this.setting_menu.add(this.setting_menu_item1);
		this.setting_menu.add(this.setting_menu_item2);
		
		
		this.help_menu.add(this.help_menu_item1);
		this.help_menu.add(this.help_menu_item2);
		this.help_menu.add(this.help_menu_item3);
		this.help_menu.add(this.help_menu_item4);
		
		
		this.main_menu.add(this.setting_menu);
		this.main_menu.add(this.help_menu);
		
		
		this.user_panel.add(this.home_label, BorderLayout.NORTH);
		this.user_panel.add(this.photo_label, BorderLayout.CENTER);
		
		
		this.buttons_panel.add(this.play_private_game_button);
		this.buttons_panel.add(this.play_public_game_button);
		this.buttons_panel.add(this.editor_button);
		this.buttons_panel.add(this.rankings_button);
		
		
		this.home_panel.add(this.user_panel, BorderLayout.CENTER);
		this.home_panel.add(this.buttons_panel, BorderLayout.SOUTH);
		
		
		this.private_game_button_panel.add(this.private_game_back_button);
		this.public_game_button_panel.add(this.public_game_back_button);
		this.editor_button_panel.add(this.editor_back_button);
		this.ranking_button_panel.add(this.ranking_back_button);
		
		
		this.private_game_panel.add(this.private_game_button_panel, BorderLayout.SOUTH);
		this.public_game_panel.add(this.public_game_button_panel, BorderLayout.SOUTH);
		this.editor_panel.add(this.editor_button_panel, BorderLayout.SOUTH);
		this.ranking_panel.add(this.ranking_button_panel, BorderLayout.SOUTH);
		
		
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
			}	
		});
		
		this.private_game_back_button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				CardLayout cl = (CardLayout)(master_container_switch.getLayout());
		        cl.show(master_container_switch,"Karte1" );
				
			}	
		});
		
		this.play_public_game_button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				CardLayout cl = (CardLayout)(master_container_switch.getLayout());
		        cl.show(master_container_switch,"Karte3" );
			}	
		});
		
		this.public_game_back_button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				CardLayout cl = (CardLayout)(master_container_switch.getLayout());
		        cl.show(master_container_switch,"Karte1" );
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
		
	
	}



		
}
