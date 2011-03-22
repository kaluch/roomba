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
		for(Obstacle x : environ.getObstacles())
		{
			if(x.getForme() instanceof Cercle)
				distTemp3 = Math.min(distTemp3,contactCercle((Cercle)x.getForme()));
		}
		distance = Math.min(distTemp, Math.min(distTemp2, distTemp3));
		System.out.println(distance);
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
