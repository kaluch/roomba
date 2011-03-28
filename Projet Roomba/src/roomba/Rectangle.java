package roomba;

import java.awt.Graphics2D;

public class Rectangle extends Forme {

	protected double largeur;
	protected double hauteur;
	public Rectangle(double x, double y, double theta,double largeur,double hauteur) {
		super(x, y, theta);
		this.largeur = largeur;
		this.hauteur = hauteur;
	}
	public Rectangle(Posture posture,double largeur,double hauteur){
		super(posture);
		this.largeur = largeur;
		this.hauteur = hauteur;
	}
	
	
	@Override
	void paint(Graphics2D g2, int facteurEchelle,int centrex,int centrey) {
		g2.fillRect(centrex+getxPix(facteurEchelle)-(int)(largeur*facteurEchelle/2),centrey+getyPix(facteurEchelle)-(int)(hauteur*facteurEchelle/2),(int)(facteurEchelle*largeur),(int) (facteurEchelle*hauteur));
		
	}
	@Override
	void draw(Graphics2D g2, int facteurEchelle,int centrex,int centrey) {
		g2.drawRect(centrex+getxPix(facteurEchelle)-(int)(largeur*facteurEchelle/2),centrey+getyPix(facteurEchelle)-(int)(hauteur*facteurEchelle/2),(int)(facteurEchelle*largeur),(int) (facteurEchelle*hauteur));
		
	}
	public double getLargeur() {		return largeur;	}
	public void setLargeur(double largeur) {		this.largeur = largeur;	}
	public double getHauteur() {		return hauteur;	}
	public void setHauteur(double hauteur) {		this.hauteur = hauteur;	}

	public boolean collisionInterne(Carre carre){
		return ((carre.getPosture().getY() <= getPosture().getY())
				||(carre.getPosture().getX() <= getPosture().getX())
				||(carre.getPosture().getX()+carre.getCote()>= getPosture().getX()+getLargeur())
				||(carre.getPosture().getY()+carre.getCote()>= getPosture().getY()+getHauteur()))? true : false;
	}
	public boolean collisionExterne(Carre carre){
		return ((carre.getPosture().getX()>=getPosture().getX()+largeur )
				||(carre.getPosture().getX()+carre.getCote()<= getPosture().getX())
				||(carre.getPosture().getY()>=getPosture().getY()+hauteur)
				||(carre.getPosture().getY()+carre.getCote()<=getPosture().getY()))? false : true;
	}
	public boolean collisionInterne(Cercle cercle){
		return ((cercle.getPosture().getY()-cercle.getDiametre()/2 <= getPosture().getY()-getHauteur()/2)
			|| (cercle.getPosture().getX()-cercle.getDiametre()/2 <= getPosture().getX()-getLargeur()/2)
			||(cercle.getPosture().getY()+cercle.getDiametre()/2 >= getPosture().getY()+getHauteur()/2)
			|| (cercle.getPosture().getX()+cercle.getDiametre()/2 >= getPosture().getX()+getLargeur()/2))?
				true : false;
	
	}
	public boolean collisionExterne(Cercle cercle){
		double xm = (cercle.getPosture().getX() <= getPosture().getX()-getLargeur()/2)?
				getPosture().getX()-getLargeur()/2 :
					(cercle.getPosture().getX() <= getPosture().getX()+getLargeur()/2)?
							cercle.getPosture().getX() : getPosture().getX()+getLargeur()/2;
		double ym = (cercle.getPosture().getY() <= getPosture().getY()-getHauteur()/2)?
				getPosture().getY()-getHauteur()/2 : 
					(cercle.getPosture().getY() <= getPosture().getY()+getHauteur()/2)?
							cercle.getPosture().getY() : getPosture().getY()+getHauteur()/2;
		return (Math.sqrt(Math.pow(cercle.getPosture().getX()-xm,2)+
				Math.pow(cercle.getPosture().getY()-ym,2))
				<=cercle.getDiametre()/2)?true:false;
	}
	public boolean collisionInterne(Rectangle rectangle){
		return ((rectangle.getPosture().getY() <= getPosture().getY())
				||(rectangle.getPosture().getX() <= getPosture().getX())
				||(rectangle.getPosture().getX()+rectangle.getLargeur()>= getPosture().getX()+getLargeur())
				||(rectangle.getPosture().getY()+rectangle.getHauteur()>= getPosture().getY()+getHauteur()))? true : false;
	}
	public boolean collisionExterne(Rectangle rectangle){
		return ((rectangle.getPosture().getX()>=getPosture().getX()+largeur )
				||(rectangle.getPosture().getX()+rectangle.getLargeur()<= getPosture().getX())
				||(rectangle.getPosture().getY()>=getPosture().getY()+hauteur)
				||(rectangle.getPosture().getY()+rectangle.getHauteur()<=getPosture().getY()))? false : true;
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
	public boolean collisionPoint(double x, double y) {
		return (x>posture.getX()-largeur/2 && x<posture.getX()+largeur/2
				&& y>posture.getY()-hauteur/2 && y<posture.getY()+hauteur/2)? true : false;
	}
	@Override
	public int tangeantPoint(double x, double y) {
		System.out.println(Math.abs(y-posture.getY()-hauteur/2 )+ " " +Math.abs( y-posture.getY()+hauteur/2) );
		if(Math.abs(x-posture.getX()-largeur/2)<=0.02)
			if (y>=posture.getY()-hauteur/2 || y<=posture.getY()+hauteur/2) return 1 ;
		if(Math.abs( x-posture.getX()+largeur/2)<=0.02)
			if(y>=posture.getY()-hauteur/2 || y<=posture.getY()+hauteur/2) return 1;
		if(Math.abs(y-posture.getY()-hauteur/2)<=0.02)
			if(x>=posture.getX()-largeur/2 || x<=posture.getX()+largeur/2) return 2 ;
		if(Math.abs( y-posture.getY()+hauteur/2)<=0.02)
			if (x>=posture.getX()-largeur/2 || x<=posture.getX()+largeur/2) return 2;
		
		
		return 0;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Rectangle o = (Rectangle) super.clone();
		o.hauteur = hauteur;
		o.largeur = largeur;
		return  o;
	}
	@Override
	public Forme normalize(int facteurEchelle) {
		super.normalize(facteurEchelle);
		largeur = largeur/facteurEchelle;
		hauteur = hauteur/facteurEchelle;
		return this;
	}
	public void iso(double a){
		largeur*=a;
		hauteur*=a;
	}
}
