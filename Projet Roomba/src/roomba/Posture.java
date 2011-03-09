package roomba;

public class Posture implements Cloneable{
	protected double x, y, theta;
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


}
