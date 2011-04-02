package com.roomba.roombautil;

/**
 * Polar representation of points
 * @author Lucas
 *
 */
public class Polair {
	protected double rho;
	protected double theta;

	public Polair() {
		rho = 0;
		theta = 0;
	}

	Polair(double rho, double theta) {
		this.rho = rho;
		this.theta = theta;
	}

	public double getRho() {
		return rho;
	}

	public void setRho(double rho) {
		this.rho = rho;
	}

	public double getTheta() {
		return theta;
	}

	public void setTheta(double theta) {
		this.theta = theta;
	}

}
