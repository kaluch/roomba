package roomba;

public class CapteurDistance extends Capteur {

	protected double distance;
	protected double alpha;
	
	CapteurDistance(Vecteur position,double alpha){
		super(position);
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
		return position.toString()+ " " +String.valueOf(distance);
	}

}
