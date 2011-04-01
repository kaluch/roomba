package roomba;

import java.util.Scanner;
import java.util.ArrayList;

public class InterfaceConsole extends Interface {

	Environnement environ;
	Robot robot;
	ArrayList<Obstacle> obstacles;
	ArrayList<Tache> taches;
	
	public InterfaceConsole()
	{
		
	}
	
	public static void main(String[] args){
		int choix = new menuAccueil();
		switch(choix)
		{
		case 0: //QUITTER
			
			break;
		case 1: //ENV
			gestionEnv();
			break;
		case 2: //ROBOT
			break;
		case 3: //SIMU
			break;
		default:
			break;
		}
	}
	
	private static int menuAccueil(){
		int choix = -1;
		System.out.println("Bienvenue dans le simulateur de Roomba Zamuner/Souchet");
		System.out.println("Veuillez faire votre choix :");
		System.out.println("1. Configurer l'environnement");
		System.out.println("2. Configurer le robot");
		System.out.println("3. Lancer la simulation");
		System.out.println("0. Quitter");
		Scanner scan = new Scanner(System.in);
		while(choix < 0)
			choix = scan.nextInt();
		return choix;
	}
	
	private static void gestionEnv(){
		int choix = menuEnv();
		switch (choix){
		case 1: //Ajouter obstacle
			ajouterObstacle();
			break;
		case 2: //Ajouter tache
			break;
		case 0: //Retour
			break;
		default:
			break;
		}
	}
	
	private static void ajouterObstacle(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Quelle forme?");
		System.out.println("1. Carré");
		System.out.println("2. Cercle");
		System.out.println("3. Rectangle");
		int choix = -1;
		double x,y;
		while(choix != 1 && choix != 2 && choix != 3){
			choix = sc.nextInt();
		}
		System.out.println("Abscisse :");
		x=sc.nextDouble();
		System.out.println("Ordonnée :");
		y = sc.nextDouble();
		switch(choix){
		case 1:
			double cote;
			System.out.println("Coté :");
			cote = sc.nextDouble();
			this.environ.ajouterObstacle(new Obstacle(new Carre(x,y,0,cote)));
			break;
		case 2:
			double diametre;
			System.out.println("Diametre :");
			diametre = sc.nextDouble();
			this.environ.ajouterObstacle(new Obstacle(new Cercle(x,y,0,diametre)));
			break;
		case 3:
			double largeur, hauteur;
			System.out.println("Largeur :");
			largeur = sc.nextDouble();
			System.out.println("Hauteur :");
			hauteur = sc.nextDouble();
			this.environ.ajouterObstacle(new Obstacle(new Rectangle(x,y,0,largeur, hauteur)));
			break;
		default:
			System.out.println("Choix non valide");
			ajouterObstacle();
			break;
		}
	}
	private static int menuEnv(){
		int choix = -1;
		System.out.println("================Configuration de l'environnement===========");
		System.out.println("1. Ajouter des obstacles");
		System.out.println("2. Ajouter des taches");
		System.out.println("3. Reinitialiser l'environnement");
		System.out.println("0. Retour");
		Scanner scan = new Scanner(System.in);
		while(choix < 0)
			choix = scan.nextInt();
		return choix;
	}
	
	private static int menuRobot(){
		int choix = -1;
		System.out.println("================Configuration du robot===========");
		System.out.println("1. Ajouter un roomba");
		System.out.println("0. Retour");
		Scanner scan = new Scanner(System.in);
		while(choix < 0)
			choix = scan.nextInt();
		return choix;
	}
	
	
}
