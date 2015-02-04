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
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import oad.GUIController;
import oad.session;

import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.border.LineBorder;

import java.awt.Color;

public class PublicRankingGameWindow extends Window {
	//elements
	
	
	//panel	
	
	private JPanel public_ranking_game_panel;
	
	
	//labels
	
	private JLabel ranking_game_label;
	

	
	
	//buttons
	
	private JButton ranking_game_ok_button;
	private JButton ranking_game_cancel_button;

	public JComboBox<String> rating_box;
	
	
	public PublicRankingGameWindow(){

		
		//setup frame
		init_without_exit();
		this.setName("Titel des Spiels");
		this.setSize(450, 300);
		this.initSize();
		
		//init elements
		
		this.public_ranking_game_panel = new JPanel();
		public_ranking_game_panel.setLayout(null);
		
		this.ranking_game_label = new JLabel("Ranking:");
		ranking_game_label.setHorizontalAlignment(SwingConstants.CENTER);
		ranking_game_label.setLocation(6, 30);
		ranking_game_label.setSize(438, 20);
		
		this.ranking_game_ok_button = new JButton("OK");
		ranking_game_ok_button.setLocation(50, 231);
		ranking_game_ok_button.setSize(100, 20);
		
		this.ranking_game_cancel_button = new JButton("Cancel");
		ranking_game_cancel_button.setLocation(300, 231);
		ranking_game_cancel_button.setSize(100, 20);

		
		
		//add elements
		
		this.public_ranking_game_panel.add(this.ranking_game_label);
		this.public_ranking_game_panel.add(this.ranking_game_ok_button);
		this.public_ranking_game_panel.add(this.ranking_game_cancel_button);
		
		this.window.getContentPane().add(this.public_ranking_game_panel);
		
		rating_box = new JComboBox<String>();
		rating_box.addItem("1");
		rating_box.addItem("2");
		rating_box.addItem("3");
		rating_box.addItem("4");
		rating_box.addItem("5");
		rating_box.setBounds(193, 124, 75, 27);
		public_ranking_game_panel.add(rating_box);
		
		this.initListeners();
		
	}
	
	private void initListeners()
	{	this.ranking_game_ok_button.addActionListener(GUIController.add_ranking);
		this.ranking_game_cancel_button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				GUIController.w_public_ranking.hide();
			}
		});
		
	}
}
