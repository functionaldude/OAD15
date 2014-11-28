package oadgui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import oad.MonitorObject;


public abstract class Window{
	//attribute
	public JFrame window;
	public MonitorObject visiblity = new MonitorObject();
	
	private int width = 0, height = 0;
		
	//functions
	public void setSize(int width, int height){
		this.height = height;
		this.width = width;
	}
	public void setName(String input){
		this.window.setTitle(input);
	}
	
	public void init(){
		//create frame
		this.window = new JFrame();
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void initSize(){
		//set size
		Toolkit t = Toolkit.getDefaultToolkit();
		Dimension d = t.getScreenSize();
		int x = (int) ((d.getWidth() - this.width) / 2);
		int y = (int) ((d.getHeight() - this.height) / 2);
		this.window.setBounds(x, y, this.width, this.height);
	}
	
	public void show(){
		this.window.setVisible(true);
	}
	public void hide(){
		this.window.setVisible(false);
	}
	public void add(Component obj){
		this.window.add(obj);
	}
}
