package com.testroomba;

import static org.junit.Assert.*;
import com.roomba.environnement.*;
import com.roomba.robot.*;
import com.roomba.shape.*;
import org.junit.Test;

/**
 * @author Lucas
 *
 */
public class CapteurDistanceTest {

	/**
	 * Test method for {@link com.roomba.robot.CapteurDistance#miseAjour(com.roomba.environnement.Environnement)}.
	 */
	@Test
	public void testMiseAjour() {
		Cercle c = new Cercle(0,0,0,0.5);
		CapteurDistance capt = new CapteurDistance(c,0);
		assertEquals(capt.lecture(),10,0);
		Environnement environ = new Environnement(new Arene(new Carre(0,0,0,5)));
		environ.ajouterObstacle(new Obstacle(new Cercle(3,0,1,1)));
		capt.miseAjour(environ);
		assertEquals(capt.lecture(),2.5,0);

	}

	/**
	 * Test method for {@link com.roomba.robot.CapteurDistance#lecture()}.
	 */
	@Test
	public void testLecture() {
		Cercle c = new Cercle(0,1,0,0.4);
		CapteurDistance capt = new CapteurDistance(c,0);
		assertEquals(capt.lecture(),10,0);
	}

	/**
	 * Test method for {@link com.roomba.robot.CapteurDistance#CapteurDistance(com.roomba.shape.Forme, double)}.
	 */
	@Test
	public void testCapteurDistance() {
		Cercle c = new Cercle(0,1,0,0.4);
		CapteurDistance capt = new CapteurDistance(c,0);
		assertEquals(capt.getForme(),c);
		assertEquals(capt.getOrientation(),0,0);
	}

}
