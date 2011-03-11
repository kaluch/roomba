/**
 * 
 */


/**
 * @author souchet
 *
 */
public class ObstacleCercle extends Obstacle {

	protected double rayon;
	/**
	 * @param nbCote
	 */
	public ObstacleCercle(double rayon) {
		super(1);
		this.rayon = rayon;
	}
	
	public boolean collision(Vecteur2D Vect) {
		double x1 = this.getPosture().getX();
		double y1 = this.getPosture().getY();
		return (Math.sqrt(Math.pow(x1-Vect.getX(),2)+Math.pow(y1-Vect.getY(),2)) < (this.rayon));
	}

}
