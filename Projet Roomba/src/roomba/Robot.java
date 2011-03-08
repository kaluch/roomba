package roomba;

import java.util.ArrayList;

public abstract class Robot {
	
	protected ArrayList<Roue> roues;
	protected ArrayList<Capteur> capteurs;
	protected Posture posture;
	protected ArrayList<Comportement> comportements;
	
	public ArrayList<Roue> getRoues() {		return roues;	}
	public void setRoues(ArrayList<Roue> roues) {		this.roues = roues;	}
	public Posture getPosture() {		return posture;	}
	public void setPosture(Posture posture) {		this.posture = posture;	}
	public ArrayList<Capteur> getCapteurs() {		return capteurs;	}
	public ArrayList<Comportement> getComportements() {		return comportements;	}
	
	Robot(){
		roues = new ArrayList<Roue>();
		capteurs = new ArrayList<Capteur>();
		posture = new Posture();	
		comportements = new ArrayList<Comportement>();		
	}
	

}
