package roomba;

public class Roomba extends Robot {

	protected double diametre;
	public Roomba(double diametre) {
			super();
			setDiametre(diametre);
			posture = new PostureRobot(getDiametre()/2,getDiametre()/2,0);
			
			this.roues.add(new Roue());
			this.roues.add(new Roue());
			
			this.capteurs.add(new CapteurContactObstacle(posture.getPosition().plus(new Vecteur2D(diametre/2*Math.cos(Math.PI/4),diametre/2*Math.sin(Math.PI/4))),diametre/2*Math.PI/4,diametre/2));
			this.capteurs.add(new CapteurContactObstacle(posture.getPosition().plus(new Vecteur2D(diametre/2*Math.cos(3*Math.PI/4),diametre/2*Math.sin(3*Math.PI/4))),diametre/2*Math.PI/4,diametre/2));
			this.capteurs.add(new CapteurContactObstacle(posture.getPosition().plus(new Vecteur2D(diametre/2*Math.cos(5*Math.PI/4),diametre/2*Math.sin(5*Math.PI/4))),diametre/2*Math.PI/4,diametre/2));
			this.capteurs.add(new CapteurContactObstacle(posture.getPosition().plus(new Vecteur2D(diametre/2*Math.cos(7*Math.PI/4),diametre/2*Math.sin(7*Math.PI/4))),diametre/2*Math.PI/4,diametre/2));
	
			this.capteurs.add(new CapteurContactTache(new Vecteur2D(posture.getPosition())));
			for(int i=0;i<capteurs.size();++i)
				this.positionRelCapteurs.add(positionRel(capteurs.get(i).getPosition()));
// Constructeur � finir
		
	}
	private Double positionRel(Vecteur vecteur) {
		Vecteur temp = new Vecteur2D(diametre/2,0);
		return new Double(temp.angle()-vecteur.angle());
	}
	public double getDiametre() {		return diametre;	}
	public void setDiametre(double diametre) {		this.diametre = diametre;	}
	public void move(double to){
		posture.move(roues.get(0).getVitesse()*to , roues.get(1).getVitesse()*to, diametre);
		for(int i=0;i<capteurs.size();++i)
			capteurs.get(i).setPosition(positionCapteur(positionRelCapteurs.get(i)));
	}
	private Vecteur positionCapteur(Double alpha) {
			
		return new Vecteur2D(posture.getX()+(diametre/2)*Math.cos(alpha+posture.getTheta()),posture.getY()+(diametre/2)*Math.sin(alpha+posture.getTheta()));
	}
	public void calculVitesseRoue(Comportement comportement){
		setVitesseRoue1(comportement.vitesseRoue1());
		setVitesseRoue2(comportement.vitesseRoue2());
		
	}
	public String toString(){ return String.valueOf(posture.getX())+" "+String.valueOf(posture.getY())+" "+String.valueOf(posture.getTheta()) ;
	}
	private void setVitesseRoue1(double vitesse){
		
		try {
			roues.get(0).setVitesse(vitesse);
		} catch (ExceptionVitesseMax e) {
			System.out.println("Vitesse max depassé : code a écrire");
			e.printStackTrace();
		}
	}
	private void setVitesseRoue2(double vitesse){
		
		try {
			roues.get(1).setVitesse(vitesse);
		} catch (ExceptionVitesseMax e) {
			System.out.println("Vitesse max depassé : code a écrire");
			e.printStackTrace();
		}
	}
}
