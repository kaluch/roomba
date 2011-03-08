package roomba;

public class Roue {

	protected Posture posture;
	protected double vitesse;
	
	public Posture getPosture() {		return posture;	}
	public void setPosture(Posture posture) {		this.posture = posture;	}
	public double getVitesse() {		return vitesse;	}
	public void setVitesse(double vitesse) {
		if(Math.abs(vitesse) > 1)
		this.vitesse = (vitesse>0)? 1 : -1;}
	
	Roue(){
		posture = new Posture();
		vitesse = 0;
	}
	Roue(Posture posture){
		this.posture = posture;
	}
	
}
