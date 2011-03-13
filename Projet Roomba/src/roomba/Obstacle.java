package roomba;


public abstract class Obstacle extends Forme{

	/*Obstacle() {
		super();
	}*/
	
	Obstacle(int nbCote,double x, double y, double theta) {
		super(nbCote,x,y,theta);
	}
	abstract boolean collision(Vecteur2D Vect);


}
