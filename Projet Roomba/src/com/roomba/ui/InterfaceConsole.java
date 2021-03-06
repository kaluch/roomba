package com.roomba.ui;

import java.util.Scanner;
import com.roomba.environnement.*;
import com.roomba.shape.*;
import com.roomba.robot.*;

public class InterfaceConsole extends Interface {

	Environnement environ;
	protected Roomba roomba;
	boolean animated;

	public InterfaceConsole(Roomba roomba) {
		environ = new Environnement(new Arene(new Carre(0, 0, 0, 4)));
		this.roomba = roomba;
	}

	public void startSimulation() {
		System.out
				.println("Bienvenue dans le simulateur de Roomba Zamuner/Souchet");
		int choix = 1;
		while (choix != 0) {
			choix = menuAccueil();
			switch (choix) {
			case 0: // QUITTER
				break;
			case 1: // ENV
				gestionEnv();
				break;
			case 2: // SIMU
				animated = true;
				choix = 0;
				break;
			default:
				System.out.println("Choix non valide");
				break;
			}
		}
	}

	private int menuAccueil() {
		int choix = -1;
		System.out.println("Veuillez faire votre choix :");
		System.out.println("1. Configurer l'environnement");
		System.out.println("2. Lancer la simulation");
		System.out.println("0. Quitter");
		Scanner scan = new Scanner(System.in);
		while (choix < 0)
			choix = scan.nextInt();
		return choix;
	}

	private void gestionEnv() {
		int choix = menuEnv();
		switch (choix) {
		case 1: // Ajouter obstacle
			ajouterObstacle();
			break;
		case 2: // Ajouter tache
			ajouterTache();
			break;
		case 3: // Reset
			resetEnv();
			break;
		case 0: // Retour
			break;
		default:
			System.out.println("Choix non valide");
			gestionEnv();
			break;
		}
	}

	private int menuEnv() {
		int choix = -1;
		System.out
				.println("================Configuration de l'environnement===========");
		afficherEnv();
		System.out.println("1. Ajouter des obstacles");
		System.out.println("2. Ajouter des taches");
		System.out.println("3. Reinitialiser l'environnement");
		System.out.println("0. Retour");
		Scanner scan = new Scanner(System.in);
		while (choix < 0)
			choix = scan.nextInt();
		return choix;
	}

	private void afficherEnv() {
		int nbT = environ.getTaches().size(), nbO = environ.getObstacles()
				.size();
		System.out.println("L'environnement mesure 4mx4m et compte " + nbO
				+ " obstacles et " + nbT + " taches");
	}

	private void ajouterObstacle() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Quelle forme?");
		System.out.println("1. Carre");
		System.out.println("2. Cercle");
		System.out.println("3. Rectangle");
		int choix = -1;
		double x = -3, y = -3;
		while (choix != 1 && choix != 2 && choix != 3) {
			choix = sc.nextInt();
		}
		System.out.println("Abscisse[-2:2](m) :");
		while (x < -2 || x > 2)
			x = sc.nextDouble();
		System.out.println("Ordonnee[-2:2](m) :");
		while (y < -2 || y > 2)
			y = sc.nextDouble();
		switch (choix) {
		case 1:
			double cote;
			System.out.println("Cote(m) :");
			cote = sc.nextDouble();
			this.environ
					.ajouterObstacle(new Obstacle(new Carre(x, y, 0, cote)));
			System.out.println("Obstacle carre de cote " + cote
					+ "m ajoute en (" + x + "," + y + ")");
			break;
		case 2:
			double diametre;
			System.out.println("Diametre :");
			diametre = sc.nextDouble();
			this.environ.ajouterObstacle(new Obstacle(new Cercle(x, y, 0,
					diametre)));
			System.out.println("Obstacle circulaire de diametre " + diametre
					+ "m ajoute en (" + x + "," + y + ")");
			break;
		case 3:
			double largeur,
			hauteur;
			System.out.println("Largeur :");
			largeur = sc.nextDouble();
			System.out.println("Hauteur :");
			hauteur = sc.nextDouble();
			this.environ.ajouterObstacle(new Obstacle(new Rectangle(x, y, 0,
					largeur, hauteur)));
			System.out.println("Obstacle rectangulaire  " + largeur + "m x "
					+ hauteur + "m ajoute en (" + x + "," + y + ")");
			break;
		default:
			System.out.println("Choix non valide");
			ajouterObstacle();
			break;
		}
	}

	private void ajouterTache() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Quelle forme?");
		System.out.println("1. Carre");
		System.out.println("2. Cercle");
		System.out.println("3. Rectangle");
		int choix = -1;
		double x, y;
		while (choix != 1 && choix != 2 && choix != 3) {
			choix = sc.nextInt();
		}
		System.out.println("Abscisse :");
		x = sc.nextDouble();
		System.out.println("Ordonnee :");
		y = sc.nextDouble();
		switch (choix) {
		case 1:
			double cote;
			System.out.println("Cote :");
			cote = sc.nextDouble();
			this.environ.ajouterTache(new Tache(new Carre(x, y, 0, cote)));
			System.out.println("Tache carree de cote " + cote + " ajoutee en ("
					+ x + "," + y + ")");
			break;
		case 2:
			double diametre;
			System.out.println("Diametre :");
			diametre = sc.nextDouble();
			this.environ.ajouterTache(new Tache(new Cercle(x, y, 0, diametre)));
			System.out.println("Tache circulaire de diametre " + diametre
					+ " ajoutee en (" + x + "," + y + ")");
			break;
		case 3:
			double largeur,
			hauteur;
			System.out.println("Largeur :");
			largeur = sc.nextDouble();
			System.out.println("Hauteur :");
			hauteur = sc.nextDouble();
			this.environ.ajouterTache(new Tache(new Rectangle(x, y, 0, largeur,
					hauteur)));
			System.out.println("Tache rectangulaire  " + largeur + "x"
					+ hauteur + " ajoutee en (" + x + "," + y + ")");
			break;
		default:
			System.out.println("Choix non valide");
			ajouterTache();
			break;
		}
	}

	private void resetEnv() {
		environ.getObstacles().clear();
		environ.getTaches().clear();
		System.out.println("Environnement reinitialise");
	}

	@Override
	public boolean getAnimated() {
		return animated;
	}

	@Override
	public void mAJ() {
		System.out.println(roomba.toString());
		if (environ.getCleanedDirt().size() != 0) {
			for (int i = 1; i <= environ.getCleanedDirt().size(); i++) {
				double x = environ.getCleanedDirt().get(i).getForme()
						.getPosture().getX();
				double y = environ.getCleanedDirt().get(i).getForme()
						.getPosture().getY();
				System.out.println("Le roomba a nettoy� la tache situ�e en ("
						+ x + "," + y + ")");

			}
		}
	}

	@Override
	public boolean getClosed() {
		return false;
	}

	public Environnement getEnviron() {
		return environ;
	}

	@Override
	public void debut() {
		startSimulation();
	}

}
