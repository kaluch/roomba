/**
 * 
 */

package roomba;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * @author souchet
 *
 */
public class ObstacleCercle extends Obstacle {

	/**
	 * @param nbCote
	 */
	public ObstacleCercle(double x, double y,int dim) {
		super(1,x,y,0,dim);
	}
	
	public boolean collision(Vecteur2D Vect) {
		double x1 = this.getPosture().getX();
		double y1 = this.getPosture().getY();
		return (Math.sqrt(Math.pow(x1-Vect.getX(),2)+Math.pow(y1-Vect.getY(),2)) < (this.dimension));
	}
	
	public void paint(Graphics2D g2){
		g2.setColor(Color.RED);
		g2.fillOval((int)(this.getPosture().getX()-this.dimension),(int) (this.getPosture().getY()-this.dimension),(int) dimension*2, (int)dimension*2);
	}
}
