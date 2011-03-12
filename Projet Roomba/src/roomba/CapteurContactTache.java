package roomba;


public class CapteurContactTache extends CapteurContact {
	
	protected double diametre;
	CapteurContactTache(Vecteur position, double diametre) {
		super(position);
		this.diametre = diametre;
	}

	@Override
	public void miseAjour(Environnement environ) {
			for (Tache x : environ.getTaches() )
				contact = x.collision((Vecteur2D) position);
	}

	

}
