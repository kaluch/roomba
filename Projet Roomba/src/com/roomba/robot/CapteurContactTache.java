package com.roomba.robot;

import java.awt.Color;
import java.awt.Graphics2D;
import com.roomba.shape.*;
import com.roomba.environnement.*;

/**
 * Represent the bumper-sensors that detect dirts
 * @author Lucas
 *
 */
public class CapteurContactTache extends CapteurContact {

	protected double diametre;

	public CapteurContactTache(Forme forme, double diametre) {
		super(forme);
		this.diametre = diametre;
	}

	@Override
	public void miseAjour(Environnement environ) {
		contact = false;
		for (Tache x : environ.getTaches()) {
			if (forme.collisionExterne(x.getForme()))
				x.nettoyer();
			contact = contact || forme.collisionExterne(x.getForme());
		}
	}

	@Override
	public void draw(Graphics2D g2, int facteurEchelle, int centrex, int centrey) {
		g2.setColor(Color.BLUE);
		if (contact)
			g2.setColor(Color.RED);
		forme.paint(g2, facteurEchelle, centrex, centrey);
	}

	@Override
	public String toString() {
		return "Tache : " + super.toString();
	}

}
