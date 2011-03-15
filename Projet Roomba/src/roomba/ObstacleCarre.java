/**
 * 
 */
package roomba;

import java.awt.Graphics2D;
import java.awt.Color;


/**
 * @author Lucas
 *
 */
public class ObstacleCarre extends Obstacle {

	/**
	 * @param nbCote
	 * @param x
	 * @param y
	 * @param theta
	 */
	public ObstacleCarre(double x, double y, double theta, int dim) {
		super(4, x, y, theta,dim);
	}

	/* (non-Javadoc)
	 * @see roomba.Obstacle#collision(roomba.Vecteur2D)
	 */
	@Override
	boolean collision(Vecteur2D Vect) {
		boolean b1 = (Vect.getX() > this.posture.getX() && Vect.getX() < this.posture.getX()+this.getDimension());
		boolean b2 = (Vect.getY() > this.posture.getY() && Vect.getY() < this.posture.getY()+this.getDimension());
		return b1 && b2;
	}

	/* (non-Javadoc)
	 * @see roomba.Obstacle#paint(java.awt.Graphics2D, javax.swing.JPanel)
	 */
	@Override
	void paint(Graphics2D g2) {
		g2.setColor(Color.red);
		g2.fillRect((int)(this.getPosture().getX()-this.dimension),(int) (this.getPosture().getY()-this.dimension),(int) dimension*2, (int)dimension*2);

	}

}
