package roomba;

import java.util.ArrayList;

public class EvitObstacles extends Comportement {

	EvitObstacles(){
		super();
	}

	@Override
	void calcul(ArrayList<Capteur> capteurs) {
		boolean contact = false;
		for(Capteur x : capteurs)
				contact = contact || x.lecture()==1;
		if(contact){
			iL = 0.5;
			iR = -0.5;
		}else{
			iL = 0.3;
			iR = 0.3;
		}
	}
	
}
