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
import javax.swing.JTextPane;

import oad.session;

import javax.swing.SwingConstants;

import java.awt.Font;

public class FeedbackWindow extends Window {
	//elements
	
	
	//panel
	
	private JPanel feedback_panel;
	
	
	//labels
	
	private JLabel feedback_name_label;
	private JLabel feedback_titel_label;
	private JLabel feedback_message_label;
	
	
	//buttons
	
	private JButton feedback_send;
	private JButton feedback_cancel;
	
	
	//fields
	
	private JTextField feedback_name_field;
	private JTextField feedback_titel_field;
	private JTextPane feedback_message_field;
	

	
	//vars
	session current_session;
	
	
	public FeedbackWindow(session input_session){
		//setup vars
		this.current_session = input_session;
		
		//setup frame
		init_without_exit();
		this.setName("Feedback");
		this.setSize(600, 425);
		this.initSize();
		
		//init elements
		
		this.feedback_panel = new JPanel();
		feedback_panel.setLayout(null);
		
		this.feedback_name_label = new JLabel("Name:");
		feedback_name_label.setHorizontalAlignment(SwingConstants.CENTER);
		feedback_name_label.setLocation(6, 52);
		feedback_name_label.setSize(225, 20);
		
		this.feedback_titel_label = new JLabel("Titel:");
		feedback_titel_label.setHorizontalAlignment(SwingConstants.CENTER);
		feedback_titel_label.setLocation(6, 85);
		feedback_titel_label.setSize(225, 20);
		
		this.feedback_message_label = new JLabel("Message:");
		feedback_message_label.setHorizontalAlignment(SwingConstants.CENTER);
		feedback_message_label.setLocation(6, 117);
		feedback_message_label.setSize(225, 20);
		
		this.feedback_name_field = new JTextField();
		feedback_name_field.setLocation(269, 52);
		feedback_name_field.setSize(325, 20);
		
		this.feedback_titel_field = new JTextField();
		feedback_titel_field.setLocation(269, 85);
		feedback_titel_field.setSize(325, 20);
		
		this.feedback_message_field = new JTextPane();
		feedback_message_field.setLocation(269, 117);
		feedback_message_field.setSize(325, 200);
		
		this.feedback_send = new JButton("Send");
		feedback_send.setLocation(75, 363);
		feedback_send.setSize(100, 20);
		
		this.feedback_cancel = new JButton("Cancel");
		feedback_cancel.setLocation(460, 363);
		feedback_cancel.setSize(100, 20);
		
				
		
		//add elements
		
		this.feedback_panel.add(this.feedback_name_label);
		this.feedback_panel.add(this.feedback_titel_label);
		this.feedback_panel.add(this.feedback_message_label);
		
		this.feedback_panel.add(this.feedback_name_field);
		this.feedback_panel.add(this.feedback_titel_field);
		this.feedback_panel.add(this.feedback_message_field);
		
		this.feedback_panel.add(this.feedback_send);
		this.feedback_panel.add(this.feedback_cancel);
		
		
		this.window.getContentPane().add(this.feedback_panel);
		
		
		
	
		
		
		this.initListeners();
		
	}
	
	private void initListeners()
	{
		this.feedback_cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				feedback_name_field.setText(null);
				feedback_titel_field.setText(null);
				feedback_message_field.setText(null);
				hide();
			}
		});
		this.feedback_send.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				current_session.feedbackhandler.addFeedback(feedback_titel_field.getText(), feedback_message_field.getText());
				hide();
			}
		});
	}
	
	public void show(){
		feedback_name_field.setText(null);
		feedback_titel_field.setText(null);
		feedback_message_field.setText(null);
		this.window.setVisible(true);
	}


		
}
