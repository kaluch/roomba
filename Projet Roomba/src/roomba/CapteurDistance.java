package roomba;

import java.awt.Color;
import java.awt.Graphics2D;



public class CapteurDistance extends Capteur {

	protected double distance;
	protected double orientation;

	
	CapteurDistance(Forme forme,double orientation){
		super(forme);
		this.orientation = orientation;
		distance = 10;
	}

	@Override
	public void miseAjour(Environnement environ) {
		double distTemp = 10;
		double distTemp2 = 10;
		double distTemp3 = 10;
		if(environ.getArene().getForme() instanceof Cercle){
			 distTemp2 = contactCercle((Cercle)environ.getArene().getForme());
		}
		else if(environ.getArene().getForme() instanceof Carre || environ.getArene().getForme() instanceof Rectangle )
			distTemp2 = contactRectangleCarre(environ.getArene().getForme());
		for(Obstacle x : environ.getObstacles())
		{
			if(x.getForme() instanceof Cercle)
				distTemp3 = Math.min(distTemp3,contactCercle((Cercle)x.getForme()));
		}
		distance = Math.min(distTemp, Math.min(distTemp2, distTemp3));
		System.out.println(distance);
	}

	private double contactRectangleCarre(Forme forme){
		double distTemp = 10;
		double largeur = 0;
		double hauteur = 0;
		if(forme instanceof Rectangle){
			largeur = ((Rectangle) forme).getLargeur();
			hauteur = ((Rectangle) forme).getHauteur();			
		}
		else if(forme instanceof Carre){
			largeur = ((Carre) forme).getCote();
			hauteur = largeur;
		}
		else return distTemp;
		Vecteur2D O = new Vecteur2D(getForme().getPosture().getX(),getForme().getPosture().getY());
		Vecteur2D P = new Vecteur2D(forme.getPosture().getX()+10*Math.cos(forme.getPosture().getTheta()),
									forme.getPosture().getY()+10*Math.sin(forme.getPosture().getTheta()));
		Vecteur2D A = new Vecteur2D(forme.getPosture().getX(),forme.getPosture().getY());
		Vecteur2D B = new Vecteur2D(forme.getPosture().getX(),forme.getPosture().getY()+hauteur);
		Vecteur2D C = new Vecteur2D(forme.getPosture().getX()+largeur,forme.getPosture().getY()+hauteur);
		Vecteur2D D = new Vecteur2D(forme.getPosture().getX()+largeur,forme.getPosture().getY());
		
		if(!collisionSegDroite(A,B,O,P)||!collisionSegDroite(O,P,A,B)){
			Vecteur2D AB = B.moins(A);
			Vecteur2D OP = P.moins(O);
			double k =-( A.det(OP)+OP.det(O))/(AB.det(OP));
			if(k>0 || k<1)
				distTemp = Math.min(distTemp,OP.norme()*( AB.det(A)-AB.det(O))/(AB.det(OP)));
		}
		if(!collisionSegDroite(A,D,O,P)||!collisionSegDroite(O,P,A,D)){
			Vecteur2D AD = D.moins(A);
			Vecteur2D OP = P.moins(O);
			double k =-( A.det(OP)+OP.det(O))/(AD.det(OP));
			if(k>0 || k<1)
				distTemp = Math.min(distTemp,OP.norme()*( AD.det(A)-AD.det(O))/(AD.det(OP)));
		}
		if(!collisionSegDroite(C,B,O,P)||!collisionSegDroite(O,P,C,B)){
			Vecteur2D CB = B.moins(C);
			Vecteur2D OP = P.moins(O);
			double k =-( C.det(OP)+OP.det(O))/(CB.det(OP));
			if(k>0 || k<1)
				distTemp = Math.min(distTemp,OP.norme()*( CB.det(A)-CB.det(O))/(CB.det(OP)));
		}
		if(!collisionSegDroite(C,D,O,P)||!collisionSegDroite(O,P,C,D)){
			Vecteur2D CD = D.moins(C);
			Vecteur2D OP = P.moins(O);
			double k =-( C.det(OP)+OP.det(O))/(CD.det(OP));
			if(k>0 || k<1)
				distTemp = Math.min(distTemp,OP.norme()*( CD.det(A)-CD.det(O))/(CD.det(OP)));
		}		
		return distTemp;
	}
	private boolean collisionSegDroite(Vecteur2D A,Vecteur2D B, Vecteur2D O, Vecteur2D P){
		Vecteur2D AP = P.moins(A);
		Vecteur2D AB = B.moins(A);
		Vecteur2D AO = O.moins(A);
		return (AB.det(AP)*AB.det(AO)<0)?false:true;
			
	}

	
	private double contactCercle(Cercle cercle){
		double distTemp = 10;
		
				Vecteur2D u = new Vecteur2D(10*Math.cos(forme.getPosture().getTheta()),10*Math.sin(forme.getPosture().getTheta()));
				Vecteur2D ac = new Vecteur2D(cercle.getPosture().getX()-forme.getPosture().getX(),
						cercle.getPosture().getY()-forme.getPosture().getY());
				double num = Math.abs( u.getX()*ac.getY() - u.getY()*ac.getX());
				double den = u.norme();
				double ci = num/den;
				if(ci>=cercle.getDiametre()/2)
					return distTemp;
				else{
					Vecteur2D bc = new Vecteur2D(cercle.getPosture().getX()-forme.getPosture().getX()+10*Math.cos(forme.getPosture().getTheta()),
							cercle.getPosture().getY()-forme.getPosture().getY()+10*Math.sin(forme.getPosture().getTheta()));
					double pscal1 = u.getX()*ac.getX() + u.getY()*ac.getY(); 
					double pscal2 = (u.getX())*bc.getX() + (u.getY())*bc.getY();
					if((pscal1 >= 0 && pscal2 >=0)|| ac.norme() <= cercle.getDiametre()/2 ){
						double ti = (u.getX()*ac.getX() + u.getY()*ac.getY())/(Math.pow(u.norme(), 2));
						Vecteur2D ai = new Vecteur2D(ti*u.getX(),ti*u.getY());
						Vecteur2D ca = new Vecteur2D(-ac.getX(),-ac.getY());
						Vecteur2D cif = new Vecteur2D(ca.plus(ai));
						double norme = ai.norme() - Math.sqrt(Math.pow(cercle.getDiametre()/2, 2)-
																Math.pow(cif.norme(),2));
						distTemp = (distTemp<norme)? distTemp : norme;
					}		
				}
			
		
		return distTemp;
	}
	@Override
	public double lecture() {
		return distance;
	}
	public String toString(){
		return forme.toString()+ " " +String.valueOf(distance);
	}
	@Override
	public void draw(Graphics2D g2, int facteurEchelle, int centrex, int centrey) {
		g2.setColor(Color.BLACK); 
		forme.paint(g2, facteurEchelle, centrex, centrey);
		g2.setColor(Color.RED); 
		g2.drawLine((int)(forme.getPosture().getX() * facteurEchelle) + centrex,
				(int)(forme.getPosture().getY() * facteurEchelle) + centrey,
				(int)((forme.getPosture().getX()+distance*Math.cos(forme.getPosture().getTheta()))*facteurEchelle)+centrex,
				(int)((forme.getPosture().getY()+distance*Math.sin(forme.getPosture().getTheta()))*facteurEchelle)+centrey);
	}
	protected void setPosition(Polair posRel,Posture origine){
		super.setPosition(posRel, origine);
		forme.getPosture().setTheta( orientation +origine.getTheta());		
	}
	protected void setPosRel(Vecteur origine){
		super.setPosRel(origine);
	}
	public double getDistance() {		return distance;	}
	public void setDistance(double distance) {		this.distance = distance;	}
	public double getOrientation() {		return orientation;	}
	public void setOrientation(double orientation) {		this.orientation = orientation;	}

}
