package roomba;

import java.awt.Graphics2D;
import java.awt.Color;
public class Tache extends Forme{

	Tache(double x, double y,int dim) {
		super(4,x,y,0,dim);
		// TODO Auto-generated constructor stub
	}

	public boolean collision(Vecteur2D position) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void paint(Graphics2D g2){
		g2.setColor(Color.DARK_GRAY);
		g2.fillRect((int)(this.getPosture().getX()-this.dimension),(int) (this.getPosture().getY()-this.dimension),(int) dimension*2, (int)dimension*2);
	}
	

}
