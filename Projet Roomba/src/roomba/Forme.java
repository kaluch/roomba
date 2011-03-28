package roomba;

import java.awt.Graphics2D;

abstract public class Forme implements Cloneable {

	/*
	 * ATTRIBUTS
	 */

	@Override
	protected Object clone() throws CloneNotSupportedException {
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

	abstract void paint(Graphics2D g2, int facteurEchelle, int centrex,
			int centrey);

	abstract void draw(Graphics2D g2, int facteurEchelle, int centrex,
			int centrey);

	protected int getxPix(int facteurEchelle) {
		return (int) (posture.getX() * facteurEchelle);
	}

	protected int getyPix(int facteurEchelle) {
		return (int) (posture.getY() * facteurEchelle);
	}

	abstract public boolean collisionExterne(Forme forme);

	abstract public boolean collisionInterne(Forme forme);

	public Forme normalize(int facteurEchelle) {
		posture.setX(posture.getX() / facteurEchelle);
		posture.setY(posture.getY() / facteurEchelle);
		return null;
	}

	abstract public boolean collisionPoint(double x, double y);

	abstract public void iso(double a);

	abstract public int tangeantPoint(double x, double y);

}
