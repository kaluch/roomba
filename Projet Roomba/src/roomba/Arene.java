package roomba;

import java.awt.Color;
import java.awt.Graphics2D;


public  class Arene{

	protected Forme forme;
	
	Arene(Forme forme){
		this.forme = forme;
	}

	public Forme getForme() {		return forme;	}
	public void setForme(Forme forme) {		this.forme = forme;	}
	
	public void draw(Graphics2D g2,int facteurEchelle){
		g2.setColor(Color.BLACK);
		forme.draw(g2,facteurEchelle);
	}
}
