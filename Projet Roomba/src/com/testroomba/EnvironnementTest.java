package com.testroomba;

import static org.junit.Assert.*;

import org.junit.Test;
import com.roomba.shape.*;
import com.roomba.environnement.*;

public class EnvironnementTest {

	@Test
	public void testEnvironnement() {
		Environnement environ=new Environnement(new Arene(new Carre(0,0,0,4)));
		assertEquals(environ.getObstacles().size(),0);
		environ.ajouterObstacle(new Obstacle(new Carre(0.2,3.6,0,0.2)));
		environ.ajouterObstacle(new Obstacle(new Cercle(1.2,2,0,0.1)));
		environ.ajouterObstacle(new Obstacle(new Rectangle(2.5,0.2,0,0.2,0.3)));
		assertEquals((int)environ.getObstacles().get(0).getForme().getPosture().getX(),0);
		assertEquals(environ.getObstacles().get(2).getForme().getPosture().getX(),2.5,0);
	
	}

	@Test
	public void testAjouterObstacle() {
		Environnement environ=new Environnement(new Arene(new Carre(0,0,0,4)));
		assertEquals(environ.getObstacles().size(),0);
		environ.ajouterObstacle(new Obstacle(new Carre(0.2,3.6,0,0.2)));
		assertEquals(environ.getObstacles().size(),1);
	}

	@Test
	public void testAjouterTache() {
		Environnement environ=new Environnement(new Arene(new Carre(0,0,0,4)));
		assertEquals(environ.getTaches().size(),0);
		environ.ajouterTache(new Tache(new Carre(0.2,3.6,0,0.2)));
		assertEquals(environ.getTaches().size(),1);
	}

	@Test
	public void testNettoyerTache() {
		Environnement environ=new Environnement(new Arene(new Carre(0,0,0,4)));
		assertEquals(environ.getTaches().size(),0);
		environ.ajouterTache(new Tache(new Carre(0.2,3.6,0,0.2)));
		assertEquals(environ.getTaches().size(),1);
		environ.nettoyerTache();
		assertEquals(environ.getTaches().size(),1);

	}

}
