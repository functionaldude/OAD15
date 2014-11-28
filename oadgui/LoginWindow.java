package oadgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import oad.session;


public class LoginWindow extends Window{
	//elemente
	//labels
	private JLabel l_title;
	private JLabel l_email;
	private JLabel l_pw;
	//buttons
	private JButton login;
	private JButton register;
	//textfields
	private JTextField f_email;
	private JPasswordField f_pw;
	
	//vars
	session current_session;
	
	public LoginWindow(session input_session){
		//setup vars
		this.current_session = input_session;
		//setup frame
		init();
		this.setName("Welcome");
		this.setSize(800, 600);
		this.initSize();
		
		//setup elements
		this.l_title = new JLabel("LOGIN");
		this.l_email = new JLabel("E-Mail:");
		this.l_pw = new JLabel("Password");
		this.login = new JButton("Login");
		this.register = new JButton("Register");
		this.f_email = new JTextField();
		this.f_pw = new JPasswordField();
		
		//TODO!: element design
		
		//add elements
		this.window.add(this.l_title);
		this.window.add(this.l_email);
		this.window.add(this.l_pw);
		this.window.add(this.login);
		this.window.add(this.register);
		this.window.add(this.f_email);
		this.window.add(this.f_pw);
		
		this.initListeners();
	}
	
	private void initListeners(){
		this.login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input_email = f_email.toString();
				String input_pw = f_pw.toString();
				try {
					current_session.authenticate(input_email, input_pw);
				} catch (Exception e1) {
					if (e1.getMessage().equals("InvalidPW")){
						//TODO: Pop-up
					}
					else if (e1.getMessage().equals("NoSuchUser")){
						//TODO: Pop-up
					}
				}
				if (current_session.getLoginState()){
					hide();
				}
			}
		});
		
		this.register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				//TODO: Open register frame
			}
		});
	}
	
}
