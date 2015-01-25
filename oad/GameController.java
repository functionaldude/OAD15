package oad;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;

import oadgui.GamePanel;

public class GameController {
	public static game current_game;
	public static session sessionvar;
	public static int current_tool = 0;
	public static GamePanel current_panel;
	
	//gui vars
	private static int radius = 10;
	private static int line_state = 0;
	private static Connection current_con = null;
	
	public GameController(session input){
		sessionvar = input;
	}	
		
	public static void drawGame(GamePanel panel, Graphics g){
		if(current_game == null || current_game.circles.size() == 0){
			return;
		}
		Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.blue);

        Iterator<Point> circle_iter = current_game.circles.iterator();
        Point circle = null;
        while(circle_iter.hasNext()){
        	circle = circle_iter.next();
            g2d.fillOval(circle.x - radius, circle.y - radius, radius * 2, radius * 2);
        }
        Iterator<Connection>conn_iter = current_game.lines.iterator();
        Connection line = null;
        while(conn_iter.hasNext()){
        	line = conn_iter.next();
        	g2d.drawLine(line.getBegin().x, line.getBegin().y, line.getEnd().x, line.getEnd().y);
        }
	}
	public static Point getNearestPoint(int x, int y){
		Point input = new Point(x,y);
		Point retval = null;
		Point in_list = null;
		double distance = 1000;
		Iterator<Point> it = current_game.circles.iterator();
		while(it.hasNext()){
			in_list = it.next();
			if(input.distance(in_list) < distance){
				distance = input.distance(in_list);
				retval = in_list;
			}
		}
		return retval;
	}
	
	//listeners
	
	//editor mouse
	public static MouseListener editor_click = new MouseListener(){

		@Override
		public void mouseClicked(MouseEvent e) {
			if(current_tool == 1)
			{
				System.out.println("Mouse Clicked (Circle): ("+e.getX()+", "+e.getY() +")");
				current_game.addCircle(e.getX(), e.getY());
				current_panel.repaint();
									
			}
			else if(current_tool == 2)
			{
				System.out.println("Mouse Clicked (Connection): ("+e.getX()+", "+e.getY() +")");
				if(line_state == 0){
					current_con = new Connection(null, null);
					current_con.setBegin(getNearestPoint(e.getX(), e.getY()));
					line_state = 1;
				}
				else if(line_state == 1){
					current_con.setEnd(getNearestPoint(e.getX(), e.getY()));
					current_game.addLine(current_con);
					current_con = null;
					line_state = 0;
					current_panel.repaint();
				}
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
