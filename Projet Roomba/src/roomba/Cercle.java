package roomba;

import java.awt.Graphics2D;

public class Cercle extends Forme implements Cloneable {

	protected double diametre;
	public Cercle(double x, double y, double theta,double diametre) {
		super(x, y, theta);
		this.diametre = diametre;
	}
	public Cercle(Posture posture,double diametre){
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
		double xm = (getPosture().getX() <= carre.getPosture().getX()-carre.getCote()/2)?
				carre.getPosture().getX()-carre.getCote()/2 :
					(getPosture().getX() <= carre.getPosture().getX()+carre.getCote()/2)?
							getPosture().getX() : carre.getPosture().getX()+carre.getCote();
		double ym = (getPosture().getY() <= carre.getPosture().getY()-carre.getCote()/2)?
				carre.getPosture().getY()-carre.getCote()/2 : 
					(getPosture().getY() <= carre.getPosture().getY()+carre.getCote()/2)?
							getPosture().getY() : carre.getPosture().getY()+carre.getCote()/2;
		return (Math.sqrt(Math.pow(getPosture().getX()-xm,2)+
				Math.pow(getPosture().getY()-ym,2))
				<=getDiametre()/2)?true:false;}
	
	public boolean collisionExterne(Carre carre){
		double xm = (getPosture().getX() <= carre.getPosture().getX()-carre.getCote()/2)?
				carre.getPosture().getX()-carre.getCote()/2 :
					(getPosture().getX() <= carre.getPosture().getX()+carre.getCote()/2)?
							getPosture().getX() : carre.getPosture().getX()+carre.getCote()/2;
		double ym = (getPosture().getY() <= carre.getPosture().getY()-carre.getCote()/2)?
				carre.getPosture().getY()-carre.getCote()/2 : 
					(getPosture().getY() <= carre.getPosture().getY()+carre.getCote()/2)?
							getPosture().getY() : carre.getPosture().getY()+carre.getCote()/2;
		return (Math.sqrt(Math.pow(getPosture().getX()-xm,2)+
				Math.pow(getPosture().getY()-ym,2))
				<=getDiametre()/2)?true:false;}
	public boolean collisionInterne(Cercle cercle){
		return (Math.sqrt(Math.pow(cercle.getPosture().getX()-getPosture().getX(),2) 
				+ Math.pow(cercle.getPosture().getY()-getPosture().getY(), 2)) 
				+ cercle.getDiametre()/2
				>= getDiametre()/2) ? true : false;
	}
	public boolean collisionExterne(Cercle cercle){
		return (Math.pow(getPosture().getX() 
				- cercle.getPosture().getX(), 2) 
				+Math.pow(getPosture().getY() 
						- cercle.getPosture().getY(), 2) 
				> Math.pow((diametre+cercle.getDiametre())/2, 2))? false : true;
	}
	public boolean collisionInterne(Rectangle rectangle){
		double xm = (getPosture().getX() <= rectangle.getPosture().getX()-rectangle.getLargeur()/2)?
				rectangle.getPosture().getX()-rectangle.getLargeur()/2 :
					(getPosture().getX() <= rectangle.getPosture().getX()+rectangle.getLargeur()/2)?
							getPosture().getX() : rectangle.getPosture().getX()+rectangle.getLargeur();
		double ym = (getPosture().getY() <= rectangle.getPosture().getY()-rectangle.getHauteur()/2)?
				rectangle.getPosture().getY()-rectangle.getHauteur()/2 : 
					(getPosture().getY() <= rectangle.getPosture().getY()+rectangle.getHauteur()/2)?
							getPosture().getY() : rectangle.getPosture().getY()+rectangle.getHauteur()/2;
		return (Math.sqrt(Math.pow(getPosture().getX()-xm,2)+
				Math.pow(getPosture().getY()-ym,2))
				<=getDiametre()/2)?true:false;}
	public boolean collisionExterne(Rectangle rectangle){
		double xm = (getPosture().getX() <= rectangle.getPosture().getX()-rectangle.getLargeur()/2)?
				rectangle.getPosture().getX()-rectangle.getLargeur()/2 :
					(getPosture().getX() <= rectangle.getPosture().getX()+rectangle.getLargeur()/2)?
							getPosture().getX() : rectangle.getPosture().getX()+rectangle.getLargeur()/2;
		double ym = (getPosture().getY() <= rectangle.getPosture().getY()-rectangle.getHauteur()/2)?
				rectangle.getPosture().getY()-rectangle.getHauteur()/2 : 
					(getPosture().getY() <= rectangle.getPosture().getY()+rectangle.getHauteur()/2)?
							getPosture().getY() : rectangle.getPosture().getY()+rectangle.getHauteur()/2;
		return (Math.sqrt(Math.pow(getPosture().getX()-xm,2)+
				Math.pow(getPosture().getY()-ym,2))
				<=getDiametre()/2)?true:false;
	}
	@Override
	public boolean collisionExterne(Forme forme) {
		if(forme instanceof Carre) return collisionExterne((Carre)forme);
		else if(forme instanceof Cercle) return collisionExterne((Cercle)forme);
		else if(forme instanceof Rectangle) return collisionExterne((Rectangle)forme);
		else return false;
	}
	@Override
	public boolean collisionInterne(Forme forme) {
		if(forme instanceof Carre) return collisionInterne((Carre)forme);
		else if(forme instanceof Cercle) return collisionInterne((Cercle)forme);
		else if(forme instanceof Rectangle) return collisionInterne((Rectangle)forme);
		else return false;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Cercle o = (Cercle) super.clone();
		o.diametre = diametre;
		return  o;
	}
	@Override
	public Forme normalize(int facteurEchelle) {
		super.normalize(facteurEchelle);
		diametre = diametre/facteurEchelle;
		return this;
	}
	@Override
	public boolean collisionPoint(double x, double y) {
		Vecteur2D A = new Vecteur2D(x,y);
		Vecteur2D C = getPosture().getPosition();
		Vecteur2D AC = A.moins(C);
		return AC.norme()<diametre/2;
	}
	@Override
	public int tangeantPoint(double x, double y) {
		Vecteur2D A = new Vecteur2D(x,y);
		Vecteur2D C = getPosture().getPosition();
		Vecteur2D AC = A.moins(C);
		if( Math.abs(AC.norme()-diametre/2)<0.2)
			return 1;
		return 0;
	}
	@Override
	public void iso(double a) {
		diametre*=a;
		
	}
}
