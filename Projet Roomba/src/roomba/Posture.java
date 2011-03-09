package roomba;

public class Posture implements Cloneable{
	private double x, y, theta;
	  /**
	   * Constructeur
	   */
	  public Posture(double x, double y, double theta)
	  {
	    this.x = x;
	    this.y = y;
	    this.theta = theta;
	  }
	  public double getX() { return x;  }
	  public double getY() { return y; }
	  public double getTheta() { return theta; }
	  public Object clone() { return new Posture(x, y, theta); }
	  /**
	   * rotation autour de la coordonnee (0, 0)
	   */
	  public Posture rotate(double alpha)
	  {
	    double x_ = Math.cos(alpha) * getX() - Math.sin(alpha) * getY();
	    double y_ = Math.cos(alpha) * getY() + Math.sin(alpha) * getX();
	    x = x_;
	    y = y_;
	    theta = normalize_angle(alpha + theta);
	    return this;
	  }
	  /**
	   * Deplace un robot en fonction de la distance parcourue par 
	   * chaque roue
	   * @param d_l distance parcourue par la roue gauche
	   * @param d_r distance parcourue par la roue droite
	   * @param dist distance entre les deux roues
	   */
	  public Posture move(double d_l, double d_r,
			      double dist)
	  {
	    double alpha = (d_r - d_l) / dist;
	    Posture p = null;
	    if (alpha > 1e-20  || alpha < -1e-20)
	      {
		double r = (d_l / alpha) +  dist / 2;
		double d_x = (Math.cos(alpha) - 1) * r;
		double d_y = Math.sin(alpha) * r;
		p = new Posture(d_x, d_y, alpha);
		p.rotate(this.getTheta() - Math.PI / 2);
		p.theta = alpha;
	      }
	    else
	      {
		p = new Posture(d_l * Math.cos(this.getTheta()),
				d_l * Math.sin(this.getTheta()),
				0);
	      }

	    this.x += p.x;
	    this.y += p.y;
	    this.theta = normalize_angle(p.theta + this.theta);

	    return this;
	  }
	  
	  public String toString()
	  {
	    return x + " " + y + " " + theta;
	  }
	  /**
	   * return l'angle remis dans [-PI;PI]
	   */
	  protected double normalize_angle(double a)
	  {
	    while (a > Math.PI)
	      a -= 2 * Math.PI;
	    while (a < -Math.PI)
	      a += 2 * Math.PI;
	    return a;
	  }  

	  public static void main(String args[])
	  {
	    Posture p =  new Posture(0, 0, 0);
	    for (int j = 0; j < 4; ++j)
	      {
		for (int i = 0; i < 10; ++i)
		  {
		    System.out.println(p);
		    p.move(5.34, 0, 34);
		  }
		for (int i = 0; i < 10; ++i)
		  {
		    System.out.println(p);
		    p.move(5, 5, 34);
		  }
	      }
	  }
}
