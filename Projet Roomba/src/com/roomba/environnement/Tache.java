package com.roomba.environnement;

import java.awt.Graphics2D;
import java.awt.Color;

import com.roomba.shape.*;

public class Tache {

	Forme forme;

	public Tache(Forme forme) {
		this.forme = forme;
	}

	public void paint(Graphics2D g2, int facteurEchelle, int centrex,
			int centrey) {
		g2.setColor(Color.DARK_GRAY);
		forme.paint(g2, facteurEchelle, centrex, centrey);
	}

	public void nettoyer() {
		if (forme instanceof Carre)
			((Carre) forme).setCote(((Carre) forme).getCote() - 0.001);
		else if (forme instanceof Rectangle) {
			((Rectangle) forme)
					.setHauteur(((Rectangle) forme).getHauteur() - 0.001);
			((Rectangle) forme)
					.setLargeur(((Rectangle) forme).getLargeur() - 0.001);
		} else if (forme instanceof Cercle)
			((Cercle) forme)
					.setDiametre(((Cercle) forme).getDiametre() - 0.001);

	}

	public Forme getForme() {
		return forme;
	}

	public void setForme(Forme forme) {
		this.forme = forme;
	}
}
