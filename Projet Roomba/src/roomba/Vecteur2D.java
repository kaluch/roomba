package roomba;


public class Vecteur2D extends Vecteur{

	protected double x;
	protected double y;
	
	public Vecteur2D(){
		x=0;
		y=0;
	}
	
	public Vecteur2D(double x,double y){
		this.x = x;
		this.y = y;
	}
	public Vecteur2D(Vecteur2D position) {
		x = position.getX();
		y = position.getY();
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
	public Vecteur2D plus(Vecteur2D vecteur) {
		return new Vecteur2D(x+vecteur.getX(),y+vecteur.getY());
	}
	public Vecteur2D moins(Vecteur2D vecteur) {
		return new Vecteur2D(x-vecteur.getX(),y-vecteur.getY());
	}
	public double pScal(Vecteur2D vecteur) {
		 return (x*vecteur.getX()+y*vecteur.getY());
	}
	public double det(Vecteur2D vecteur) {
		return (x*vecteur.getY()-y*vecteur.getX());
	}
	
}
