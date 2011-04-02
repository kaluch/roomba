package com.roomba.roombautil;

/**
 * represent a point (x,y)
 * @author Lucas
 *
 */
public class Vecteur{

	protected double x;
	protected double y;

	public Vecteur() {
		x = 0;
		y = 0;
	}

	public Vecteur(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Vecteur(Vecteur position) {
		x = position.getX();
		y = position.getY();
	}

	public double norme() {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String toString() {
		return x + " " + y;
	}

	public double angle() {
		return Math.atan2(y, x);
	}

	public Vecteur plus(Vecteur vecteur) {
		return new Vecteur(x + vecteur.getX(), y + vecteur.getY());
	}

	public Vecteur moins(Vecteur vecteur) {
		return new Vecteur(x - vecteur.getX(), y - vecteur.getY());
	}

	public double pScal(Vecteur vecteur) {
		return (x * vecteur.getX() + y * vecteur.getY());
	}

	public double det(Vecteur vecteur) {
		return (x * vecteur.getY() - y * vecteur.getX());
	}

}
