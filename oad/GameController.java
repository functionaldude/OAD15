package oad;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import oadgui.GamePanel;

public class GameController {
	public static game current_game;
	public static session sessionvar;
	public static int current_tool = 0;
	public static GamePanel current_panel;
	
	//guivars
	private static int radius = 6;
	
	public GameController(session input){
		sessionvar = input;
	}	
		
	public static void drawGame(GamePanel panel, Graphics g){
		if(current_game == null || current_game.circles.size() == 0){
			return;
		}
		Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.blue);

        Iterator<Coordinate> circle_iter = current_game.circles.iterator();
        Coordinate circle = null;
        while(circle_iter.hasNext()){
        	circle = circle_iter.next();
            g2d.drawOval(circle.getX() - radius, circle.getY() - radius, radius * 2, radius * 2);
        }
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
				current_game.addCircle(e.getX(), e.getY());
				current_panel.repaint();
									
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
