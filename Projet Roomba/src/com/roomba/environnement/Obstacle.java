package com.roomba.environnement;

import java.awt.Color;
import java.awt.Graphics2D;

import com.roomba.shape.Forme;

/**
 * Represents the obstacles in the environment that can't be traversed by the robot
 * @author Lucas
 *
 */
public class Obstacle {

	protected Forme forme;

	public Obstacle(Forme forme) {
		this.forme = forme;
	}

	public Forme getForme() {
		return forme;
	}

	public void setForme(Forme forme) {
		this.forme = forme;
	}

	/**
	 * paint the obstacle
	 * @param g2 grachics2d object that represent the window
	 * @param facteurEchelle ration between actual size and pixels
	 * @param centrex x-position of the obstacle
	 * @param centrey y-position of the obstacle
	 */
	public void paint(Graphics2D g2, int facteurEchelle, int centrex,
			int centrey) {
		g2.setColor(Color.LIGHT_GRAY);
		forme.paint(g2, facteurEchelle, centrex, centrey);
		g2.setColor(Color.BLACK);
		forme.draw(g2, facteurEchelle, centrex, centrey);
	}

}
