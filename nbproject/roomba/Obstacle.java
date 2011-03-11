

public abstract class Obstacle extends Forme{

	/*Obstacle() {
		super();
	}*/
	
	Obstacle(int nbCote) {
		super(nbCote);
	}
	abstract boolean collision(Vecteur2D Vect);


}
