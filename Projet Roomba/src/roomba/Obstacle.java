package roomba;

import java.awt.Graphics2D;

import javax.swing.JPanel;

public abstract class Obstacle extends Forme{

	/*Obstacle() {
		super();
	}*/
	
	Obstacle(int nbCote,double x, double y, double theta,int dim) {
		super(nbCote,x,y,theta,dim);
	}
	abstract boolean collision(Vecteur2D Vect);
	abstract void paint(Graphics2D g2);


}
