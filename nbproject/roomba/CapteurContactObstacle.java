

public class CapteurContactObstacle extends CapteurContact {
	
	protected double perimetre;
	protected double diametre;

	CapteurContactObstacle(Vecteur position,double perimetre,double diametre){
		super(position);
		this.perimetre = perimetre;
		this.diametre= diametre;
	}
	CapteurContactObstacle(Vecteur position){
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
				contact = x.collision((Vecteur2D) position);
	}
	

}
