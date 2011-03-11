

public class Roue  {

	protected double vitesse;
	
	public double getVitesse() {		return vitesse;	}
	public void setVitesse(double vitesse) throws ExceptionVitesseMax {
		if(vitesse > 1)
		throw new ExceptionVitesseMax();
		this.vitesse = vitesse;
		}
	
	Roue(){
		vitesse = 0;
	}
	Roue(double vitesse){
		this.vitesse = vitesse;
	}
	public String toString(){
		return String.valueOf(vitesse);
	}
	
	
}
