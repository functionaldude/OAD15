package oad;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import oadgui.GamePanel;

public class GameController {
	public static game current_game;
	public static session sessionvar;
	public static int current_tool = 0;
	
	//guivars
	private static int radius = 5;
	
	public GameController(session input){
		sessionvar = input;
	}	
	
	public static void drawGame(GamePanel panel, Graphics g){
		Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.blue);

        Dimension size = panel.getSize();
        Insets insets = panel.getInsets();

        int w = size.width - insets.left - insets.right;
        int h = size.height - insets.top - insets.bottom;
        
        g2d.drawOval(230 - radius, 300 - radius, radius * 2, radius * 2);
	}
	
	//listeners
	
	//editor mouse
	public static MouseListener editor_click = new MouseListener(){

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(current_tool == 1)
			{
				System.out.println("Mouse Clicked (Circle): ("+e.getX()+", "+e.getY() +")");
									
			}
			else if(current_tool == 2)
			{
				System.out.println("Mouse Clicked (Connection): ("+e.getX()+", "+e.getY() +")");
			}
			else
			{
				System.out.println("Mouse Clicked (Figure): ("+e.getX()+", "+e.getY() +")");
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	};
}
