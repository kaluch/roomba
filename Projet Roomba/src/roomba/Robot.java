package roomba;


import java.util.ArrayList;

public abstract class Robot {
	
	protected ArrayList<Roue> roues;
	protected ArrayList<Capteur> capteurs;
	protected Forme forme;
	protected PostureRobot posture;
	protected ArrayList<Comportement> comportements;
	
	public Forme getForme() {		return forme;	}
	public void setForme(Forme forme) {		this.forme = forme;	}
	public void setCapteurs(ArrayList<Capteur> capteurs) {		this.capteurs = capteurs;	}
	public void setComportements(ArrayList<Comportement> comportements) {		this.comportements = comportements;	}
	public ArrayList<Roue> getRoues() {		return roues;	}
	public void setRoues(ArrayList<Roue> roues) {		this.roues = roues;	}
	public Posture getPosture() {		return posture;	}
	public void setPosture(PostureRobot posture) {		this.posture = posture;	}
	public ArrayList<Capteur> getCapteurs() {		return capteurs;	}
	public ArrayList<Comportement> getComportements() {		return comportements;	}
	abstract public void move(double to);
	abstract public String toString();
	Robot(Forme forme){
		roues = new ArrayList<Roue>();
		capteurs = new ArrayList<Capteur>();
		posture = new PostureRobot(0,0,0);	
		comportements = new ArrayList<Comportement>();
		this.forme = forme;
	}
	
	

}
