package roomba;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public class CapteurContactTache extends CapteurContact {
	
	protected double diametre;
	CapteurContactTache(Vecteur position, double diametre) {
		super(position);
		this.diametre = diametre;
	}
	CapteurContactTache(Vecteur position, double diametre,int facteurEchelle) {
		super(position,facteurEchelle);
		this.diametre = diametre;
	}

	@Override
	public void miseAjour(Environnement environ) {
			for (Tache x : environ.getTaches() )
				contact = x.collision((Vecteur2D) position);
	}
	public void paint(Graphics2D g2,JPanel pan,int diametre) {
		int rayon = 3;		
		g2.setColor(Color.BLUE);
		if(contact)
			g2.setColor(Color.CYAN);
		g2.fillOval(getPosxPix()+pan.getWidth()/2+diametre/2-rayon,getPosyPix()+pan.getHeight()/2+diametre/2-rayon, 2*rayon,2*rayon);
		
	}



}
