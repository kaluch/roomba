

public class Roomba extends Robot {

	protected double diametre;
	public Roomba(double diametre) {
			super();
			setDiametre(diametre);
			posture = new PostureRobot(0,0,0);
			
			this.roues.add(new Roue());
			this.roues.add(new Roue());
			
			this.capteurs.add(new CapteurContactObstacle(posture.getPosition().plus(new Vecteur2D(diametre/2*Math.cos(0),diametre/2*Math.sin(0))),diametre/2*Math.PI/6,diametre));
			this.capteurs.add(new CapteurContactObstacle(posture.getPosition().plus(new Vecteur2D(diametre/2*Math.cos(-Math.PI/3),diametre/2*Math.sin(-Math.PI/3))),diametre/2*Math.PI/6,diametre));
			this.capteurs.add(new CapteurContactObstacle(posture.getPosition().plus(new Vecteur2D(diametre/2*Math.cos(Math.PI/3),diametre/2*Math.sin(Math.PI/3))),diametre/2*Math.PI/6,diametre));
	
			this.capteurs.add(new CapteurContactTache(new Vecteur2D(posture.getPosition()),0.5));
			for(int i=0;i<capteurs.size();++i)
				this.positionRelCapteurs.add(positionRel(capteurs.get(i).getPosition()));
// Constructeur a finir ?
		
	}
	private Double positionRel(Vecteur vecteur) {
		return new Double(vecteur.angle());
	}
	public double getDiametre() {		return diametre;	}
	public void setDiametre(double diametre) {		this.diametre = diametre;	}
	public void move(double to){
		posture.move(roues.get(0).getVitesse()*to , roues.get(1).getVitesse()*to, diametre);
		for(int i=0;i<capteurs.size();++i)
			capteurs.get(i).setPosition(positionCapteur(positionRelCapteurs.get(i),capteurs.get(i)));
	}
	private Vecteur positionCapteur(Double alpha, Capteur capteur) {
			if(capteur instanceof CapteurContactObstacle )
		return new Vecteur2D(posture.getX()+(((CapteurContactObstacle)capteur).getDiametre()/2)*Math.cos(alpha+posture.getTheta()),posture.getY()+(((CapteurContactObstacle)capteur).getDiametre()/2)*Math.sin(alpha+posture.getTheta()));
			else
				return new Vecteur2D(posture.getPosition());
	}
	public void calculVitesseRoue(Comportement comportement){
		setVitesseRoue1(comportement.vitesseRoueR());
		setVitesseRoue2(comportement.vitesseRoueL());
		
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
