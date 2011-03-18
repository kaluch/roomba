package roomba;


public class Roomba extends Robot {

	protected double diametre;
public Roomba(double diametre,Comportement comportement) {
			super(new Cercle(0,0,0,diametre));
			setDiametre(diametre);
			posture = new PostureRobot(0,0,0);
			
			this.roues.add(new Roue());
			this.roues.add(new Roue());
			
			this.capteurs.add(new CapteurContactObstacle(
					new Cercle(diametre/4*Math.cos(0)+posture.getPosition().getX(),
							diametre/4*Math.sin(0)+posture.getPosition().getY(),0,0.195),
							diametre/2*Math.PI/6,diametre));
			this.capteurs.add(new CapteurContactObstacle(new Cercle(
					diametre/4*Math.cos(Math.PI/3)+posture.getPosition().getX(),
					diametre/4*Math.sin(Math.PI/3)+posture.getPosition().getY(),0,0.195),
					diametre/2*Math.PI/6,diametre));
			this.capteurs.add(new CapteurContactObstacle(new Cercle(
					diametre/4*Math.cos(-Math.PI/3)+posture.getPosition().getX(),
					diametre/4*Math.sin(-Math.PI/3)+posture.getPosition().getY(),0,0.195),
					diametre/2*Math.PI/6,diametre));
			this.comportement = comportement;
			
		/*	this.capteurs.add(new CapteurDistance(
					new Cercle(diametre*Math.cos(0)+posture.getPosition().getX(),
							diametre*Math.sin(0)+posture.getPosition().getY(),0,0.195),
							diametre/2*Math.PI/6));*/
			//this.capteurs.add(new CapteurDistance(new Vecteur2D(diametre/2*Math.cos(Math.PI/6),diametre/2*Math.sin(Math.PI/6)),0));
			
			this.capteurs.add(new CapteurContactTache(new Cercle(0,0,0,0.195),0.05));
			for(Capteur x : capteurs)
				x.setPosRel(posture.getPosition());
			
// Constructeur a finir ?
		
	}
	
	public double getDiametre() {		return diametre;	}
	public void setDiametre(double diametre) {		this.diametre = diametre;	}
	public void move(double to,Environnement environ){
		for (Capteur x : capteurs){
			x.miseAjour(environ);
			System.out.println(x.toString());
			}
		comportement.calcul(capteurs);
		this.calculVitesseRoue(comportement);
		posture.move(roues.get(0).getVitesse()*to , roues.get(1).getVitesse()*to, diametre);
		forme.setPosture(posture);
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
	public int getDiametrePix(int facteurEchelle){ return (int) (facteurEchelle * diametre) ; }
	public int getPosxPix(int facteurEchelle){ return (int) (posture.getX() * facteurEchelle) ; }
	public int getPosyPix(int facteurEchelle){ return (int) (posture.getY() * facteurEchelle) ; }
	
}
