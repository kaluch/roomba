package roomba;

import java.awt.Graphics2D;

import javax.swing.JPanel;


public abstract class Capteur {

	protected Vecteur position;
	protected Polair posRel;
	protected int facteurEchelle;
	abstract public void miseAjour(Environnement environ);
	abstract public double lecture();
	
	Capteur(Vecteur position){
		this.position = position;
		posRel = new Polair();
		facteurEchelle = 150;
		
	}
	Capteur(Vecteur position,int facteurEchelle){
		this.position = position;
		this.facteurEchelle = facteurEchelle;
		posRel = new Polair();
	}
	protected void setPosRel(Vecteur origine){
		posRel.setTheta(position.angle()-origine.angle() );
		posRel.setRho(Math.sqrt(Math.pow(((Vecteur2D)position).getX() - ((Vecteur2D)origine).getX(), 2)+ Math.pow(((Vecteur2D)position).getY() - ((Vecteur2D)origine).getY(), 2)));
	}
	public Polair getPosRel() {		return posRel;	}
	public void setPosRel(Polair posRel) {		this.posRel = posRel;	}
	public int getFacteurEchelle() {		return facteurEchelle;	}
	public void setFacteurEchelle(int facteurEchelle) {		this.facteurEchelle = facteurEchelle;	}
	public void setPosition(Vecteur position) { this.position = position;	}
	public Vecteur getPosition() {	return position;	}
	abstract void paint(Graphics2D g2, JPanel pan,int diametre);
	protected int getPosxPix(){ return (int)(((Vecteur2D)position).getX()*facteurEchelle); }
	protected int getPosyPix(){ return (int)(((Vecteur2D)position).getY()*facteurEchelle); }
	protected void setPosition(Polair posRel,Posture origine){
		((Vecteur2D) position).setX(origine.getX() + posRel.getRho()*Math.cos(posRel.getTheta()+origine.getTheta()));
		((Vecteur2D) position).setY(origine.getY() + posRel.getRho()*Math.sin(posRel.getTheta()+origine.getTheta()));
	}
}
