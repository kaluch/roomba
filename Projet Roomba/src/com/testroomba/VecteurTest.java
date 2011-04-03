/**
 * 
 */
package com.testroomba;

import static org.junit.Assert.*;
import com.roomba.roombautil.*;

import org.junit.Test;

/**
 * @author Lucas
 *
 */
public class VecteurTest {

	/**
	 * Test method for {@link com.roomba.roombautil.Vecteur#norme()}.
	 */
	@Test
	public void testNorme() {
		Vecteur vect = new Vecteur(4,3);
		assertEquals(vect.norme(),5,0);
	}

	/**
	 * Test method for {@link com.roomba.roombautil.Vecteur#angle()}.
	 */
	@Test
	public void testAngle() {
		Vecteur vect = new Vecteur(0,3),vect2 = new Vecteur(3,0), vect3 = new Vecteur(2,2), vect4 = new Vecteur(-2,2);
		assertEquals(vect.angle(),90*Math.PI/180,0);
		assertEquals(vect2.angle(),0,0);
		assertEquals(vect3.angle(),45*Math.PI/180,0);
		assertEquals(vect4.angle(),135*Math.PI/180,0);
	}

	/**
	 * Test method for {@link com.roomba.roombautil.Vecteur#Vecteur()}.
	 */
	@Test
	public void testVecteur() {
		Vecteur vect = new Vecteur();
		assertEquals(vect.getX(),0,0);
		assertEquals(vect.getY(),0,0);
	}

	/**
	 * Test method for {@link com.roomba.roombautil.Vecteur#Vecteur(double, double)}.
	 */
	@Test
	public void testVecteurDoubleDouble() {
		Vecteur vect = new Vecteur(4,-8);
		assertEquals(vect.getX(),4,0);
		assertEquals(vect.getY(),-8,0);
	}

	/**
	 * Test method for {@link com.roomba.roombautil.Vecteur#Vecteur(com.roomba.roombautil.Vecteur)}.
	 */
	@Test
	public void testVecteurVecteur() {
		Vecteur vect1 = new Vecteur(4,-8);
		Vecteur vect = new Vecteur(vect1);
		assertEquals(vect.getX(),4,0);
		assertEquals(vect.getY(),-8,0);
	}

	/**
	 * Test method for {@link com.roomba.roombautil.Vecteur#toString()}.
	 */
	@Test
	public void testToString() {
		Vecteur vect = new Vecteur(42,1);
		assertEquals(vect.toString(),"42.0 1.0");
	}

	/**
	 * Test method for {@link com.roomba.roombautil.Vecteur#plus(com.roomba.roombautil.Vecteur)}.
	 */
	@Test
	public void testPlus() {
		Vecteur vect = new Vecteur(42,1);
		Vecteur vect2 = new Vecteur(2,-4);
		Vecteur vect3 = vect.plus(vect2);
		assertEquals(vect3.getX(),44,0);
		assertEquals(vect3.getY(),-3,0);
	}
	
	/**
	 * Test method for {@link com.roomba.roombautil.Vecteur#moins(com.roomba.roombautil.Vecteur)}.
	 */
	@Test
	public void testMoins() {
		Vecteur vect = new Vecteur(42,1);
		Vecteur vect2 = new Vecteur(2,-4);
		Vecteur vect3 = vect.moins(vect2);
		assertEquals(vect3.getX(),40,0);
		assertEquals(vect3.getY(),5,0);
	}
	
	/**
	 * Test method for {@link com.roomba.roombautil.Vecteur#pScal(com.roomba.roombautil.Vecteur)}.
	 */
	@Test
	public void testPScal() {
		Vecteur vect = new Vecteur(4,1);
		Vecteur vect2 = new Vecteur(-3,2);
		assertEquals(vect.pScal(vect2),-10,0);
	}
	
	/**
	 * Test method for {@link com.roomba.roombautil.Vecteur#det(com.roomba.roombautil.Vecteur)}.
	 */
	@Test
	public void testDet() {
		Vecteur vect = new Vecteur(3,-1);
		Vecteur vect2 = new Vecteur(4,-2);
		assertEquals(vect.det(vect2),-2,0);
	}

}
