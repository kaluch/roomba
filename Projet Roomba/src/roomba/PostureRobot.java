/**
 * 
 */
package roomba;

/**
 * @author souchet
 * 
 */
public class PostureRobot extends Posture {

	/**
	 * @param x
	 * @param y
	 * @param theta
	 */
	public PostureRobot(double x, double y, double theta) {
		super(x, y, theta);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Deplace un robot en fonction de la distance parcourue par chaque roue
	 * 
	 * @param d_l
	 *            distance parcourue par la roue gauche
	 * @param d_r
	 *            distance parcourue par la roue droite
	 * @param dist
	 *            distance entre les deux roues
	 */
	public Posture move(double d_l, double d_r, double dist) {
		double alpha = (d_r - d_l) / dist;
		Posture p = null;
		if (alpha > 1e-20 || alpha < -1e-20) {
			double r = (d_l / alpha) + dist / 2;
			double d_x = (Math.cos(alpha) - 1) * r;
			double d_y = Math.sin(alpha) * r;
			p = new Posture(d_x, d_y, alpha);
			p.rotate(this.getTheta() - Math.PI / 2);
			p.theta = alpha;
		} else {
			p = new Posture(d_l * Math.cos(this.getTheta()), d_l
					* Math.sin(this.getTheta()), 0);
		}

		this.x += p.x;
		this.y += p.y;
		this.theta = normalize_angle(p.theta + this.theta);

		return this;
	}
}
