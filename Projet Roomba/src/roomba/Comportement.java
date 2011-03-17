package roomba;

import java.util.ArrayList;
public abstract class Comportement {
	protected double iL;
	protected double iR;
	Comportement(){
		iL = 0;
		iR = 0;
	}
	public double vitesseRoueR(){ return iR; }
	public double vitesseRoueL(){ return iL; }
	abstract void calcul(ArrayList<Capteur> capteurs);
	

}
