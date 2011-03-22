package roomba;

import java.util.ArrayList;
import java.util.Random;

public class Hazard extends Comportement  {
	protected int rotate=0;
	protected int changeDirection=100;
	Random rand = new Random();
	protected boolean turnLeft = rand.nextBoolean();
	@Override
	void calcul(ArrayList<Capteur> capteurs) {
		
		int comportement = 0;
		boolean contact = false;
		boolean tache = false;
		for(Capteur x : capteurs){
			if(x instanceof CapteurContactObstacle)
				contact = contact || x.lecture()==1;
			if(x instanceof CapteurContactTache)
				tache = tache || x.lecture()==1;
			if(tache)
				comportement = 1;
			if(contact)
				comportement = 2;
		}
		if(contact && rotate == 0){
			rotate = rand.nextInt(70);
		}
		if(comportement == 1)
		{
			iL = 0;
			iR = 0;
		}
		
		else if(rotate!=0){
			if(turnLeft){
				iL = -0.5;
				iR = 0.5;
			}
			else{
				iL = 0.5;
				iR = -0.5;
			}
			rotate--;
			if(rotate ==0){
				turnLeft = rand.nextBoolean();
			}
		}
		else{
			changeDirection--;
			if(changeDirection == 0){
				rotate = rand.nextInt(70);
			}
			iL = 1;
			iR = 1;
		}
			

	}
	@Override
	public Object clone() {
		Hazard o = null;
		o = (Hazard) super.clone();
		o.rotate = rotate;
		o.changeDirection = changeDirection;
		o.turnLeft = turnLeft;
		return o;
	}

}
