package oadgui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import oad.session;

import javax.swing.SwingConstants;

import java.awt.Font;

public class GameSettingWindow extends Window {
	//elements
	
	
	//panel
	
	private JPanel game_settings_panel;
	
	
	//labels
	
	private JLabel background_color_label;
	private JLabel background_music_label;
	
	
	
	//buttons
	
	private JButton game_settings_cancel;
	private JButton game_settings_save;
	
	
	
	//combobox
	
	private JComboBox<?> background_color_box;
	private JComboBox<?> background_music_box;
	
	
	//strings
	
	String background_color[] = {"none", "red", "black", "white", "blue", "green"};
	String background_music[] = {"none", "music1", "music2", "music3", "music4"};
	
	
	
		
	
	
	
	public GameSettingWindow(){

		
		//setup frame
		init_without_exit();
		this.setName("Game Settings");
		this.setSize(450, 300);
		this.initSize();
		
		//init elements
		
		this.game_settings_panel = new JPanel();
		game_settings_panel.setLayout(null);
		
		this.background_color_label = new JLabel("Background - Color:");
		background_color_label.setHorizontalAlignment(SwingConstants.CENTER);
		background_color_label.setLocation(0, 52);
		background_color_label.setSize(200, 20);
		
		this.background_music_label = new JLabel("Background - Music:");
		background_music_label.setHorizontalAlignment(SwingConstants.CENTER);
		background_music_label.setLocation(0, 99);
		background_music_label.setSize(200, 20);
		
		this.game_settings_cancel = new JButton("Cancel");
		game_settings_cancel.setLocation(300, 225);
		game_settings_cancel.setSize(100, 20);
		
		this.game_settings_save = new JButton("Save");
		game_settings_save.setLocation(40, 225);
		game_settings_save.setSize(100, 20);
		
		this.background_color_box = new JComboBox<Object>(background_color);
		background_color_box.setLocation(264, 53);
		background_color_box.setSize(180, 20);
		
		this.background_music_box = new JComboBox<Object>(background_music);
		background_music_box.setLocation(264, 100);
		background_music_box.setSize(180, 20);
		
		
				
		
		//add elements
		
		this.game_settings_panel.add(this.background_color_label);
		this.game_settings_panel.add(this.background_music_label);
		this.game_settings_panel.add(this.game_settings_cancel);
		this.game_settings_panel.add(this.game_settings_save);
		
		this.game_settings_panel.add(this.background_color_box);
		this.game_settings_panel.add(this.background_music_box);
		
		
		
		this.window.getContentPane().add(this.game_settings_panel);
		
		
		
	
		
		
		this.initListeners();
		
	}
	
	private void initListeners(){
		this.game_settings_cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				hide();
			}
		});
	}

		
}
