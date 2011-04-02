package com.roomba.robot;

import java.awt.Color;
import java.awt.Graphics2D;

import com.roomba.roombautil.Polair;
import com.roomba.roombautil.Posture;
import com.roomba.roombautil.Vecteur;
import com.roomba.shape.*;
import com.roomba.environnement.*;

public class CapteurDistance extends Capteur {

	protected double distance;
	protected double orientation;

	public CapteurDistance(Forme forme, double orientation) {
		super(forme);
		this.orientation = orientation;
		distance = 10;
	}

	@Override
	public void miseAjour(Environnement environ) {
		double distTemp = 10;
		double distTemp2 = 10;
		double distTemp3 = 10;
		if (environ.getArene().getForme() instanceof Cercle) {
			distTemp2 = contactCercle((Cercle) environ.getArene().getForme());
		} else if (environ.getArene().getForme() instanceof Carre
				|| environ.getArene().getForme() instanceof Rectangle)
			distTemp2 = contactRectangleCarre(environ.getArene().getForme());
		for (Obstacle x : environ.getObstacles()) {
			if (x.getForme() instanceof Cercle)
				distTemp3 = Math.min(distTemp3,
						contactCercle((Cercle) x.getForme()));
			else if (x.getForme() instanceof Carre
					|| x.getForme() instanceof Rectangle)
				distTemp3 = Math.min(distTemp3,
						contactRectangleCarre(x.getForme()));
		}
		distance = Math.min(distTemp, Math.min(distTemp2, distTemp3));
	}

	/**
	 * 
	 * @param forme whose contact is tested
	 * @return the distance between the sensor and the form
	 */
	private double contactRectangleCarre(Forme forme) {
		double distTemp = 10;
		double largeur = 0;
		double hauteur = 0;
		if (forme instanceof Rectangle) {
			largeur = ((Rectangle) forme).getLargeur();
			hauteur = ((Rectangle) forme).getHauteur();
		} else if (forme instanceof Carre) {
			largeur = ((Carre) forme).getCote();
			hauteur = largeur;
		} else
			return distTemp;
		Vecteur O = new Vecteur(this.getForme().getPosture().getX(),
				getForme().getPosture().getY());
		Vecteur P = new Vecteur(this.getForme().getPosture().getX() + 10000
				* Math.cos(this.getForme().getPosture().getTheta()), this
				.getForme().getPosture().getY()
				+ 10000 * Math.sin(this.getForme().getPosture().getTheta()));
		Vecteur A = new Vecteur(forme.getPosture().getX() - largeur / 2,
				forme.getPosture().getY() - hauteur / 2);
		Vecteur B = new Vecteur(forme.getPosture().getX() - largeur / 2,
				forme.getPosture().getY() + hauteur / 2);
		Vecteur C = new Vecteur(forme.getPosture().getX() + largeur / 2,
				forme.getPosture().getY() + hauteur / 2);
		Vecteur D = new Vecteur(forme.getPosture().getX() + largeur / 2,
				forme.getPosture().getY() - hauteur / 2);

		distTemp = Math.min(distTemp, distanceSegSeg(A, B, O, P));
		distTemp = Math.min(distTemp, distanceSegSeg(B, C, O, P));
		distTemp = Math.min(distTemp, distanceSegSeg(C, D, O, P));
		distTemp = Math.min(distTemp, distanceSegSeg(D, A, O, P));
		return distTemp;
	}

	private boolean collisionSegDroite(Vecteur A, Vecteur B, Vecteur O,
			Vecteur P) {
		Vecteur AP = P.moins(A);
		Vecteur AB = B.moins(A);
		Vecteur AO = O.moins(A);
		return (AB.det(AP) * AB.det(AO) >= 0) ? false : true;

	}

	private double distanceSegSeg(Vecteur A, Vecteur B, Vecteur O,
			Vecteur P) {
		if (collisionSegDroite(A, B, O, P) && collisionSegDroite(O, P, A, B)) {
			Vecteur AB = B.moins(A);
			Vecteur OP = P.moins(O);
			double k = -(A.det(OP) - O.det(OP)) / (AB.det(OP));
			if (k > 0 && k < 1)
				return OP.norme() * (AB.det(A) - AB.det(O)) / (AB.det(OP));
		}
		return 1000000;
	}

	private double contactCercle(Cercle cercle) {
		double distTemp = 10;

		Vecteur u = new Vecteur(
				10 * Math.cos(forme.getPosture().getTheta()),
				10 * Math.sin(forme.getPosture().getTheta()));
		Vecteur ac = new Vecteur(cercle.getPosture().getX()
				- forme.getPosture().getX(), cercle.getPosture().getY()
				- forme.getPosture().getY());
		double num = Math.abs(u.getX() * ac.getY() - u.getY() * ac.getX());
		double den = u.norme();
		double ci = num / den;
		if (ci >= cercle.getDiametre() / 2)
			return distTemp;
		else {
			Vecteur bc = new Vecteur(cercle.getPosture().getX()
					- forme.getPosture().getX() + 1000
					* Math.cos(forme.getPosture().getTheta()), cercle
					.getPosture().getY()
					- forme.getPosture().getY()
					+ 1000
					* Math.sin(forme.getPosture().getTheta()));
			double pscal1 = u.getX() * ac.getX() + u.getY() * ac.getY();
			double pscal2 = (u.getX()) * bc.getX() + (u.getY()) * bc.getY();
			if ((pscal1 >= 0 && pscal2 >= 0)
					|| ac.norme() < cercle.getDiametre() / 2) {
				double ti = (u.getX() * ac.getX() + u.getY() * ac.getY())
						/ (Math.pow(u.norme(), 2));
				Vecteur ai = new Vecteur(ti * u.getX(), ti * u.getY());
				Vecteur ca = new Vecteur(-ac.getX(), -ac.getY());
				Vecteur cif = new Vecteur(ca.plus(ai));
				double norme = ai.norme()
						- Math.sqrt(Math.pow(cercle.getDiametre() / 2, 2)
								- Math.pow(cif.norme(), 2));
				if (ac.norme() < cercle.getDiametre() / 2) {
					Vecteur som = u.plus(ai);
					Vecteur dif = u.moins(ai);
					if (som.norme() >= dif.norme())
						norme = ai.norme()
								+ Math.sqrt(Math.pow(cercle.getDiametre() / 2,
										2) - Math.pow(cif.norme(), 2));
					else
						norme = -(ai.norme() - Math.sqrt(Math.pow(
								cercle.getDiametre() / 2, 2)
								- Math.pow(cif.norme(), 2)));

				}
				distTemp = (distTemp < norme) ? distTemp : norme;
			}
		}

		return distTemp;
	}

	@Override
	public double lecture() {
		return distance;
	}

	public String toString() {
		String tmp = new String(String.valueOf(distance + 0.0000000000001));
		return " " + "Laser : " + String.valueOf(tmp.charAt(0)) + tmp.charAt(1)
				+ tmp.charAt(2) + " m";
	}

	@Override
	public void draw(Graphics2D g2, int facteurEchelle, int centrex, int centrey) {
		g2.setColor(Color.BLACK);
		forme.paint(g2, facteurEchelle, centrex, centrey);
		g2.setColor(Color.RED);
		g2.drawLine(
				(int) (forme.getPosture().getX() * facteurEchelle) + centrex,
				(int) (forme.getPosture().getY() * facteurEchelle) + centrey,
				(int) ((forme.getPosture().getX() + distance
						* Math.cos(forme.getPosture().getTheta())) * facteurEchelle)
						+ centrex,
				(int) ((forme.getPosture().getY() + distance
						* Math.sin(forme.getPosture().getTheta())) * facteurEchelle)
						+ centrey);
	}

	protected void setPosition(Polair posRel, Posture origine) {
		super.setPosition(posRel, origine);
		forme.getPosture().setTheta(orientation + origine.getTheta());
	}

	protected void setPosRel(Vecteur origine) {
		super.setPosRel(origine);
	}


	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getOrientation() {
		return orientation;
	}

	public void setOrientation(double orientation) {
		this.orientation = orientation;
	}

}
