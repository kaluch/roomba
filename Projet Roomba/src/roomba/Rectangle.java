package roomba;

import java.awt.Graphics2D;

public class Rectangle extends Forme {

	protected double largeur;
	protected double hauteur;
	Rectangle(double x, double y, double theta,double largeur,double hauteur) {
		super(x, y, theta);
		this.largeur = largeur;
		this.hauteur = hauteur;
	}
	Rectangle(Posture posture,double largeur,double hauteur){
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
		//if()
		return false;
	}
	public boolean collisionExterne(Cercle cercle){
		return false;
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
}
