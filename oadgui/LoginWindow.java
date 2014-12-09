package oadgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import oad.GUIController;
import oad.session;

import java.awt.Font;


public class LoginWindow extends Window{
	//elemente
	
	//labels
	private JLabel l_title;
	private JLabel l_email;
	private JLabel l_pw;
	
	//buttons
	private JButton login;
	private JButton register;
	private JButton reset_password;
	
	//textfields
	public JTextField f_email;
	public JPasswordField f_pw;
	
	private JPanel l_panel;
	
	//vars
	session current_session;
	
	public LoginWindow(){

		//setup frame
		init();
		this.setName("Welcome");
		this.setSize(450, 300);
		this.initSize();
		
		//setup elements
		this.l_panel = new JPanel();
		
		this.l_title = new JLabel("Welcome");
		l_title.setHorizontalAlignment(SwingConstants.CENTER);
		l_title.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		l_title.setBounds(6, 6, 438, 20);
		
		this.l_email = new JLabel("Nickname:");
		l_email.setHorizontalAlignment(SwingConstants.RIGHT);
		l_email.setBounds(6, 100, 158, 20);
		
		this.l_pw = new JLabel("Password:");
		l_pw.setHorizontalAlignment(SwingConstants.RIGHT);
		l_pw.setBounds(6, 153, 158, 20);
		
		this.login = new JButton("Login");
		login.setBounds(6, 235, 140, 20);
		
		this.register = new JButton("Register");
		register.setBounds(158, 235, 140, 20);
		
		this.reset_password = new JButton("Reset Password");
		reset_password.setLocation(304, 235);
		reset_password.setSize(140, 20);
		
		
		this.f_email = new JTextField();
		f_email.setBounds(238, 100, 140, 20);
		
		this.f_pw = new JPasswordField();
		f_pw.setBounds(238, 153, 140, 20);
		
		l_panel.setLayout(null);
		
		//l_panel.setLayout(null);
		
		
		//add elements
		this.l_panel.add(this.l_title);
		this.l_panel.add(this.l_email);
		this.l_panel.add(this.l_pw);
		this.l_panel.add(this.login);
		this.l_panel.add(this.register);
		this.l_panel.add(this.f_email);
		this.l_panel.add(this.f_pw);
		this.l_panel.add(this.reset_password);
		
		this.window.getContentPane().add(this.l_panel);
		
		this.initListeners();
	}
	
	private void initListeners(){
		this.login.addActionListener(GUIController.login);
		this.register.addActionListener(GUIController.open_register);
		this.reset_password.addActionListener(GUIController.open_reset_pw);
	}
	
}
