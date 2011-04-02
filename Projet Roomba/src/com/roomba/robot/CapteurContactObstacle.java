package com.roomba.robot;
import com.roomba.shape.*;
import com.roomba.environnement.*;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Represent the bumper-sensors that detect the obstacles
 * @author Lucas
 *
 */
public class CapteurContactObstacle extends CapteurContact {

	protected double perimetre;
	protected double diametre;

	CapteurContactObstacle(Forme position, double perimetre, double diametre) {
		super(position);
		this.perimetre = perimetre;
		this.diametre = diametre;
	}

	CapteurContactObstacle(Forme position) {
		super(position);
		perimetre = 0;
		diametre = 0;
	}

	public double getPerimetre() {
		return perimetre;
	}

	public void setPerimetre(double perimetre) {
		this.perimetre = perimetre;
	}

	public double getDiametre() {
		return diametre;
	}

	public void setDiametre(double diametre) {
		this.diametre = diametre;
	}

	@Override
	public void miseAjour(Environnement environ) {
		boolean temp = false;
		for (Obstacle x : environ.getObstacles())
			temp = temp || forme.collisionExterne(x.getForme());
		temp = temp || environ.getArene().getForme().collisionInterne(forme);
		contact = temp;

	}

	@Override
	public void draw(Graphics2D g2, int facteurEchelle, int centrex, int centrey) {
		if (contact)
			g2.setColor(Color.RED);
		forme.paint(g2, facteurEchelle, centrex, centrey);
	}

}
