package roomba;


public class Roomba extends Robot {

	protected double diametre;
	private int facteurEchelle;
	public Roomba(double diametre) {
			super();
			setDiametre(diametre);
			facteurEchelle = 150;
			posture = new PostureRobot(0,0,0);
			
			this.roues.add(new Roue());
			this.roues.add(new Roue());
			
			this.capteurs.add(new CapteurContactObstacle(posture.getPosition().plus(new Vecteur2D(diametre/2*Math.cos(0),diametre/2*Math.sin(0))),diametre/2*Math.PI/6,diametre));
			this.capteurs.add(new CapteurContactObstacle(posture.getPosition().plus(new Vecteur2D(diametre/2*Math.cos(-Math.PI/3),diametre/2*Math.sin(-Math.PI/3))),diametre/2*Math.PI/6,diametre));
			this.capteurs.add(new CapteurContactObstacle(posture.getPosition().plus(new Vecteur2D(diametre/2*Math.cos(Math.PI/3),diametre/2*Math.sin(Math.PI/3))),diametre/2*Math.PI/6,diametre));
			
			this.capteurs.add(new CapteurDistance(new Vecteur2D(diametre/2*Math.cos(-Math.PI/6),diametre/2*Math.sin(-Math.PI/6)),0));
			this.capteurs.add(new CapteurDistance(new Vecteur2D(diametre/2*Math.cos(Math.PI/6),diametre/2*Math.sin(Math.PI/6)),0));
			
			this.capteurs.add(new CapteurContactTache(new Vecteur2D(posture.getPosition()),0.5));
			for(Capteur x : capteurs)
				x.setPosRel(posture.getPosition());
// Constructeur a finir ?
		
	}
	
	public double getDiametre() {		return diametre;	}
	public void setDiametre(double diametre) {		this.diametre = diametre;	}
	public void move(double to){
		posture.move(roues.get(0).getVitesse()*to , roues.get(1).getVitesse()*to, diametre);
		for(Capteur x : capteurs)
			x.setPosition(x.getPosRel(),posture);
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
	public int getDiametrePix(){ return (int) (facteurEchelle * diametre) ; }
	public int getPosxPix(){ return (int) (posture.getX() * facteurEchelle) ; }
	public int getPosyPix(){ return (int) (posture.getY() * facteurEchelle) ; }
	
}
