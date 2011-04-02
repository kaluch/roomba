package com.roomba.comportement;

import java.util.ArrayList;

import com.roomba.robot.Capteur;

/**
 * La classe comportement doit etre clonable afin de permettre la sauvegarde des
 * données initiales
 * 
 * @author Lucas
 * 
 */
public abstract class Comportement implements Cloneable {
	protected double iL;
	protected double iR;

	Comportement() {
		iL = 0;
		iR = 0;
	}

	public double vitesseRoueR() {
		return iR;
	}

	public double vitesseRoueL() {
		return iL;
	}

	/**
	 * Le comportement doit implementer la fonction calcul qui met a jour les
	 * variables Comportement.iL et comportement.iR qui sont les vitesses
	 * respectives des roues gauche et droite.
	 * 
	 * @param capteurs
	 */
	public abstract void calcul(ArrayList<Capteur> capteurs);

	public Object clone() {
		Comportement o = null;
		try {
			o = (Comportement) super.clone();
			o.iL = iL;
			o.iR = iR;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}

}
