package com.testroomba;

import static org.junit.Assert.*;
import com.roomba.shape.*;
import com.roomba.roombautil.*;
import org.junit.Test;

public class RectangleTest {

	@Test
	public void testRectangleDoubleDoubleDoubleDoubleDouble() {
		Rectangle rect = new Rectangle(0,0,0,5,2);
		assertEquals(rect.getHauteur(),2,0);
		assertEquals(rect.getLargeur(),5,0);
	}

	@Test
	public void testRectanglePostureDoubleDouble() {
		Posture post = new Posture(1,2,3);
		Rectangle rect = new Rectangle(post,4,2);
		assertEquals(rect.getHauteur(),2,0);
		assertEquals(rect.getLargeur(),4,0);
	}

	@Test
	public void testSetLargeur() {
		Rectangle rect = new Rectangle(0,0,0,5,2);
		assertEquals(rect.getLargeur(),5,0);
		rect.setLargeur(1);
		assertEquals(rect.getLargeur(),1,0);
	}

	@Test
	public void testSetHauteur() {
		Rectangle rect = new Rectangle(0,0,0,5,2);
		assertEquals(rect.getHauteur(),2,0);
		rect.setHauteur(3);
		assertEquals(rect.getHauteur(),3,0);
	}

	@Test
	public void testCollisionInterneCarre() {
		Rectangle rect = new Rectangle(0,0,0,4,2);
		Carre carre1 = new Carre(0,0,0,1), carre2 = new Carre(0,0,0,2), carre3 = new Carre(1,0,0,3), carre4 = new Carre(8,0,0,1);
		assertEquals(rect.collisionInterne(carre1),false);
		assertEquals(rect.collisionInterne(carre2),true);
		assertEquals(rect.collisionInterne(carre3),true);
		assertEquals(rect.collisionInterne(carre4),true);
	}

	@Test
	public void testCollisionExterneCarre() {
		Rectangle rect = new Rectangle(0,0,0,4,2);
		Carre carre1 = new Carre(0,0,0,1), carre2 = new Carre(0,0,0,2), carre3 = new Carre(1,0,0,3), carre4 = new Carre(8,0,0,1);
		assertEquals(rect.collisionExterne(carre1),true);
		assertEquals(rect.collisionExterne(carre2),true);
		assertEquals(rect.collisionExterne(carre3),true);
		assertEquals(rect.collisionExterne(carre4),false);
	}

	@Test
	public void testCollisionInterneCercle() {
		Rectangle rect = new Rectangle(0,0,0,4,2);
		Cercle cercle1 = new Cercle(0,0,0,1), cercle2 = new Cercle(0,0,0,2), cercle3 = new Cercle(3,0,0,3), cercle4 = new Cercle(8,0,0,2);
		assertEquals(rect.collisionInterne(cercle1),false);
		assertEquals(rect.collisionInterne(cercle2),true);
		assertEquals(rect.collisionInterne(cercle3),true);
		assertEquals(rect.collisionInterne(cercle4),true);
	}

	@Test
	public void testCollisionExterneCercle() {
		Rectangle rect = new Rectangle(0,0,0,4,2);
		Cercle cercle1 = new Cercle(0,0,0,1), cercle2 = new Cercle(0,0,0,2), cercle3 = new Cercle(3,0,0,3), cercle4 = new Cercle(8,0,0,2);
		assertEquals(rect.collisionExterne(cercle1),true);
		assertEquals(rect.collisionExterne(cercle2),true);
		assertEquals(rect.collisionExterne(cercle3),true);
		assertEquals(rect.collisionExterne(cercle4),false);
	}

	@Test
	public void testCollisionInterneRectangle() {
		Rectangle rect = new Rectangle(0,0,0,4,2);
		Rectangle rect1 = new Rectangle(0,0,0,2,1), rect2 = new Rectangle(0,0,0,3,2), rect3 = new Rectangle(-2,0,0,3,4), rect4 = new Rectangle(0,5,0,2,3);
		assertEquals(rect.collisionInterne(rect1),false);//TODO plante
		assertEquals(rect.collisionInterne(rect2),true);
		assertEquals(rect.collisionInterne(rect3),true);
		assertEquals(rect.collisionInterne(rect4),true);
	}

	@Test
	public void testCollisionExterneRectangle() {
		Rectangle rect = new Rectangle(0,0,0,4,2);
		Rectangle rect1 = new Rectangle(0,0,0,2,1), rect2 = new Rectangle(0,0,0,3,2), rect3 = new Rectangle(-2,0,0,3,4), rect4 = new Rectangle(0,5,0,2,3);
		assertEquals(rect.collisionExterne(rect1),true);
		assertEquals(rect.collisionExterne(rect2),true);
		assertEquals(rect.collisionExterne(rect3),true);
		assertEquals(rect.collisionExterne(rect4),false);
	}

}
