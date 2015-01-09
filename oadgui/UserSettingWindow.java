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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import oad.GUIController;
import oad.session;

import javax.swing.SwingConstants;

import java.awt.Font;

public class UserSettingWindow extends Window {
	//elements
	
	
	//panel
	
	private JPanel user_settings_panel;
	private JLabel new_nickname_label;
	private JLabel old_password_label;
	private JLabel new_password_label;
	public JLabel usrimg;
	
	
	//buttons
	
	private JButton user_settings_cancel;
	private JButton user_settings_save;
	public JTextField new_nickname_field;
	public JPasswordField old_password_field;
	public JPasswordField new_password_field;
	
	
	
	
		
	

	
	
	public UserSettingWindow(){

		
		//setup frame
		init_without_exit();
		this.setName("User Settings");
		this.setSize(450, 300);
		this.initSize();
		
		//init elements
		
		this.user_settings_panel = new JPanel();
		user_settings_panel.setLayout(null);
		
		this.new_nickname_label = new JLabel("New nickname:");
		new_nickname_label.setHorizontalAlignment(SwingConstants.RIGHT);
		new_nickname_label.setLocation(8, 57);
		new_nickname_label.setSize(176, 20);
		
		this.old_password_label = new JLabel("Old password:");
		old_password_label.setHorizontalAlignment(SwingConstants.RIGHT);
		old_password_label.setLocation(6, 89);
		old_password_label.setSize(178, 20);
		
		this.new_password_label = new JLabel("New password:");
		new_password_label.setHorizontalAlignment(SwingConstants.RIGHT);
		new_password_label.setLocation(6, 121);
		new_password_label.setSize(178, 20);
		
		this.new_nickname_field = new JTextField();
		new_nickname_field.setLocation(196, 57);
		new_nickname_field.setSize(215, 20);
		
		this.old_password_field = new JPasswordField();
		old_password_field.setLocation(196, 89);
		old_password_field.setSize(215, 20);
		
		this.new_password_field = new JPasswordField();
		new_password_field.setLocation(196, 121);
		new_password_field.setSize(215, 20);
		
		this.user_settings_cancel = new JButton("Cancel");
		
		user_settings_cancel.setLocation(293, 245);
		user_settings_cancel.setSize(100, 20);
		
		this.user_settings_save = new JButton("Save");
		user_settings_save.setLocation(91, 245);
		user_settings_save.setSize(100, 20);
		this.user_settings_panel.add(this.new_nickname_field);
		this.user_settings_panel.add(this.old_password_field);
		this.user_settings_panel.add(this.new_password_field);
		this.user_settings_panel.add(this.new_nickname_label);
		this.user_settings_panel.add(this.old_password_label);
		this.user_settings_panel.add(this.new_password_label);
		
		this.user_settings_panel.add(this.user_settings_cancel);
		this.user_settings_panel.add(this.user_settings_save);
		
		this.window.getContentPane().add(this.user_settings_panel);
		
		usrimg = new JLabel("New label");
		usrimg.setBounds(123, 180, 61, 16);
		user_settings_panel.add(usrimg);
		
	
		
		
		this.initListeners();
		
	}
	
	public void show(){
		new_nickname_field.setText(null);
		old_password_field.setText(null);
		new_password_field.setText(null);
		this.window.setVisible(true);
	}
	private void initListeners(){
		this.user_settings_cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				hide();
			}
		});
		this.user_settings_save.addActionListener(GUIController.change_usr_settings);
	}
}
