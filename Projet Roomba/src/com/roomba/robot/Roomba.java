package com.roomba.robot;


import com.roomba.roombautil.PostureRobot;
import com.roomba.shape.*;
import com.roomba.comportement.Comportement;
import com.roomba.environnement.*;
import com.roomba.exception.ExceptionVitesseMax;

/**
 * Configures a roomba-type robot with the actual dimensions and sensors
 * @author Lucas
 *
 */
public class Roomba extends Robot {

	protected double diametre;

	public Roomba(double diametre, Comportement comportement) {
		super(new Cercle(0, 0, 0, diametre));
		setDiametre(diametre);
		posture = new PostureRobot(0, 0, 0);

		this.roues.add(new Roue());
		this.roues.add(new Roue());

		this.capteurs.add(new CapteurContactObstacle(new Cercle(0.06, 0.06, 0,
				0.20)));
		this.capteurs.add(new CapteurContactObstacle(new Cercle(0.06, 0, 0,
				0.24)));
		this.capteurs.add(new CapteurContactObstacle(new Cercle(0.06, -0.06, 0,
				0.20)));
		this.capteurs.add(new CapteurContactTache(new Cercle(0, 0, 0, 0.195),
				0.05));

		this.comportement = comportement;

		for (Capteur x : capteurs)
			x.setPosRel(posture.getPosition());
	}

	public double getDiametre() {
		return diametre;
	}

	public void setDiametre(double diametre) {
		this.diametre = diametre;
	}

	public void move(double to, Environnement environ) {
		for (Capteur x : capteurs)
			x.miseAjour(environ);
		comportement.calcul(capteurs);
		this.calculVitesseRoue();
		posture.move(roues.get(0).getVitesse() * to, roues.get(1).getVitesse()
				* to, diametre);
		forme.setPosture(posture);
		for (Capteur x : capteurs)
			x.setPosition(x.getPosRel(), posture);
	}

	public void calculVitesseRoue() {
		setVitesseRoue1(comportement.vitesseRoueR());
		setVitesseRoue2(comportement.vitesseRoueL());
	}

	public String toString() {
		return String.valueOf(posture.getX()) + " "
				+ String.valueOf(posture.getY()) + " "
				+ String.valueOf(posture.getTheta());
	}

	private void setVitesseRoue1(double vitesse) {

		try {
			roues.get(0).setVitesse(vitesse);
		} catch (ExceptionVitesseMax e) {
			System.out.println("Vitesse max depassee");
			e.printStackTrace();
		}
	}

	private void setVitesseRoue2(double vitesse) {

		try {
			roues.get(1).setVitesse(vitesse);
		} catch (ExceptionVitesseMax e) {
			System.out.println("Vitesse max depassee");
			e.printStackTrace();
		}
	}

	public int getDiametrePix(int facteurEchelle) {
		return (int) (facteurEchelle * diametre);
	}

	public int getPosxPix(int facteurEchelle) {
		return (int) (posture.getX() * facteurEchelle);
	}

	public int getPosyPix(int facteurEchelle) {
		return (int) (posture.getY() * facteurEchelle);
	}

	/**
	 * add a sensor to the robot
	 * @param capteur
	 */
	public void addCapteur(Capteur capteur) {
		capteurs.add(capteur);
		capteur.setPosRel(posture.getPosition());
	}

}
