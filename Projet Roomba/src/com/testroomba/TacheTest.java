/**
 * 
 */
package com.testroomba;

import static org.junit.Assert.*;
import com.roomba.environnement.*;
import com.roomba.shape.*;
import org.junit.Test;

/**
 * @author Lucas
 *
 */
public class TacheTest {

	/**
	 * Test method for {@link com.roomba.environnement.Tache#Tache(com.roomba.shape.Forme)}.
	 */
	@Test
	public void testTache() {
		Forme forme1 = new Carre(0,0,0,2), forme2 = new Cercle(0,2,0,1.5), forme3 = new Rectangle(10,2,0,2,3);
		Tache t1 = new Tache(forme1), t2 = new Tache(forme2), t3 = new Tache(forme3);
		assertEquals(t1.getForme(),forme1);
		assertEquals(t2.getForme(),forme2);
		assertEquals(t3.getForme(),forme3);
	}

	
	/**
	 * Test method for {@link com.roomba.environnement.Tache#nettoyer()}.
	 */
	@Test
	public void testNettoyer() {
		Forme forme1 = new Carre(0,0,0,2), forme2 = new Cercle(0,2,0,1.5), forme3 = new Rectangle(10,2,0,2,3);
		Tache t1 = new Tache(forme1), t2 = new Tache(forme2), t3 = new Tache(forme3);
		t1.nettoyer();
		assertEquals(((Carre)t1.getForme()).getCote(),1.999,0);
		t2.nettoyer();
		assertEquals(((Cercle)t2.getForme()).getDiametre(),1.499,0);
		t3.nettoyer();
		assertEquals(((Rectangle)t3.getForme()).getHauteur(),2.999,0);
		assertEquals(((Rectangle)t3.getForme()).getLargeur(),1.999,0);
	}

}
