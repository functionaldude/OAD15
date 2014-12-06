package oadgui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

import oad.session;

import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class AboutUsWindow extends Window {
	//elements
	
	
	//panel	
	
	private JPanel about_us_panel;
	
	private JPanel user_panel;
	
	private JPanel user1;
	private JPanel user2;
	private JPanel user3;
	private JPanel user4;
	private JPanel user5;
	private JPanel user6;
	
	//labels
	
	private JLabel user1_name;
	private JLabel user1_function;
	private JLabel user1_email;
	
	private JLabel user2_name;
	private JLabel user2_function;
	private JLabel user2_email;
	
	private JLabel user3_name;
	private JLabel user3_function;
	private JLabel user3_email;
	
	private JLabel user4_name;
	private JLabel user4_function;
	private JLabel user4_email;
	
	private JLabel user5_name;
	private JLabel user5_function;
	private JLabel user5_email;
	
	private JLabel user6_name;
	private JLabel user6_function;
	private JLabel user6_email;
	
	
	
	//buttons
	
	private JButton about_us_ok;
	
	
	
	
	//fields
	
		
	
	//vars
	session current_session;
	
	
	public AboutUsWindow(session input_session){
		//setup vars
		this.current_session = input_session;
		
		//setup frame
		init_without_exit();
		this.setName("User Settings");
		this.setSize(600, 400);
		this.initSize();
		
		//init elements
		
		this.about_us_panel = new JPanel(new BorderLayout(0, 0));
		
		this.user_panel = new JPanel();
		user_panel.setLayout(new BoxLayout(user_panel, BoxLayout.PAGE_AXIS));
		
		this.user1 = new JPanel();
		user1.setLayout(new BoxLayout(user1, BoxLayout.PAGE_AXIS));
		user1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		this.user2 = new JPanel();
		user2.setLayout(new BoxLayout(user2, BoxLayout.PAGE_AXIS));
		user2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		this.user3 = new JPanel();
		user3.setLayout(new BoxLayout(user3, BoxLayout.PAGE_AXIS));
		user3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		this.user4 = new JPanel();
		user4.setLayout(new BoxLayout(user4, BoxLayout.PAGE_AXIS));
		user4.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		this.user5 = new JPanel();
		user5.setLayout(new BoxLayout(user5, BoxLayout.PAGE_AXIS));
		user5.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		this.user6 = new JPanel();
		user6.setLayout(new BoxLayout(user6, BoxLayout.PAGE_AXIS));
		user6.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		
		this.user1_name = new JLabel("Martin Zagar");
		this.user1_function = new JLabel("Project Manager");
		this.user1_email = new JLabel("martin.zagar@student.tugraz.at");
		
		this.user2_name = new JLabel("Zoltan Sasvari");
		this.user2_function = new JLabel("Developer");
		this.user2_email = new JLabel("z.sasvari@student.tugraz.at");
		
		this.user3_name = new JLabel("Alexander Walter Grass");
		this.user3_function = new JLabel("Tester");
		this.user3_email = new JLabel("grass@student.tugraz.at");
		
		this.user4_name = new JLabel("Islam Hemida");
		this.user4_function = new JLabel("Usability");
		this.user4_email = new JLabel("hemida@student.tugraz.at");
		
		this.user5_name = new JLabel("Amel Hamidovic");
		this.user5_function = new JLabel("Analyst");
		this.user5_email = new JLabel("hamidovic@student.tugraz.at");
		
		this.user6_name = new JLabel("Adam Ujvari");
		this.user6_function = new JLabel("Analyst");
		this.user6_email = new JLabel("adam.ujvari@student.tugraz.at");
		
		this.about_us_ok = new JButton("OK");
		
				
		
		//add elements
		
		this.user1.add(this.user1_name);
		this.user1.add(this.user1_function);
		this.user1.add(this.user1_email);
		
		this.user2.add(this.user2_name);
		this.user2.add(this.user2_function);
		this.user2.add(this.user2_email);
		
		this.user3.add(this.user3_name);
		this.user3.add(this.user3_function);
		this.user3.add(this.user3_email);
		
		this.user4.add(this.user4_name);
		this.user4.add(this.user4_function);
		this.user4.add(this.user4_email);
		
		this.user5.add(this.user5_name);
		this.user5.add(this.user5_function);
		this.user5.add(this.user5_email);
		
		this.user6.add(this.user6_name);
		this.user6.add(this.user6_function);
		this.user6.add(this.user6_email);
		
		this.user_panel.add(this.user1);
		this.user_panel.add(this.user2);
		this.user_panel.add(this.user3);
		this.user_panel.add(this.user4);
		this.user_panel.add(this.user5);
		this.user_panel.add(this.user6);
		
		this.about_us_panel.add(this.about_us_ok, BorderLayout.SOUTH);
		this.about_us_panel.add(this.user_panel, BorderLayout.CENTER);
		
		
		this.window.getContentPane().add(this.about_us_panel);
		
		
		//this.initListeners();
		
	}
	
	/*private void initListeners()
	{
		
		
	
	}*/



		
}
