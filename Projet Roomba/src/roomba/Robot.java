package roomba;


import java.util.ArrayList;

public abstract class Robot {
	
	protected ArrayList<Roue> roues;
	protected ArrayList<Capteur> capteurs;
	protected ArrayList<Double> positionRelCapteurs;
	protected PostureRobot posture;
	protected ArrayList<Comportement> comportements;
	
	public ArrayList<Roue> getRoues() {		return roues;	}
	public void setRoues(ArrayList<Roue> roues) {		this.roues = roues;	}
	public Posture getPosture() {		return posture;	}
	public void setPosture(PostureRobot posture) {		this.posture = posture;	}
	public ArrayList<Capteur> getCapteurs() {		return capteurs;	}
	public ArrayList<Comportement> getComportements() {		return comportements;	}
	abstract public void move(double to);
	abstract public String toString();
	Robot(){
		roues = new ArrayList<Roue>();
		capteurs = new ArrayList<Capteur>();
		positionRelCapteurs = new ArrayList<Double>();
		posture = new PostureRobot(0,0,0);	
		comportements = new ArrayList<Comportement>();	
	}
	
	

}
