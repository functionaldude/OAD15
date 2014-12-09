package oadgui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import oad.session;

import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.border.LineBorder;

import java.awt.Color;

public class ResetPasswordWindow extends Window {
	//elements
	
	
	//panel	
	
	private JPanel reset_password_panel;
	
	//labels
	
	private JLabel nickname_label;
	private JLabel email_label;
	
	
	//buttons
	
	private JButton reset_password_button;
	private JButton cancel_button;
	
	
	
	
	//fields
	
	private JTextField nickname_field;
	private JTextField email_field;
	

	
	public ResetPasswordWindow(){

		
		//setup frame
		init_without_exit();
		this.setName("Reset Password");
		this.setSize(450, 300);
		this.initSize();
		
		//init elements
		
		this.reset_password_panel = new JPanel();
		reset_password_panel.setLayout(null);
		
		
		this.nickname_label = new JLabel("Nickname:");
		nickname_label.setHorizontalAlignment(SwingConstants.CENTER);
		nickname_label.setLocation(6, 50);
		nickname_label.setSize(200, 20);
		
		this.email_label = new JLabel("Email:");
		email_label.setHorizontalAlignment(SwingConstants.CENTER);
		email_label.setLocation(6, 110);
		email_label.setSize(200, 20);
		
		this.nickname_field = new JTextField();
		nickname_field.setLocation(244, 50);
		nickname_field.setSize(200, 20);
		
		this.email_field = new JTextField();
		email_field.setLocation(244, 110);
		email_field.setSize(200, 20);
		
		this.reset_password_button = new JButton("Reset");
		reset_password_button.setLocation(78, 220);
		reset_password_button.setSize(100, 20);
		
		this.cancel_button = new JButton ("Cancel");
		cancel_button.setLocation(270, 220);
		cancel_button.setSize(100, 20);
		
				
		
		//add elements
		
		this.reset_password_panel.add(this.nickname_label);
		this.reset_password_panel.add(this.email_label);
		this.reset_password_panel.add(this.nickname_field);
		this.reset_password_panel.add(this.email_field);
		this.reset_password_panel.add(this.reset_password_button);
		this.reset_password_panel.add(this.cancel_button);
		
		this.window.getContentPane().add(this.reset_password_panel);
		
		
		nickname_field.setText(null);
		email_field.setText(null);
		
		
		this.initListeners();
		
	}
	
	private void initListeners()
	{
		this.reset_password_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				hide();
			}
		});
		
		this.cancel_button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				nickname_field.setText(null);
				email_field.setText(null);
				hide();
			}
		});
	}



		
}
