package roomba;

import java.util.ArrayList;

public class EvitObstacles extends Comportement {

	EvitObstacles(){
		super();
	}

	@Override
	void calcul(ArrayList<Capteur> capteurs) {
		int comportement = 0;
		int sens = 1;
		boolean contact = false;
		boolean tache = false;
		for(Capteur x : capteurs){
			if(x instanceof CapteurContactObstacle)
				contact = contact || x.lecture()==1;
			if(x instanceof CapteurContactTache)
				tache = tache || x.lecture()==1;//comportement = 1;
			if(tache)
				comportement = 1;
			if(contact)
				comportement = 2;
		}
		switch (comportement){
		case 2 :
			iL = 0.5;
			iR = -0.5;
			break;
		case 0:
			iL = 0.5;
			iR = 0.5;
			break;
		case 1:
			iL = 0;
			iR = 0;
			break;
		}
	}
	
}
