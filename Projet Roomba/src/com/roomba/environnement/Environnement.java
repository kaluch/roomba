package com.roomba.environnement;

import java.util.ArrayList;
import java.util.Collection;
import com.roomba.shape.*;

/**
 * The environment represents the environment of the robot
 * @author Lucas
 *
 */
public class Environnement implements Cloneable {

	// ATTRIBUTS
	protected Arene arene;
	protected ArrayList<Obstacle> obstacles;
	protected ArrayList<Tache> taches;
	protected ArrayList<Tache> cleanedDirt;
	protected ArrayList<Obstacle> metObstacle;

	// METHODES

	public Arene getArene() {
		return arene;
	}

	public ArrayList<Tache> getCleanedDirt() {
		return cleanedDirt;
	}

	public ArrayList<Obstacle> getMetObstacle() {
		return metObstacle;
	}

	public void setArene(Arene arene) {
		this.arene = arene;
	}

	public ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}

	public ArrayList<Tache> getTaches() {
		return taches;
	}

	public void enleverObstacle(Obstacle obstacle) {
		obstacles.remove(obstacle);
	}

	// Constructeurs
	public Environnement(Arene arene) {
		this.arene = arene;
		obstacles = new ArrayList<Obstacle>();
		taches = new ArrayList<Tache>();
		cleanedDirt = new ArrayList<Tache>();
		metObstacle = new ArrayList<Obstacle>();
	}

	/**
	 * add an obstacle to the ArrayList obstacles
	 * @param obs
	 */

	public void ajouterObstacle(Obstacle obs) {
		obstacles.add(obs);
	}

	/**
	 * add a dirt to the ArrayList taches
	 * @param dirt
	 */
	public void ajouterTache(Tache dirt) {
		taches.add(dirt);
	}

	/**
	 * Remove from the ArrayList of dirt all the dirts that do not exist anymore
	 */
	public void nettoyerTache() {
		ArrayList<Tache> del = new ArrayList<Tache>();
		for (Tache x : taches) {
			if (x.getForme() instanceof Carre) {
				if (((Carre) x.getForme()).getCote() <= 0)
					del.add(x);
			} else if (x.getForme() instanceof Rectangle) {
				if (((Rectangle) x.getForme()).getLargeur() <= 0
						|| ((Rectangle) x.getForme()).getHauteur() <= 0)
					del.add(x);
			} else if (x.getForme() instanceof Cercle) {
				if (((Cercle) x.getForme()).getDiametre() <= 0)
					del.add(x);
			}
		}
		cleanedDirt = del;
		taches.removeAll((Collection<Tache>) del);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object clone() throws CloneNotSupportedException {
		Environnement o = (Environnement) super.clone();
		o.obstacles = (ArrayList<Obstacle>) obstacles.clone();
		o.taches = (ArrayList<Tache>) taches.clone();
		o.arene = (Arene) arene.clone();
		return o;
	}

}
