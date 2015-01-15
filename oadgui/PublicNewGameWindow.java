package oadgui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import oad.GUIController;
import oad.session;

import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.border.LineBorder;

import java.awt.Color;

public class PublicNewGameWindow extends Window {
	//elements
	
	
	//panel	
	
	private JPanel public_new_game_panel;
	
	
	//labels
	
	private JLabel select_game_label;
	

	
	
	//buttons
	
	private JButton new_game_ok_button;
	private JButton new_game_cancel_button;

	
	//ComboBox
	
	public JComboBox<String> list_of_public_games;

	

	
	public PublicNewGameWindow(){

		
		//setup frame
		init_without_exit();
		this.setName("New Public Game");
		this.setSize(450, 300);
		this.initSize();
		
		//init elements
		
		this.public_new_game_panel = new JPanel();
		public_new_game_panel.setLayout(null);

		
		
		this.select_game_label = new JLabel("Select A Game:");
		select_game_label.setHorizontalAlignment(SwingConstants.CENTER);
		select_game_label.setLocation(6, 65);
		select_game_label.setSize(200, 20);
		
		this.list_of_public_games = new JComboBox<String>();
		list_of_public_games.setLocation(244, 65);
		list_of_public_games.setSize(200, 20);
		
		this.new_game_ok_button = new JButton("OK");
		new_game_ok_button.setLocation(70, 225);
		new_game_ok_button.setSize(100, 20);

		this.new_game_cancel_button = new JButton("Cancel");
		new_game_cancel_button.setLocation(280, 225);
		new_game_cancel_button.setSize(100, 20);
		
				
		
		//add elements
		
		this.public_new_game_panel.add(this.select_game_label);
		
		this.public_new_game_panel.add(this.new_game_ok_button);
		
		this.public_new_game_panel.add(this.list_of_public_games);
		
		this.public_new_game_panel.add(this.new_game_cancel_button);
		
		this.window.getContentPane().add(this.public_new_game_panel);
		
		this.initListeners();
		
	}
	
	private void initListeners()
	{	
		this.new_game_ok_button.addActionListener(GUIController.load_public_game);
	}



		
}
