package roomba;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JPanel;


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
		// TODO parcourir environ

	}

	@Override
	public double lecture() {
		return distance;
	}
	public String toString(){
		return forme.toString()+ " " +String.valueOf(distance);
	}
	/*@Override
	void paint(Graphics2D g2, JPanel pan, int diametre,int facteurEchelle) {
		int rayon = 2;	
		int x = getPosxPix(facteurEchelle)+pan.getWidth()/2+diametre/2-rayon;
		int y = getPosyPix(facteurEchelle)+pan.getHeight()/2+diametre/2-rayon;
		g2.setColor(Color.GRAY);
		g2.fillOval(x,y, 2*rayon,2*rayon);
		g2.drawLine(x+rayon,y+rayon,(int)( x+1000*Math.cos(alpha)),(int)(y+1000*Math.sin(alpha)));
	}*/
	protected void setPosition(Polair posRel,Posture origine){
		super.setPosition(posRel, origine);
		setAlpha(alphaRel + origine.getTheta());
		
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
