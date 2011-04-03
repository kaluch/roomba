/**
 * 
 */
package com.testroomba;

import static org.junit.Assert.*;

import org.junit.Test;

import com.roomba.shape.*;
import com.roomba.robot.*;
import com.roomba.environnement.*;

/**
 * @author Lucas
 *
 */
public class CapteurContactObstacleTest {

	/**
	 * Test method for {@link com.roomba.robot.CapteurContactObstacle#miseAjour(com.roomba.environnement.Environnement)}.
	 */
	@Test
	public void testMiseAjour() {
		Environnement environ = new Environnement(new Arene(new Carre(0,0,0,4)));
		Cercle c1 = new Cercle(0,0,0,1);
		CapteurContactObstacle capt = new CapteurContactObstacle(c1);
		environ.ajouterObstacle(new Obstacle(new Carre(1,0,0,1)));
		environ.ajouterObstacle(new Obstacle(new Carre(1.3,0,0,0.3)));
		capt.miseAjour(environ);
		assertEquals(capt.lecture(),1,0);
		c1 = new Cercle(-1,-1,0,0.3);
		capt = new CapteurContactObstacle(c1);
		capt.miseAjour(environ);
		assertEquals(capt.lecture(),0,0);
	}

	/**
	 * Test method for {@link com.roomba.robot.CapteurContactObstacle#CapteurContactObstacle(com.roomba.shape.Forme, double, double)}.
	 */
	@Test
	public void testCapteurContactObstacleFormeDoubleDouble() {
		Cercle c1 = new Cercle(0,0,0,2);
		CapteurContactObstacle capt = new CapteurContactObstacle(c1,10,5);
		assertEquals(capt.getPerimetre(),10,0);
		assertEquals(capt.getDiametre(),5,0);
	}

	/**
	 * Test method for {@link com.roomba.robot.CapteurContactObstacle#CapteurContactObstacle(com.roomba.shape.Forme)}.
	 */
	@Test
	public void testCapteurContactObstacleForme() {
		Cercle c1 = new Cercle(0,1,0,3);
		CapteurContactObstacle capt = new CapteurContactObstacle(c1);
		assertEquals(capt.getPerimetre(),0,0);
		assertEquals(capt.getDiametre(),0,0);
	}


	/**
	 * Test method for {@link com.roomba.robot.CapteurContact#toString()}.
	 */
	@Test
	public void testToString() {
		Environnement environ = new Environnement(new Arene(new Carre(0,0,0,4)));
		Cercle c1 = new Cercle(0,0,0,1);
		CapteurContactObstacle capt = new CapteurContactObstacle(c1);
		environ.ajouterObstacle(new Obstacle(new Carre(1,0,0,1)));
		environ.ajouterObstacle(new Obstacle(new Carre(1.3,0,0,0.3)));
		capt.miseAjour(environ);
		assertEquals(capt.lecture(),1,0);
		assertEquals(capt.toString(),"contact");
		c1 = new Cercle(-1,-1,0,0.3);
		capt = new CapteurContactObstacle(c1);
		capt.miseAjour(environ);
		assertEquals(capt.lecture(),0,0);
		assertEquals(capt.toString(),"non-contact");
	}

}
