package com.roomba.environnement;

import java.awt.Color;
import java.awt.Graphics2D;

import com.roomba.shape.Forme;

/**
 * The arena represents the workspace for the robot. It can't indeed work out of the arena
 * @author Lucas
 *
 */
public class Arene implements Cloneable {

	protected Forme forme;

	public Arene(Forme forme) {
		this.forme = forme;
	}

	public Forme getForme() {
		return forme;
	}

	public void setForme(Forme forme) {
		this.forme = forme;
	}

	/**
	 * draw the arena
	 * @param g2 Graphics2D object that represents the window
	 * @param facteurEchelle ratio between actual size and pixels
	 * @param centrex x-position of the center of the arena
	 * @param centrey y-position of the center of the arena
	 */
	public void draw(Graphics2D g2, int facteurEchelle, int centrex, int centrey) {
		g2.setColor(Color.BLACK);
		g2.fillRect(-centrex, -centrey, 4 * centrex, 4* centrey);
		g2.setColor(Color.WHITE);
		forme.paint(g2, facteurEchelle, centrex, centrey);
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Arene o = (Arene) super.clone();
		o.forme = (Forme) forme.clone();
		return o;
	}

}
