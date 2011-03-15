package roomba;

import java.awt.Graphics2D;



abstract public class Forme {

	/*
	 * ATTRIBUTS
	 */
	
	protected Posture posture;
	
	/*
	 * METHODES
	 */
	//Constructor
	Forme(double x, double y, double theta)
	{
		this.posture = new Posture(x,y,theta);
	}
	Forme(Posture posture){
		this.posture = posture;
	}
	
	



	public Posture getPosture() {		return posture;	}
	public void setPosture(Posture posture) {		this.posture = posture;	}
	abstract void paint(Graphics2D g2, int facteurEchelle,int centrex,int centrey);
	abstract void draw(Graphics2D g2, int facteurEchelle,int centrex,int centrey);
	protected int getxPix(int facteurEchelle){ return (int)( posture.getX() * facteurEchelle); }
	protected int getyPix(int facteurEchelle){ return (int)( posture.getY() * facteurEchelle); }



	
}
