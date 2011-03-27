package roomba;

import java.awt.Graphics2D;

public class Carre extends Forme implements Cloneable {

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
		return ((cercle.getPosture().getY()-cercle.getDiametre()/2 <= getPosture().getY()-getCote()/2)
			|| (cercle.getPosture().getX()-cercle.getDiametre()/2 <= getPosture().getX()-getCote()/2)
			||(cercle.getPosture().getY()+cercle.getDiametre()/2 >= getPosture().getY()+getCote()/2)
			|| (cercle.getPosture().getX()+cercle.getDiametre()/2 >= getPosture().getX()+getCote()/2))?
				true : false;
	
	}
	public boolean collisionExterne(Cercle cercle){
		double xm = (cercle.getPosture().getX() <= getPosture().getX()-getCote()/2)?
				getPosture().getX()-getCote()/2 :
					(cercle.getPosture().getX() <= getPosture().getX()+getCote()/2)?
							cercle.getPosture().getX() : getPosture().getX()+getCote()/2;
		double ym = (cercle.getPosture().getY() <= getPosture().getY()-getCote()/2)?
				getPosture().getY()-getCote()/2 : 
					(cercle.getPosture().getY() <= getPosture().getY()+getCote()/2)?
							cercle.getPosture().getY() : getPosture().getY()+getCote()/2;
		return (Math.sqrt(Math.pow(cercle.getPosture().getX()-xm,2)+
				Math.pow(cercle.getPosture().getY()-ym,2))
				<=cercle.getDiametre()/2)?true:false;
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
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Carre o = (Carre) super.clone();
		o.cote = cote;
		return  o;
	}
	@Override
	public Forme normalize(int facteurEchelle) {
		super.normalize(facteurEchelle);
		cote = cote/facteurEchelle;
		return this;
	}
	@Override
	public boolean collisionPoint(double x, double y) {
		return (x>posture.getX()-cote/2 && x<posture.getX()+cote/2
				&& y>posture.getY()-cote/2 && y<posture.getY()+cote/2)? true : false;	
	}
	@Override
	public void iso(double a) {
		cote*=a;		
	}
	@Override
	public int tangeantPoint(double x, double y) {
		System.out.println(Math.abs(y-posture.getY()-cote/2 )+ " " +Math.abs( y-posture.getY()+cote/2) );
		if(Math.abs(x-posture.getX()-cote/2)<=0.02)
			if (y>=posture.getY()-cote/2 || y<=posture.getY()+cote/2) return 1 ;
		if(Math.abs( x-posture.getX()+cote/2)<=0.02)
			if(y>=posture.getY()-cote/2 || y<=posture.getY()+cote/2) return 1;
		if(Math.abs(y-posture.getY()-cote/2)<=0.02)
			if(x>=posture.getX()-cote/2 || x<=posture.getX()+cote/2) return 2 ;
		if(Math.abs( y-posture.getY()+cote/2)<=0.02)
			if (x>=posture.getX()-cote/2 || x<=posture.getX()+cote/2) return 2;
		
		return 0;
	
	}
	
	
}
