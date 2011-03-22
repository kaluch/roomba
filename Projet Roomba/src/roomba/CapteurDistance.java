package roomba;

import java.awt.Color;
import java.awt.Graphics2D;



public class CapteurDistance extends Capteur {

	protected double distance;
	protected double alpha;
	protected double alphaRel;
	
	CapteurDistance(Forme forme,double alpha){
		super(forme);
		distance = 10000;
		this.alpha = alpha;
	}

	@Override
	public void miseAjour(Environnement environ) {
		// TODO parcourir environ et recuperer les distances

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
				(int)((forme.getPosture().getX()+100*Math.cos(forme.getPosture().getTheta()))*facteurEchelle)+centrex,
				(int)((forme.getPosture().getY()+100*Math.sin(forme.getPosture().getTheta()))*facteurEchelle)+centrey);
	}
	protected void setPosition(Polair posRel,Posture origine){
		super.setPosition(posRel, origine);
		forme.getPosture().setTheta(alphaRel + origine.getTheta());
		
	}
	protected void setPosRel(Vecteur origine){
		super.setPosRel(origine);
		alphaRel = alpha - ((Vecteur2D) origine).angle();
	}
	public double getDistance() {		return distance;	}
	public void setDistance(double distance) {		this.distance = distance;	}
	public double getAlpha() {		return alpha;	}
	public void setAlpha(double alpha) {		this.alpha = alpha;	}

}
