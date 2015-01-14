package oadgui;

import java.awt.Graphics;
import javax.swing.JPanel;

import oad.GameController;

public class GamePanel extends JPanel {
	
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    	GameController.drawGame(this, g);
    }
}
