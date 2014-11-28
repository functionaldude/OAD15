package oadgui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import oad.User;
import oad.session;

public class RegisterWindow extends Window{
	//elements
	//labels
	private JLabel l_title;
	private JLabel l_email;
	private JLabel l_pw;
	//buttons
	private JButton register;
	//textfields
	private JTextField f_email;
	private JPasswordField f_pw;
	//vars
	session current_session;
	User created_user;
	
	RegisterWindow(session input_session){
		//setup vars
		this.current_session = input_session;
		//setup frame
		init();
		this.setName("Login");
		this.setSize(300, 700);
		this.initSize();
		
		//init elements
		this.l_title = new JLabel("REGISTER");
		this.l_email = new JLabel("E-Mail:");
		this.l_pw = new JLabel("Password");
		this.register = new JButton("Register");
		this.f_email = new JTextField();
		this.f_pw = new JPasswordField();
		
		//add elements
		this.window.add(this.l_title);
		this.window.add(this.l_email);
		this.window.add(this.l_pw);
		this.window.add(this.register);
		this.window.add(this.f_email);
		this.window.add(this.f_pw);
		
		this.initListeners();
	}
	
	private void initListeners(){
		this.register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				created_user = new User(f_email.toString(), f_pw.toString());
			}
		});
	}
}
