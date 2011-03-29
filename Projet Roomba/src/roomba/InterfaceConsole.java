package roomba;

import java.util.Scanner;


public class InterfaceConsole extends Interface {

	public InterfaceConsole()
	{
		
	}
	
	public static void main(String[] args){
		int choix = menuAccueil();
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
	
	private int menuEnv(){
		int choix = -1;
		System.out.println("================Configuration de l'environnement===========");
		System.out.println("1. Ajouter des obstacles");
		System.out.println("2. Ajouter des taches");
		System.out.println("0. Retour");
		Scanner scan = new Scanner(System.in);
		while(choix < 0)
			choix = scan.nextInt();
		return choix;
	}
	
	private int menuRobot(){
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
