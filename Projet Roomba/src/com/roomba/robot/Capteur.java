package com.roomba.robot;

import java.awt.Graphics2D;

import com.roomba.shape.*;
import com.roomba.environnement.Environnement;
import com.roomba.roombautil.*;

/**
 * Represents the different sensors of the robot
 * @author Lucas
 *
 */
public abstract class Capteur {

	protected Forme forme;
	protected Polair posRel;

	/**
	 * update the state of the sensor according to the situation of environ
	 * @param environ environment of the robot
	 */
	abstract public void miseAjour(Environnement environ);

	/**
	 * getter for the state of the sensor
	 * @return
	 */
	abstract public double lecture();

	Capteur(Forme forme) {
		this.forme = forme;
		posRel = new Polair();

	}

	/**
	 * Setter for the position relative to the robot
	 * @param origine
	 */
	protected void setPosRel(Vecteur origine) {
		posRel.setTheta(forme.getPosture().getPosition().angle()
				- origine.angle());
		posRel.setRho(Math.sqrt(Math.pow(forme.getPosture().getPosition()
				.getX()
				- (origine).getX(), 2)
				+ Math.pow(
						forme.getPosture().getPosition().getY()
								- (origine).getY(), 2)));
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
		return (int) (forme.getPosture().getPosition().getX() * facteurEchelle);
	}

	protected int getPosyPix(int facteurEchelle) {
		return (int) (forme.getPosture().getPosition().getY() * facteurEchelle);
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
	 * @param g2
	 * @param facteurEchelle
	 * @param centrex
	 * @param centrey
	 */
	abstract public void draw(Graphics2D g2, int facteurEchelle, int centrex,
			int centrey);

}
