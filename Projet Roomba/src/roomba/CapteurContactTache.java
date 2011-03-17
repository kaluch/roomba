package roomba;

import java.awt.Color;
import java.awt.Graphics2D;


public class CapteurContactTache extends CapteurContact {
	
	protected double diametre;
	CapteurContactTache(Forme forme, double diametre) {
		super(forme);
		this.diametre = diametre;
	}

	@Override
	public void miseAjour(Environnement environ) {
			for (Tache x : environ.getTaches() )
				contact = forme.collisionExterne(x.getForme());
	}
	@Override
	public void draw(Graphics2D g2, int facteurEchelle, int centrex, int centrey) {
		if(contact)g2.setColor(Color.BLUE); g2.setColor(Color.GREEN);
		forme.draw(g2, facteurEchelle, centrex, centrey);
	}



}
