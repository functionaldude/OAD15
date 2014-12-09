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
import javax.swing.DropMode;
import javax.swing.JTextPane;

public class ContactWindow extends Window {
	//elements
	
	
	//panel
	
	private JPanel contact_window_panel;
	
	
	
	//labels
	
	private JLabel contact_name_label;
	private JLabel contact_mail_label;
	private JLabel contact_type_label;
	private JLabel contact_message_label;
	
	//buttons
	
	private JButton contact_send;
	private JButton contact_cancel;
	
	
	//fields
	
	private JTextField contact_name_field;
	private JTextField contact_mail_field;
	private JTextPane contact_message_field;
	private JComboBox<Object> contact_type_box;
	
	//string
	String errors[] = {"Bugs", "Question about the game", "Question about the editor"};
	
	

	
	
	public ContactWindow(){
		
		//setup frame
		init_without_exit();
		this.setName("Contact Window");
		this.setSize(450, 400);
		this.initSize();
		
		//init elements
		
		this.contact_window_panel = new JPanel();
		contact_window_panel.setLayout(null);
		
		
		
		this.contact_name_label = new JLabel("Name:");
		contact_name_label.setHorizontalAlignment(SwingConstants.CENTER);
		contact_name_label.setLocation(0, 52);
		contact_name_label.setSize(215, 20);
		
		this.contact_mail_label = new JLabel("Email:");
		contact_mail_label.setHorizontalAlignment(SwingConstants.CENTER);
		contact_mail_label.setLocation(0, 81);
		contact_mail_label.setSize(215, 20);
		
		this.contact_type_label = new JLabel("Type:");
		contact_type_label.setHorizontalAlignment(SwingConstants.CENTER);
		contact_type_label.setLocation(0, 116);
		contact_type_label.setSize(215, 20);
		
		this.contact_message_label = new JLabel("Message:");
		contact_message_label.setHorizontalAlignment(SwingConstants.CENTER);
		contact_message_label.setLocation(0, 148);
		contact_message_label.setSize(215, 20);
		
		this.contact_name_field = new JTextField();
		contact_name_field.setLocation(229, 52);
		contact_name_field.setSize(215, 20);
		
		this.contact_mail_field = new JTextField();
		contact_mail_field.setLocation(229, 81);
		contact_mail_field.setSize(215, 20);
		
		this.contact_type_box = new JComboBox<Object>(errors);
		contact_type_box.setLocation(229, 117);
		contact_type_box.setSize(215, 20);
		
		this.contact_message_field = new JTextPane();
		contact_message_field.setBounds(229, 149, 217, 123);
		
		this.contact_send = new JButton("Send");
		contact_send.setLocation(63, 344);
		contact_send.setSize(100, 20);
		
		this.contact_cancel = new JButton("Cancel");
		contact_cancel.setLocation(307, 344);
		contact_cancel.setSize(100, 20);
		
		
				
		
		//add elements
		
		this.contact_window_panel.add(this.contact_name_label);
		this.contact_window_panel.add(this.contact_mail_label);
		this.contact_window_panel.add(this.contact_type_label);
		this.contact_window_panel.add(this.contact_message_label);
		
		this.contact_window_panel.add(this.contact_name_field);
		this.contact_window_panel.add(this.contact_mail_field);
		this.contact_window_panel.add(this.contact_type_box);
		this.contact_window_panel.add(this.contact_message_field);
		
		this.contact_window_panel.add(this.contact_send);
		this.contact_window_panel.add(this.contact_cancel);
		
		/*this.contact_window_panel.add(this.contact_window_label_panel, BorderLayout.WES);
		this.contact_window_panel.add(this.contact_window_field_panel, BorderLayout.EAST);
		this.contact_window_panel.add(this.contact_window_button_panel, BorderLayout.SOUTH);*/
		
		this.window.getContentPane().add(this.contact_window_panel);
		

		
		//this.initListeners();
		
	}
}
