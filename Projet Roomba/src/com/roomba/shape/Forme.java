package com.roomba.shape;

import java.awt.Graphics2D;
import com.roomba.roombautil.*;

abstract public class Forme implements Cloneable {

	/*
	 * ATTRIBUTS
	 */

	@Override
	public Object clone() throws CloneNotSupportedException {
		Forme o = (Forme) super.clone();
		o.posture = (Posture) posture.clone();
		return o;
	}

	protected Posture posture;

	/*
	 * METHODES
	 */
	// Constructor
	Forme(double x, double y, double theta) {
		this.posture = new Posture(x, y, theta);
	}

	Forme(Posture posture) {
		this.posture = posture;
	}

	public Posture getPosture() {
		return posture;
	}

	public void setPosture(Posture posture) {
		this.posture = posture;
	}

	/**
	 * paint the shape in the window
	 * 
	 * @param g2
	 * @param facteurEchelle
	 * @param centrex
	 * @param centrey
	 */
	public abstract void paint(Graphics2D g2, int facteurEchelle, int centrex,
			int centrey);

	/**
	 * draw the shape in the window
	 * 
	 * @param g2
	 * @param facteurEchelle
	 * @param centrex
	 * @param centrey
	 */
	public abstract void draw(Graphics2D g2, int facteurEchelle, int centrex,
			int centrey);

	protected int getxPix(int facteurEchelle) {
		return (int) (posture.getX() * facteurEchelle);
	}

	protected int getyPix(int facteurEchelle) {
		return (int) (posture.getY() * facteurEchelle);
	}

	/**
	 * test the external collision between 2 formes
	 * 
	 * @param forme
	 * @return true if forme is in contact with the external outline of the
	 *         current shape. false elsewhere
	 */
	abstract public boolean collisionExterne(Forme forme);

	/**
	 * test the internal collision between 2 formes
	 * 
	 * @param forme
	 * @return true if forme is in contact with the internal outline of the
	 *         current shape. false elsewhere
	 */
	abstract public boolean collisionInterne(Forme forme);

	/**
	 * Set the correct values for X and Y according to facteurEchelle
	 * 
	 * @param facteurEchelle
	 * @return the shape with normalized values
	 */
	public Forme normalize(int facteurEchelle) {
		posture.setX(posture.getX() / facteurEchelle);
		posture.setY(posture.getY() / facteurEchelle);
		return this;
	}

	/**
	 * test if the point belongs to the current shape
	 * 
	 * @param x
	 * @param y
	 * @return true if the point belongs to the current shape
	 */
	abstract public boolean collisionPoint(double x, double y);

	/**
	 * omni-directional isometric of the current shape, factor a
	 * 
	 * @param a
	 */
	abstract public void iso(double a);

	/**
	 * test if the point (x,y) tangents the current shape
	 * 
	 * @param x
	 * @param y
	 * @return true if the point (x,y) tangents the current shape
	 */
	abstract public int tangeantPoint(double x, double y);

}
