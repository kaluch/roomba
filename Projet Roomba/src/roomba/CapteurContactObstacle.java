package roomba;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public class CapteurContactObstacle extends CapteurContact {
	
	protected double perimetre;
	protected double diametre;

	CapteurContactObstacle(Vecteur position,double perimetre,double diametre){
		super(position);
		this.perimetre = perimetre;
		this.diametre= diametre;
	}
	CapteurContactObstacle(Vecteur position,double perimetre,double diametre,int facteurEchelle){
		super(position,facteurEchelle);
		this.perimetre = perimetre;
		this.diametre= diametre;
	}
	CapteurContactObstacle(Vecteur position){
		super(position);
		perimetre = 0;
		diametre=0;
	}
	CapteurContactObstacle(Vecteur position,int facteurEchelle){
		super(position,facteurEchelle);
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
				contact = x.collision((Vecteur2D) position);
	}
	@Override
	public void paint(Graphics2D g2,JPanel pan,int diametre) {
		int rayon = 2;		
		g2.setColor(Color.GREEN);
		if(contact)
			g2.setColor(Color.CYAN);
		g2.fillOval(getPosxPix()+pan.getWidth()/2+diametre/2-rayon,getPosyPix()+pan.getHeight()/2+diametre/2-rayon, 2*rayon,2*rayon);
		
	}

	

}
