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

import oad.session;

import javax.swing.SwingConstants;

import java.awt.Font;

public class UserSettingWindow extends Window {
	//elements
	
	
	//panel
	
	private JPanel user_settings_panel;
	
	
	//labels
	
	private JLabel old_nickname_label;
	private JLabel new_nickname_label;
	private JLabel old_password_label;
	private JLabel new_password_label;
	
	
	//buttons
	
	private JButton user_settings_cancel;
	private JButton user_settings_save;
	
	
	
	//fields
	private JTextField old_nickname_field;
	private JTextField new_nickname_field;
	private JPasswordField old_password_field;
	private JPasswordField new_password_field;
	
	
	
	
		
	
	//vars
	session current_session;
	
	
	public UserSettingWindow(session input_session){
		//setup vars
		this.current_session = input_session;
		
		//setup frame
		init_without_exit();
		this.setName("User Settings");
		this.setSize(450, 300);
		this.initSize();
		
		//init elements
		
		this.user_settings_panel = new JPanel();
		user_settings_panel.setLayout(null);
		
		this.old_nickname_label = new JLabel("Old nickname:");
		old_nickname_label.setHorizontalAlignment(SwingConstants.RIGHT);
		old_nickname_label.setLocation(0, 25);
		old_nickname_label.setSize(215, 20);
		
		this.new_nickname_label = new JLabel("New nickname:");
		new_nickname_label.setHorizontalAlignment(SwingConstants.RIGHT);
		new_nickname_label.setLocation(2, 57);
		new_nickname_label.setSize(215, 20);
		
		this.old_password_label = new JLabel("Old password:");
		old_password_label.setHorizontalAlignment(SwingConstants.RIGHT);
		old_password_label.setLocation(0, 89);
		old_password_label.setSize(215, 20);
		
		this.new_password_label = new JLabel("New password:");
		new_password_label.setHorizontalAlignment(SwingConstants.RIGHT);
		new_password_label.setLocation(0, 121);
		new_password_label.setSize(215, 20);
		
		this.old_nickname_field = new JTextField();
		old_nickname_field.setSize(215, 20);
		old_nickname_field.setLocation(229, 25);
		
		this.new_nickname_field = new JTextField();
		new_nickname_field.setLocation(229, 57);
		new_nickname_field.setSize(215, 20);
		
		this.old_password_field = new JPasswordField();
		old_password_field.setLocation(229, 89);
		old_password_field.setSize(215, 20);
		
		this.new_password_field = new JPasswordField();
		new_password_field.setLocation(229, 121);
		new_password_field.setSize(215, 20);
		
		this.user_settings_cancel = new JButton("Cancel");
		
		user_settings_cancel.setLocation(293, 245);
		user_settings_cancel.setSize(100, 20);
		
		this.user_settings_save = new JButton("Save");
		user_settings_save.setLocation(91, 245);
		user_settings_save.setSize(100, 20);
		
				
		
		//add elements
		
		this.user_settings_panel.add(this.old_nickname_field);
		this.user_settings_panel.add(this.new_nickname_field);
		this.user_settings_panel.add(this.old_password_field);
		this.user_settings_panel.add(this.new_password_field);
		
		this.user_settings_panel.add(this.old_nickname_label);
		this.user_settings_panel.add(this.new_nickname_label);
		this.user_settings_panel.add(this.old_password_label);
		this.user_settings_panel.add(this.new_password_label);
		
		this.user_settings_panel.add(this.user_settings_cancel);
		this.user_settings_panel.add(this.user_settings_save);
		
		this.window.getContentPane().add(this.user_settings_panel);
		
	
		
		
		this.initListeners();
		
	}
	
	public void show(){
		old_nickname_field.setText(null);
		new_nickname_field.setText(null);
		old_password_field.setText(null);
		new_password_field.setText(null);
		this.window.setVisible(true);
	}
	private void initListeners(){
		this.user_settings_cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				old_nickname_field.setText(null);
				new_nickname_field.setText(null);
				old_password_field.setText(null);
				new_password_field.setText(null);
				hide();
			}
		});
		this.user_settings_save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				String old_pw = new String(old_password_field.getPassword());
				if (current_session.getUser().checkPW(old_pw)){
					if(!new_nickname_field.getText().isEmpty()){
						String new_username = new_nickname_field.getText();
						if(current_session.checkForUser(new_username)){
							//TODO: username taken
						} else {
							current_session.getUser().changeUserName(new_username);
						}
					}
					if (! new String(new_password_field.getPassword()).isEmpty()){
						current_session.getUser().changePW(new String(new_password_field.getPassword()));
					}
					current_session.syncBackUserData();
					hide();
				} else {
					//TODO: invalid pw
				}
			}
		});
	}
}
