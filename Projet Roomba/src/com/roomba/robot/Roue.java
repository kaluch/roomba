package com.roomba.robot;

import com.roomba.exception.ExceptionVitesseMax;

public class Roue {

	protected double vitesse;

	public double getVitesse() {
		return vitesse;
	}

	public void setVitesse(double vitesse) throws ExceptionVitesseMax {
		if (vitesse > 1)
			throw new ExceptionVitesseMax();
		this.vitesse = vitesse;
	}

	public Roue() {

		vitesse = 0;
	}

	public Roue(double vitesse) {
		this.vitesse = vitesse;
	}

	public String toString() {
		return String.valueOf((float) vitesse);
	}

}
