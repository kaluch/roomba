package roomba;

public class Vecteur2D extends Vecteur{

	protected double x;
	protected double y;
	
	Vecteur2D(){
		x=0;
		y=0;
	}
	Vecteur2D(double x,double y){
		this.x = x;
		this.y = y;
	}
	public double norme(){
		return Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
	}
	public double getX() {		return x;	}
	public void setX(double x) {		this.x = x;	}
	public double getY() {		return y;	}
	public void setY(double y) {		this.y = y;	}
	public String toString(){
		return x+" "+y;
	}
	public double angle() {
		return Math.atan2(y,x);		
	}
}
