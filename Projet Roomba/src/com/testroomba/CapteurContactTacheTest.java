/**
 * 
 */
package com.testroomba;

import static org.junit.Assert.*;

import com.roomba.shape.*;
import com.roomba.environnement.*;
import com.roomba.robot.*;

import org.junit.Test;

/**
 * @author Lucas
 *
 */
public class CapteurContactTacheTest {

	/**
	 * Test method for {@link com.roomba.robot.CapteurContactTache#miseAjour(com.roomba.environnement.Environnement)}.
	 */
	@Test
	public void testMiseAjour() {
		Environnement environ = new Environnement(new Arene(new Carre(0,0,0,4)));
		Cercle c1 = new Cercle(0,0,0,1);
		CapteurContactTache capt = new CapteurContactTache(c1,0);
		environ.ajouterTache(new Tache(new Carre(1,0,0,2)));
		environ.ajouterTache(new Tache(new Carre(1.3,0,0,0.3)));
		capt.miseAjour(environ);
		assertEquals(capt.lecture(),1,0);
		c1 = new Cercle(-1,-1,0,0.3);
		capt = new CapteurContactTache(c1,0);
		capt.miseAjour(environ);
		assertEquals(capt.lecture(),0,0);
	}

	/**
	 * Test method for {@link com.roomba.robot.CapteurContactTache#toString()}.
	 */
	@Test
	public void testToString() {
		Environnement environ = new Environnement(new Arene(new Carre(0,0,0,4)));
		Cercle c1 = new Cercle(0,0,0,1);
		CapteurContactTache capt = new CapteurContactTache(c1,0);
		environ.ajouterTache(new Tache(new Carre(1,0,0,2)));
		environ.ajouterTache(new Tache(new Carre(1.3,0,0,0.3)));
		capt.miseAjour(environ);
		assertEquals(capt.lecture(),1,0);
		assertEquals(capt.toString(),"Tache : contact");
		c1 = new Cercle(-1,-1,0,0.3);
		capt = new CapteurContactTache(c1,0);
		capt.miseAjour(environ);
		assertEquals(capt.lecture(),0,0);
		assertEquals(capt.toString(),"Tache : non-contact");
	}

	/**
	 * Test method for {@link com.roomba.robot.CapteurContactTache#CapteurContactTache(com.roomba.shape.Forme, double)}.
	 */
	@Test
	public void testCapteurContactTache() {
		Cercle c1 = new Cercle(0,0,0,2);
		CapteurContactTache capt = new CapteurContactTache(c1,5);
		assertEquals(capt.getForme(),c1);
	}


}
