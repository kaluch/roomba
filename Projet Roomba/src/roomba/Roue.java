package roomba;

public class Roue  {

	protected Vecteur vitesse;
	
	public Vecteur getVitesse() {		return vitesse;	}
	public void setVitesse(Vecteur vitesse) throws ExceptionVitesseMax {
		if(vitesse.norme() > 1)
		throw new ExceptionVitesseMax();
		this.vitesse = vitesse;
		}
	
	Roue(){
		vitesse = new Vecteur2D();
	}
	Roue(Vecteur vitesse){
		this.vitesse = vitesse;
	}
	public String toString(){
		return vitesse.toString();
	}
	
	
}
