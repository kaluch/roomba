/**
 * 
 */
package com.testroomba;

import static org.junit.Assert.*;
import com.roomba.shape.*;
import com.roomba.roombautil.*;

import org.junit.Test;

/**
 * @author Lucas
 *
 */
public class CercleTest {

	/**
	 * Test method for {@link roomba.Cercle#Cercle(double, double, double, double)}.
	 */
	@Test
	public void testCercleDoubleDoubleDoubleDouble() {
		Cercle circle = new Cercle(0,0,0,5);
		assertEquals(circle.getDiametre(),5,0);
		assertEquals(circle.getPosture().getX(),0,0);
		assertEquals(circle.getPosture().getY(),0,0);
		assertEquals(circle.getPosture().getTheta(),0,0);
	}

	/**
	 * Test method for {@link roomba.Cercle#Cercle(roomba.Posture, double)}.
	 */
	@Test
	public void testCerclePostureDouble() {
		Posture post = new Posture(1,2,3);
		Cercle circle = new Cercle(post,3);
		assertEquals(circle.getDiametre(),3,0);
		assertEquals(circle.getPosture().getX(),1,0);
		assertEquals(circle.getPosture().getY(),2,0);
		assertEquals(circle.getPosture().getTheta(),3,0);
	}

	/**
	 * Test method for {@link roomba.Cercle#collisionInterne(roomba.Carre)}.
	 */
	@Test
	public void testCollisionInterneCarre() {
		Cercle circle = new Cercle(0,0,0,4);
		Carre c1 = new Carre(0,0,0,1), c2 = new Carre(0,0,0,4), c3 = new Carre(2,0,0,4), c4 = new Carre(6,6,0,1);
		assertEquals(circle.collisionInterne(c1),false);//TODO foire
		assertEquals(circle.collisionInterne(c2),true);
		assertEquals(circle.collisionInterne(c3),true);
		assertEquals(circle.collisionInterne(c4),true);//TODO foire
	}

	/**
	 * Test method for {@link roomba.Cercle#collisionExterne(roomba.Carre)}.
	 */
	@Test
	public void testCollisionExterneCarre() {
		Cercle circle = new Cercle(0,0,0,4);
		Carre c1 = new Carre(0,0,0,2), c2 = new Carre(0,0,0,4), c3 = new Carre(2,0,0,4), c4 = new Carre(6,6,0,1);
		assertEquals(circle.collisionExterne(c1),true);
		assertEquals(circle.collisionExterne(c2),true);
		assertEquals(circle.collisionExterne(c3),true);
		assertEquals(circle.collisionExterne(c4),false);
	}

	/**
	 * Test method for {@link roomba.Cercle#collisionInterne(roomba.Cercle)}.
	 */
	@Test
	public void testCollisionInterneCercle() {
		Cercle circle = new Cercle(0,0,0,4);
		Cercle c1 = new Cercle(0,0,0,2), c2 = new Cercle(0,0,0,4), c3 = new Cercle(2,0,0,3), c4 = new Cercle(6,6,0,1);
		assertEquals(circle.collisionInterne(c1),false);
		assertEquals(circle.collisionInterne(c2),true);
		assertEquals(circle.collisionInterne(c3),true);
		assertEquals(circle.collisionInterne(c4),true);
	}

	/**
	 * Test method for {@link roomba.Cercle#collisionExterne(roomba.Cercle)}.
	 */
	@Test
	public void testCollisionExterneCercle() {
		Cercle circle = new Cercle(0,0,0,4);
		Cercle c1 = new Cercle(0,0,0,2), c2 = new Cercle(0,0,0,4), c3 = new Cercle(2,0,0,3), c4 = new Cercle(6,6,0,1);
		assertEquals(circle.collisionExterne(c1),true);
		assertEquals(circle.collisionExterne(c2),true);
		assertEquals(circle.collisionExterne(c3),true);
		assertEquals(circle.collisionExterne(c4),false);
	}

	/**
	 * Test method for {@link roomba.Cercle#collisionInterne(roomba.Rectangle)}.
	 */
	@Test
	public void testCollisionInterneRectangle() {
		Cercle circle = new Cercle(0,0,0,4);
		Rectangle r1 = new Rectangle(0,0,0,1,1), r2 = new Rectangle(0,0,0,4,4), r3 = new Rectangle(3,0,0,5,3), r4 = new Rectangle (20,21,0,4,5);
		assertEquals(circle.collisionInterne(r1),false);//TODO foire
		assertEquals(circle.collisionInterne(r2),true);
		assertEquals(circle.collisionInterne(r3),true);
		assertEquals(circle.collisionInterne(r4),true);//TODO Foire
	}

	/**
	 * Test method for {@link roomba.Cercle#collisionExterne(roomba.Rectangle)}.
	 */
	@Test
	public void testCollisionExterneRectangle() {
		Cercle circle = new Cercle(0,0,0,4);
		Rectangle r1 = new Rectangle(0,0,0,2,1), r2 = new Rectangle(0,0,0,4,4), r3 = new Rectangle(3,0,0,5,3), r4 = new Rectangle (20,21,0,4,5);
		assertEquals(circle.collisionExterne(r1),true);
		assertEquals(circle.collisionExterne(r2),true);
		assertEquals(circle.collisionExterne(r3),true);
		assertEquals(circle.collisionExterne(r4),false);
	}

}
