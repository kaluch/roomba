package roomba;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JPanel;


public class CapteurContactTache extends CapteurContact {
	
	protected double diametre;
	CapteurContactTache(Forme forme, double diametre) {
		super(forme);
		this.diametre = diametre;
	}

	@Override
	public void miseAjour(Environnement environ) {
			for (Tache x : environ.getTaches() )
				contact = x.collision((Vecteur2D) forme.getPosture().getPosition());
	}
	/*public void paint(Graphics2D g2,JPanel pan,int diametre,int facteurEchelle) {
		int rayon = 3;		
		g2.setColor(Color.BLUE);
		if(contact)
			g2.setColor(Color.CYAN);
		g2.fillOval(getPosxPix(facteurEchelle)+pan.getWidth()/2+diametre/2-rayon,getPosyPix(facteurEchelle)+pan.getHeight()/2+diametre/2-rayon, 2*rayon,2*rayon);
		
	}
*/


}
