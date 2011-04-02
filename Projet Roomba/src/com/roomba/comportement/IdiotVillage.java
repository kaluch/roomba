package com.roomba.comportement;

import java.util.ArrayList;
import com.roomba.robot.*;


public class IdiotVillage extends Comportement {

	public IdiotVillage() {
		super();
	}

	@Override
	public double vitesseRoueR() {
		return 0;
	}

	@Override
	public double vitesseRoueL() {
		return 0.1;
	}

	@Override
	public
	void calcul(ArrayList<Capteur> capteurs) {
	}

	@Override
	public Object clone() {
		return new IdiotVillage();
	}

}
