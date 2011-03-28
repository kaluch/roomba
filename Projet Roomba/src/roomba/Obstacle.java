package roomba;

import java.awt.Color;
import java.awt.Graphics2D;


public  class Obstacle{

	protected Forme forme;
	
	
	public Obstacle(Forme forme) {
		this.forme = forme;
	}
	

	public Forme getForme() {		return forme;	}
	public void setForme(Forme forme) {		this.forme = forme;	}

	public void paint(Graphics2D g2,int facteurEchelle,int centrex,int centrey){
		g2.setColor(Color.LIGHT_GRAY);
		forme.paint(g2,facteurEchelle,centrex,centrey);
		g2.setColor(Color.BLACK);
		forme.draw(g2,facteurEchelle,centrex,centrey);
	}





}
