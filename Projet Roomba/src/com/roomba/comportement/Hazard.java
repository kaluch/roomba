package com.roomba.comportement;

import java.util.ArrayList;
import java.util.Random;

import com.roomba.robot.*;
/**
 * Behavior which allows the robot to use the laser sensor to determine the best trajectory
 * Partly random to determine the rotation
 * @author Lucas
 *
 */
public class Hazard extends Comportement {
	protected int rotate = 0;
	protected int changeDirection = 100;
	Random rand = new Random();
	protected boolean turnLeft = false;

	@Override
	public
	void calcul(ArrayList<Capteur> capteurs) {

		boolean contact = false;
		boolean tache = false;
		for (Capteur x : capteurs) {
			if (x instanceof CapteurContactObstacle)
				contact = contact || x.lecture() == 1;
			if (x instanceof CapteurContactTache)
				tache = tache || x.lecture() == 1;
		}
		if (contact && rotate == 0) {
			rotate = rand.nextInt(30);
		}

		else if (rotate != 0) {
			if (turnLeft) {
				iL = -1;
				iR = 1;
			} else {
				iL = 1;
				iR = -1;
			}
			rotate--;
			if (rotate == 0) {
				if (capteurs.get(4).lecture() - capteurs.get(5).lecture() > 0)
					turnLeft = false;
				else
					turnLeft = true;
			}
		} else {
			changeDirection--;
			if (changeDirection == 0) {
				rotate = rand.nextInt(70);
				changeDirection = 600;
			}
			if (capteurs.get(4).lecture() - capteurs.get(5).lecture() > 0.1) {
				if (capteurs.get(5).lecture() < 0.3) {
					iL = 1;
					iR = 0.1;
				} else {
					iL = 1;
					iR = 0.6;
				}
			} else if (capteurs.get(5).lecture() - capteurs.get(4).lecture() > 0.1) {
				if (capteurs.get(4).lecture() < 0.3) {
					iR = 1;
					iL = 0.1;
				} else {
					iR = 1;
					iL = 0.6;
				}
			} else {
				iL = 1;
				iR = 1;
			}
		}

		if (tache) {
			iL *= 0.5;
			iR *= 0.5;
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
