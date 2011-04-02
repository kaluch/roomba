package com.roomba.robot;

import java.awt.*;
import javax.swing.*;

// Pour les details sur les fonctions de dessin, voir :
// http://java.sun.com/j2se/1.5.0/docs/api/java/awt/Graphics.html
// voir aussi : http://java.sun.com/docs/books/tutorial/2d/index.html
@SuppressWarnings("serial")
class Move extends JPanel {
	private int x;
	private int prev_x;
	private int y;
	private int prev_y;

	public Move() {
		x = 0;
		y = 0;
	}

	public void moveRobot(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void paint(Graphics g) {
		// on recupere la zone de dessin
		Graphics2D g2 = (Graphics2D) g;
		// on effac une zone un peu plus grande que le cercle
		g2.setColor(Color.white);
		g2.fillRect(prev_x, prev_y, 40, 40);
		// on dessin un disque rouge
		g2.setColor(Color.red);
		g2.fillOval(x, y, 40, 40);
		// on rend la main
		g2.dispose();
		// on retient x,y pour pouvoir effacer au prochain appel
		prev_x = x;
		prev_y = y;
	}

}
