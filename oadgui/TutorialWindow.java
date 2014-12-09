package oadgui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import oad.session;

import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;

public class TutorialWindow extends Window {
	//elements
	
	
	//panel
	
	private JPanel tutorial_panel;
	
	
	//labels
	
	private JLabel tutorial_editor_label;
	private JLabel tutorial_game_label;
	private JLabel tutorial_travelsale_label;
	
	
	
	
	//buttons
	
	private JButton tutorial_window_ok;
	
	
	
	
	
	//fields
	
	private JTextPane tutorial_editor_pane;
	private JTextPane tutorial_game_pane;
	private JTextPane tutorial_travelsale_pane;
	
	
	
	public TutorialWindow(){

		
		//setup frame
		init_without_exit();
		this.setName("Tutorials");
		this.setSize(653, 500);
		this.initSize();
		
		//init elements
		
		this.tutorial_panel = new JPanel();
		tutorial_panel.setLayout(null);
		
		this.tutorial_editor_pane = new JTextPane();
		tutorial_editor_pane.setLocation(6, 42);
		tutorial_editor_pane.setSize(639, 91);
		tutorial_editor_pane.setText("");
		tutorial_editor_pane.setEditable(false);
		tutorial_editor_pane.setBorder(BorderFactory.createLoweredBevelBorder());
		
		this.tutorial_game_pane = new JTextPane();
		tutorial_game_pane.setLocation(6, 177);
		tutorial_game_pane.setSize(639, 91);
		tutorial_game_pane.setText("");
		tutorial_game_pane.setEditable(false);
		tutorial_game_pane.setBorder(BorderFactory.createLoweredBevelBorder());
		
		this.tutorial_travelsale_pane = new JTextPane();
		tutorial_travelsale_pane.setLocation(6, 312);
		tutorial_travelsale_pane.setSize(639, 91);
		tutorial_travelsale_pane.setText("The travelling salesman problem (TSP) asks the following question: \nGiven a list of cities and the distances between each pair of cities, what is the shortest possible route that visits each city exactly once and returns to the origin city? It is an NP-hard problem in combinatorial optimization, important in operations research and theoretical computer science.");
		tutorial_travelsale_pane.setEditable(false);
		tutorial_travelsale_pane.setBorder(BorderFactory.createLoweredBevelBorder());
		
		this.tutorial_editor_label = new JLabel("Editor Tutorial:");
		tutorial_editor_label.setLocation(6, 10);
		tutorial_editor_label.setSize(200, 20);
		
		this.tutorial_game_label = new JLabel("Game Tutorial:");
		tutorial_game_label.setLocation(6, 145);
		tutorial_game_label.setSize(200, 20);
		
		this.tutorial_travelsale_label = new JLabel("Travel Sales Tutorial:");
		tutorial_travelsale_label.setLocation(6, 280);
		tutorial_travelsale_label.setSize(200, 20);
		
		
		this.tutorial_window_ok = new JButton("OK");
		tutorial_window_ok.setLocation(272, 450);
		tutorial_window_ok.setSize(100, 20);
		
				
		
		//add elements
		
		this.tutorial_panel.add(this.tutorial_editor_pane);
		this.tutorial_panel.add(this.tutorial_game_pane);
		this.tutorial_panel.add(this.tutorial_travelsale_pane);
		this.tutorial_panel.add(this.tutorial_editor_label);
		this.tutorial_panel.add(this.tutorial_game_label);
		this.tutorial_panel.add(this.tutorial_travelsale_label);
		this.tutorial_panel.add(this.tutorial_window_ok);
		
		
		this.window.getContentPane().add(this.tutorial_panel);
		
		
		this.initListeners();
		
	}
	
	private void initListeners(){
		this.tutorial_window_ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				hide();
			}
		});
	}



		
}
