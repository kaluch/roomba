package roomba;

import java.awt.Color;
import java.awt.Graphics2D;


public  class Obstacle{

	protected Forme forme;
	
	
	Obstacle(Forme forme) {
		this.forme = forme;
	}
	

	public void paint(Graphics2D g2,int facteurEchelle){
		g2.setColor(Color.red);
		forme.paint(g2,facteurEchelle);
	}


}
