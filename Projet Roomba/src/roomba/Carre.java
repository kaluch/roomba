package roomba;

import java.awt.Graphics2D;

public class Carre extends Forme {

	protected double cote;
	Carre(double x, double y, double theta,double cote) {
		super(x, y, theta);
		this.cote = cote;
		// TODO Auto-generated constructor stub
	}
	Carre(Posture posture,double cote){
		super(posture);
		this.cote = cote;
	}
	@Override
	void paint(Graphics2D g2,int facteurEchelle,int centrex,int centrey) {
		g2.fillRect(centrex+getxPix(facteurEchelle)-(int)(cote*facteurEchelle/2),centrey+getyPix(facteurEchelle)-(int)(cote*facteurEchelle/2),(int)(facteurEchelle*cote),(int) (facteurEchelle*cote));
	}
	@Override
	void draw(Graphics2D g2, int facteurEchelle,int centrex,int centrey) {
		g2.drawRect(centrex+getxPix(facteurEchelle)-(int)(cote*facteurEchelle/2),centrey+getyPix(facteurEchelle)-(int)(cote*facteurEchelle/2),(int)(facteurEchelle*cote),(int) (facteurEchelle*cote));
		
	}
	
	public boolean collisionInterne(Carre carre){
		return ((carre.getPosture().getY() <= getPosture().getY())
				||(carre.getPosture().getX() <=getPosture().getX())
				||(carre.getPosture().getX()+carre.getCote()>= getPosture().getX()+getCote())
				||(carre.getPosture().getY()+carre.getCote()>= getPosture().getY()+getCote()))? true : false;
	}
	public boolean collisionExterne(Carre carre){
		return ((carre.getPosture().getX()>=getPosture().getX()+cote )
				||(carre.getPosture().getX()+carre.getCote()<= getPosture().getX())
				||(carre.getPosture().getY()>=getPosture().getY()+cote)
				||(carre.getPosture().getY()+carre.getCote()<=getPosture().getY()))? false : true;
				
	}
	public boolean collisionInterne(Cercle cercle){
		//if()
		return false;
	}
	public boolean collisionExterne(Cercle cercle){
		double xm = (cercle.getPosture().getX() <= getPosture().getX())?getPosture().getX() : (cercle.getPosture().getX() <= getPosture().getX()+getCote())?cercle.getPosture().getX() : getPosture().getX()+getCote();
		double ym = (cercle.getPosture().getY() <= getPosture().getY())?getPosture().getY() : (cercle.getPosture().getY() <= getPosture().getY()+getCote())?cercle.getPosture().getY() : getPosture().getY()+getCote();
		return (Math.pow(cercle.getPosture().getX()-xm,2)+ Math.pow(cercle.getPosture().getY()-ym,2)<=cercle.getDiametre()* cercle.getDiametre()/4)?true:false;
	}
	public boolean collisionInterne(Rectangle rectangle){
		return ((rectangle.getPosture().getY() <= getPosture().getY())
				||(rectangle.getPosture().getX() <= getPosture().getX())
				||(rectangle.getPosture().getX()+rectangle.getLargeur()>= getPosture().getX()+getCote())
				||(rectangle.getPosture().getY()+rectangle.getHauteur()>= getPosture().getY()+getCote()))? true : false;
	}
	public boolean collisionExterne(Rectangle rectangle){
		return ((rectangle.getPosture().getX()>=getPosture().getX()+cote )
				||(rectangle.getPosture().getX()+rectangle.getLargeur()<= getPosture().getX())
				||(rectangle.getPosture().getY()>=getPosture().getY()+cote)
				||(rectangle.getPosture().getY()+rectangle.getHauteur()<=getPosture().getY()))? false : true;
	}
	public double getCote() {		return cote;	}
	public void setCote(double cote) {		this.cote = cote;	}
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
