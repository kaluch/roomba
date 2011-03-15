package roomba;


import java.util.ArrayList;

public class Environnement {

	//ATTRIBUTS
	protected Arene arene;
	protected ArrayList<Obstacle> obstacles;
	protected ArrayList<Tache> taches;
	
	//METHODES
	
	public Arene getArene() {		return arene;	}
	public void setArene(Arene arene) {		this.arene = arene;	}
	public ArrayList<Obstacle> getObstacles() {		return obstacles;	}
	public ArrayList<Tache> getTaches() {		return taches;	}

	//Constructeurs
	public Environnement(Arene arene)
	{
		this.arene = arene;
		obstacles = new ArrayList<Obstacle>();
		taches = new ArrayList<Tache>();		
	}
	//
	
	public void ajouterObstacle(Obstacle obs)	{		obstacles.add(obs);	}
		public void ajouterTache(Tache dirt)	{		taches.add(dirt);	}
		public void nettoyerTache(Tache dirt)	{		taches.remove(dirt);	}
}
