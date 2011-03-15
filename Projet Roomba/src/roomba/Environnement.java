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
	public Environnement()
	{
		
		arene = new AreneCarree();
		obstacles = new ArrayList<Obstacle>();
		taches = new ArrayList<Tache>();
		
		obstacles.add(new ObstacleCercle(0,0,10));
		obstacles.add(new ObstacleCercle(200,280,30));
		
		obstacles.add(new ObstacleCarre(50,400,0,20));
		
		taches.add(new Tache(300,300,15));
		
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
