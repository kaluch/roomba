package roomba;

import java.awt.Graphics2D;

public abstract class Capteur {

	protected Forme forme;
	protected Polair posRel;

	/**
	 * update the current state of the sensor
	 * @param environ environment in which the robot is evolving
	 */
	abstract public void miseAjour(Environnement environ);

	/**
	 * 
	 * @return the state of the sensor
	 */
	abstract public double lecture();

	Capteur(Forme forme) {
		this.forme = forme;
		posRel = new Polair();

	}

	/**
	 * setter for the position relative to an origin
	 * @param origine for the position
	 */
	protected void setPosRel(Vecteur origine) {
		posRel.setTheta(forme.getPosture().getPosition().angle()
				- origine.angle());
		posRel.setRho(Math.sqrt(Math.pow(((Vecteur2D) forme.getPosture()
				.getPosition()).getX() - ((Vecteur2D) origine).getX(), 2)
				+ Math.pow(
						((Vecteur2D) forme.getPosture().getPosition()).getY()
								- ((Vecteur2D) origine).getY(), 2)));
	}

	public Polair getPosRel() {
		return posRel;
	}

	public void setPosRel(Polair posRel) {
		this.posRel = posRel;
	}

	public void setForme(Forme forme) {
		this.forme = forme;
	}

	public Forme getForme() {
		return forme;
	}

	protected int getPosxPix(int facteurEchelle) {
		return (int) (((Vecteur2D) forme.getPosture().getPosition()).getX() * facteurEchelle);
	}

	protected int getPosyPix(int facteurEchelle) {
		return (int) (((Vecteur2D) forme.getPosture().getPosition()).getY() * facteurEchelle);
	}

	protected void setPosition(Polair posRel, Posture origine) {
		forme.getPosture().setX(
				origine.getX() + posRel.getRho()
						* Math.cos(posRel.getTheta() + origine.getTheta()));
		forme.getPosture().setY(
				origine.getY() + posRel.getRho()
						* Math.sin(posRel.getTheta() + origine.getTheta()));
	}

	/**
	 * draw the sensor
	 * @param g2 relative to the window
	 * @param facteurEchelle defines the ratio between actual size and pixels
	 * @param centrex x-position of the center of the sensor
	 * @param centrey y-position of the center of the sensor
	 */
	abstract public void draw(Graphics2D g2, int facteurEchelle, int centrex,
			int centrey);

}
