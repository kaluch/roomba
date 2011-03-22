package roomba;


import java.util.ArrayList;

public abstract class Robot {
	
	protected ArrayList<Roue> roues;
	protected ArrayList<Capteur> capteurs;
	protected Forme forme;
	protected PostureRobot posture;
	protected Comportement comportement;
	
	public Forme getForme() {		return forme;	}
	public void setForme(Forme forme) {		this.forme = forme;	}
	public void setCapteurs(ArrayList<Capteur> capteurs) {		this.capteurs = capteurs;	}
	public void setComportement(Comportement comportement) {		this.comportement = comportement;	}
	public ArrayList<Roue> getRoues() {		return roues;	}
	public void setRoues(ArrayList<Roue> roues) {		this.roues = roues;	}
	public Posture getPosture() {		return posture;	}
	public void setPosture(PostureRobot posture) {		
		this.posture.setTheta(posture.getTheta());
		this.posture.setX(posture.getX());
		this.posture.setY(posture.getY());}
	public void setPosture(double x, double y,double theta){
		posture.setTheta(theta);
		posture.setX(x);
		posture.setY(y);
	}
	public ArrayList<Capteur> getCapteurs() {		return capteurs;	}
	public Comportement getComportement() {		return comportement;	}
	abstract public void move(double to,Environnement environ);
	abstract public String toString();
	Robot(Forme forme){
		roues = new ArrayList<Roue>();
		capteurs = new ArrayList<Capteur>();
		posture = new PostureRobot(0,0,0);	
		this.forme = forme;
	}
	
	

}
