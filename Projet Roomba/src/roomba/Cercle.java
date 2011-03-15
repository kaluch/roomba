package roomba;

import java.awt.Graphics2D;

public class Cercle extends Forme {

	protected double diametre;
	Cercle(double x, double y, double theta,double diametre) {
		super(x, y, theta);
		this.diametre = diametre;
	}
	Cercle(Posture posture,double diametre){
		super(posture);
		this.diametre = diametre;
	}
	
	public double getDiametre() {		return diametre;	}
	public void setDiametre(double diametre) {		this.diametre = diametre;	}
	@Override
	void paint(Graphics2D g2,int facteurEchelle,int centrex,int centrey) {
		double rayon = diametre/2;
		g2.fillOval(centrex+getxPix(facteurEchelle)-(int)(rayon*facteurEchelle),centrey+getyPix(facteurEchelle)-(int)(rayon*facteurEchelle),(int)(facteurEchelle*rayon*2),(int) (facteurEchelle*rayon*2));		
	}
	@Override
	void draw(Graphics2D g2, int facteurEchelle,int centrex,int centrey) {
		double rayon = diametre/2;
		g2.drawOval(centrex+getxPix(facteurEchelle)-(int)(rayon*facteurEchelle),centrey+getyPix(facteurEchelle)-(int)(rayon*facteurEchelle),(int)(facteurEchelle*rayon*2),(int) (facteurEchelle*rayon*2));				
	}
	public boolean collisionInterne(Carre carre){
		double xm = (getPosture().getX() <= carre.getPosture().getX())?carre.getPosture().getX() : (getPosture().getX() <= carre.getPosture().getX()+carre.getCote())?getPosture().getX() : carre.getPosture().getX()+carre.getCote();
		double ym = (getPosture().getY() <= carre.getPosture().getY())?carre.getPosture().getY() : (getPosture().getY() <= carre.getPosture().getY()+carre.getCote())?getPosture().getY() : carre.getPosture().getY()+carre.getCote();
		return (Math.pow(getPosture().getX()-xm,2)+ Math.pow(getPosture().getY()-ym,2)<=getDiametre()* getDiametre()/4)?true:false;
	}
	public boolean collisionExterne(Carre carre){
		double xm = (getPosture().getX() <= carre.getPosture().getX())?carre.getPosture().getX() : (getPosture().getX() <= carre.getPosture().getX()+carre.getCote())?getPosture().getX() : carre.getPosture().getX()+carre.getCote();
		double ym = (getPosture().getY() <= carre.getPosture().getY())?carre.getPosture().getY() : (getPosture().getY() <= carre.getPosture().getY()+carre.getCote())?getPosture().getY() : carre.getPosture().getY()+carre.getCote();
		return (Math.pow(getPosture().getX()-xm,2)+ Math.pow(getPosture().getY()-ym,2)<=getDiametre()* getDiametre()/4)?true:false;
	}
	public boolean collisionInterne(Cercle cercle){
		return (Math.sqrt(Math.pow(cercle.getPosture().getX()-getPosture().getX(), 2) + Math.pow(cercle.getPosture().getY()-getPosture().getY(), 2)) + getDiametre()/2 >= cercle.getDiametre()/2) ? true : false;
	}
	public boolean collisionExterne(Cercle cercle){
		return (Math.pow(getPosture().getX() - cercle.getPosture().getX(), 2) > Math.pow((diametre+cercle.getDiametre())/2, 2))? false : true;
	}
	public boolean collisionInterne(Rectangle rectangle){
		double xm = (getPosture().getX() <= rectangle.getPosture().getX())?rectangle.getPosture().getX() : (getPosture().getX() <= rectangle.getPosture().getX()+rectangle.getLargeur())?getPosture().getX() : rectangle.getPosture().getX()+rectangle.getLargeur();
		double ym = (getPosture().getY() <= rectangle.getPosture().getY())?rectangle.getPosture().getY() : (getPosture().getY() <= rectangle.getPosture().getY()+rectangle.getHauteur())?getPosture().getY() : rectangle.getPosture().getY()+rectangle.getHauteur();
		return (Math.pow(getPosture().getX()-xm,2)+ Math.pow(getPosture().getY()-ym,2)<=getDiametre()* getDiametre()/4)?true:false;
	}
	public boolean collisionExterne(Rectangle rectangle){
		double xm = (getPosture().getX() <= rectangle.getPosture().getX())?rectangle.getPosture().getX() : (getPosture().getX() <= rectangle.getPosture().getX()+rectangle.getLargeur())?getPosture().getX() : rectangle.getPosture().getX()+rectangle.getLargeur();
		double ym = (getPosture().getY() <= rectangle.getPosture().getY())?rectangle.getPosture().getY() : (getPosture().getY() <= rectangle.getPosture().getY()+rectangle.getHauteur())?getPosture().getY() : rectangle.getPosture().getY()+rectangle.getHauteur();
		return (Math.pow(getPosture().getX()-xm,2)+ Math.pow(getPosture().getY()-ym,2)<=getDiametre()* getDiametre()/4)?true:false;
	}
}
