package roomba;

import java.awt.Graphics2D;
import java.awt.Color;
public class Tache{

	Forme forme;
	
	Tache(Forme forme){
		this.forme = forme;
	}

	public boolean collision(Vecteur2D position) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void paint(Graphics2D g2,int facteurEchelle,int centrex,int centrey){
		g2.setColor(Color.DARK_GRAY);
		forme.paint(g2,facteurEchelle,centrex,centrey);
		//g2.fillRect((int)(this.getPosture().getX()-this.dimension),(int) (this.getPosture().getY()-this.dimension),(int) dimension*2, (int)dimension*2);
	}

	public Forme getForme() {		return forme;	}
	public void setForme(Forme forme) {		this.forme = forme;	}
}
