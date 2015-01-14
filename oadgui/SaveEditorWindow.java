package oadgui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import oad.GUIController;
import oad.session;

import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.border.LineBorder;

import java.awt.Color;

public class SaveEditorWindow extends Window {
	//elements
	
	
	//panel	
	
	private JPanel editor_save_panel;
	
	
	//labels
	
	private JLabel editor_privacy_label;
	private JLabel editor_titel_label;
	private JLabel editor_description_label;

	
	//buttons
	
	private JButton editor_save_button;
	private JButton editor_cancel_button;
	
	//ComboBox
	
	public JComboBox editor_privacy_list;
	
	public JTextField editor_title_field;
	
	public JTextArea editor_description_field;
	
	String[] privacy = {"Private Game", "Public Game"};
		

	
	public SaveEditorWindow(){

		
		//setup frame
		init_without_exit();
		this.setName("That Is A New Game");
		this.setSize(450, 300);
		this.initSize();
		
		//init elements
		
		this.editor_save_panel = new JPanel();
		editor_save_panel.setLayout(null);

		
		this.editor_privacy_label = new JLabel("Privacy:");
		editor_privacy_label.setHorizontalAlignment(SwingConstants.CENTER);
		editor_privacy_label.setLocation(6, 29);
		editor_privacy_label.setSize(200, 20);
		this.editor_description_label = new JLabel("Description:");
		editor_description_label.setHorizontalAlignment(SwingConstants.CENTER);
		editor_description_label.setLocation(6, 93);
		editor_description_label.setSize(200, 20);
		this.editor_titel_label = new JLabel("Title:");
		editor_titel_label.setHorizontalAlignment(SwingConstants.CENTER);
		editor_titel_label.setLocation(6, 61);
		editor_titel_label.setSize(200, 20);
		
		this.editor_save_button = new JButton("Save");
		editor_save_button.setLocation(52, 245);
		editor_save_button.setSize(100, 20);
		this.editor_cancel_button = new JButton("Cancel");
		editor_cancel_button.setLocation(274, 245);
		editor_cancel_button.setSize(100, 20);
		
		this.editor_privacy_list = new JComboBox(privacy);
		editor_privacy_list.setLocation(244, 30);
		editor_privacy_list.setSize(200, 20);
		
		this.editor_title_field = new JTextField();
		editor_title_field.setLocation(244, 61);
		editor_title_field.setSize(200, 20);
		this.editor_description_field = new JTextArea();
		editor_description_field.setLocation(244, 93);
		editor_description_field.setSize(200, 125);
		
				
		
		//add elements
		
		
		this.editor_save_panel.add(this.editor_privacy_label);
		this.editor_save_panel.add(this.editor_titel_label);
		this.editor_save_panel.add(this.editor_description_label);
		this.editor_save_panel.add(this.editor_save_button);
		this.editor_save_panel.add(this.editor_cancel_button);
		this.editor_save_panel.add(this.editor_privacy_list);
		this.editor_save_panel.add(this.editor_title_field);
		this.editor_save_panel.add(this.editor_description_field);
		
		
		
		this.window.getContentPane().add(this.editor_save_panel);
		
		this.initListeners();
		
	}
	
	
	private void initListeners()
	{	
		this.editor_save_button.addActionListener(GUIController.editor_save);
	}



		
}
