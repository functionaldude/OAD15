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

public class AboutUsWindow extends Window {
	//elements
	
	
	//panel	
	
	private JPanel about_us_panel;
	
	//labels
	
	
	//buttons
	
	private JButton about_us_ok;
	
	
	
	
	//fields
	
	private JTextPane user1;
	private JTextPane user2;
	private JTextPane user3;
	private JTextPane user4;
	private JTextPane user5;
	private JTextPane user6;
	
		
	
	//vars
	session current_session;
	
	
	public AboutUsWindow(session input_session){
		//setup vars
		this.current_session = input_session;
		
		//setup frame
		init_without_exit();
		this.setName("About Us");
		this.setSize(600, 310);
		this.initSize();
		
		//init elements
		
		this.about_us_panel = new JPanel();
		about_us_panel.setLayout(null);
		
		this.user1 = new JTextPane();
		user1.setLocation(6, 6);
		user1.setSize(200, 60);
		user1.setBorder(BorderFactory.createRaisedBevelBorder());
		user1.setText("Martin Zagar\nProject Manager\nmartin.zagar@student.tugraz.at");
		user1.setEditable(false);
	
		this.user2 = new JTextPane();
		user2.setLocation(6, 72);
		user2.setSize(200, 60);
		user2.setBorder(BorderFactory.createRaisedBevelBorder());
		user2.setText("Zoltan Sasvari\nDeveloper\nz.sasvari@student.tugraz.at");
		user2.setEditable(false);
		
		this.user3 = new JTextPane();
		user3.setLocation(6, 144);
		user3.setSize(200, 60);
		user3.setBorder(BorderFactory.createRaisedBevelBorder());
		user3.setText("Alexander Walter Grass\nTester\ngrass@student.tugraz.at");
		user3.setEditable(false);
		
		this.user4 = new JTextPane();
		user4.setLocation(394, 6);
		user4.setSize(200, 60);
		user4.setBorder(BorderFactory.createRaisedBevelBorder());
		user4.setText("Islam Hemida\nUsability\nhemida@student.tugraz.at");
		user4.setEditable(false);
		
		this.user5 = new JTextPane();
		user5.setLocation(394, 72);
		user5.setSize(200, 60);
		user5.setBorder(BorderFactory.createRaisedBevelBorder());
		user5.setText("Amel Hamidovic\nAnalyst\nhamidovic@student.tugraz.at");
		user5.setEditable(false);
		
		this.user6 = new JTextPane();
		user6.setLocation(394, 144);
		user6.setSize(200, 60);
		user6.setBorder(BorderFactory.createRaisedBevelBorder());
		user6.setText("Adam Ujvari\nAnalyst\nadam.ujvari@student.tugraz.at");
		user6.setEditable(false);
		
		
		this.about_us_ok = new JButton("OK");
		about_us_ok.setLocation(250, 249);
		about_us_ok.setSize(100, 20);
		
				
		
		//add elements
		
		this.about_us_panel.add(this.user1);
		this.about_us_panel.add(this.user2);
		this.about_us_panel.add(this.user3);
		this.about_us_panel.add(this.user4);
		this.about_us_panel.add(this.user5);
		this.about_us_panel.add(this.user6);
		
		this.about_us_panel.add(this.about_us_ok);
		
		
		
		this.window.getContentPane().add(this.about_us_panel);
		
		
		this.initListeners();
		
	}
	
	private void initListeners()
	{
		this.about_us_ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				hide();
			}
		});
	}



		
}
