package roomba;

import java.util.ArrayList;

public class Environnement {

	//ATTRIBUTS
	protected Arene arene;
	protected ArrayList<Obstacle> obstacles;
	protected ArrayList<Tache> taches;
	
	//METHODES
	
	//Constructeurs
	Environnement()
	{
		AreneCarree arena = new AreneCarree();
		
	}
	//
	
	public void ajouterObstacle(Obstacle obs)
	{
		obstacles.add(obs);
	}
	
	public void ajouterTache(Tache dirt)
	{
		taches.add(dirt);
	}
	
	public void nettoyerTache(Tache dirt)
	{
		taches.remove(dirt);
	}
}
