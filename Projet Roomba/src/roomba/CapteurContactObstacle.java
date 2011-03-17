package roomba;

import java.awt.Color;
import java.awt.Graphics2D;



public class CapteurContactObstacle extends CapteurContact {
	
	protected double perimetre;
	protected double diametre;

	CapteurContactObstacle(Forme position,double perimetre,double diametre){
		super(position);
		this.perimetre = perimetre;
		this.diametre= diametre;
	}
	
	CapteurContactObstacle(Forme position){
		super(position);
		perimetre = 0;
		diametre=0;
	}
	
	public double getPerimetre() {		return perimetre;	}
	public void setPerimetre(double perimetre) {		this.perimetre = perimetre;	}
	public double getDiametre() {		return diametre;	}
	public void setDiametre(double diametre) {		this.diametre = diametre;	}

	@Override
	public void miseAjour(Environnement environ) {
			for (Obstacle x : environ.getObstacles() )
				contact = forme.collisionExterne(x.getForme())|| environ.getArene().getForme().collisionInterne(x.getForme());
	}

	@Override
	public void draw(Graphics2D g2, int facteurEchelle, int centrex, int centrey) {
		if(contact)g2.setColor(Color.RED); g2.setColor(Color.GREEN);
		forme.draw(g2, facteurEchelle, centrex, centrey);
	}
	

	

}
