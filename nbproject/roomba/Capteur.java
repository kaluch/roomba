

public abstract class Capteur {

	protected Vecteur position;
	abstract public void miseAjour(Environnement environ);
	abstract public double lecture();
	
	Capteur(Vecteur position){
		this.position = position;
	}
	public void setPosition(Vecteur position) { this.position = position;	}
	public Vecteur getPosition() {	return position;	}
	
}
