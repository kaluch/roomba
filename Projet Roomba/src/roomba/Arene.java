package roomba;

import java.awt.Color;
import java.awt.Graphics2D;

public class Arene implements Cloneable {

	protected Forme forme;

	public Arene(Forme forme) {
		this.forme = forme;
	}

	public Forme getForme() {
		return forme;
	}

	public void setForme(Forme forme) {
		this.forme = forme;
	}

	public void draw(Graphics2D g2, int facteurEchelle, int centrex, int centrey) {
		g2.setColor(Color.BLACK);
		g2.fillRect(-centrex, -centrey, 3 * centrex, 3 * centrey);
		g2.setColor(Color.WHITE);
		forme.paint(g2, facteurEchelle, centrex, centrey);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Arene o = (Arene) super.clone();
		o.forme = (Forme) forme.clone();
		return o;
	}

}
