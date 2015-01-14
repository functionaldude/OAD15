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

	
	//RadioButton
	
	private JRadioButton one;
	private JRadioButton two;
	private JRadioButton three;
	private JRadioButton four;
	private JRadioButton five;
	
	
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
		
		this.one = new JRadioButton("1");
		one.setHorizontalAlignment(SwingConstants.CENTER);
		one.setLocation(21, 120);
		one.setSize(75, 20);
		
		this.two = new JRadioButton("2");
		two.setHorizontalAlignment(SwingConstants.CENTER);
		two.setLocation(108, 120);
		two.setSize(75, 20);
		
		this.three = new JRadioButton("3");
		three.setHorizontalAlignment(SwingConstants.CENTER);
		three.setLocation(195, 120);
		three.setSize(75, 20);
		
		this.four = new JRadioButton("4");
		four.setHorizontalAlignment(SwingConstants.CENTER);
		four.setLocation(282, 120);
		four.setSize(75, 20);
		
		this.five = new JRadioButton("5");
		five.setHorizontalAlignment(SwingConstants.CENTER);
		five.setLocation(369, 120);
		five.setSize(75, 20);

		
		
		//add elements
		
		this.public_ranking_game_panel.add(this.ranking_game_label);
		this.public_ranking_game_panel.add(this.ranking_game_ok_button);
		this.public_ranking_game_panel.add(this.ranking_game_cancel_button);
		this.public_ranking_game_panel.add(this.one);
		this.public_ranking_game_panel.add(this.two);
		this.public_ranking_game_panel.add(this.three);
		this.public_ranking_game_panel.add(this.four);
		this.public_ranking_game_panel.add(this.five);
		
		this.window.getContentPane().add(this.public_ranking_game_panel);
		
		this.initListeners();
		
	}
	
	private void initListeners()
	{	
		
		
	}



		
}
