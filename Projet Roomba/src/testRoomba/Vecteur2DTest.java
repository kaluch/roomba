/**
 * 
 */
package testroomba;

import static org.junit.Assert.*;
import roomba.*;

import org.junit.Test;

/**
 * @author Lucas
 *
 */
public class Vecteur2DTest {

	/**
	 * Test method for {@link roomba.Vecteur2D#norme()}.
	 */
	@Test
	public void testNorme() {
		Vecteur2D vect = new Vecteur2D(4,3);
		assertEquals(vect.norme(),5,0);
	}

	/**
	 * Test method for {@link roomba.Vecteur2D#angle()}.
	 */
	@Test
	public void testAngle() {
		Vecteur2D vect = new Vecteur2D(0,3),vect2 = new Vecteur2D(3,0), vect3 = new Vecteur2D(2,2), vect4 = new Vecteur2D(-2,2);
		assertEquals(vect.angle(),90*Math.PI/180,0);
		assertEquals(vect2.angle(),0,0);
		assertEquals(vect3.angle(),45*Math.PI/180,0);
		assertEquals(vect4.angle(),135*Math.PI/180,0);
	}

	/**
	 * Test method for {@link roomba.Vecteur2D#Vecteur2D()}.
	 */
	@Test
	public void testVecteur2D() {
		Vecteur2D vect = new Vecteur2D();
		assertEquals(vect.getX(),0,0);
		assertEquals(vect.getY(),0,0);
	}

	/**
	 * Test method for {@link roomba.Vecteur2D#Vecteur2D(double, double)}.
	 */
	@Test
	public void testVecteur2DDoubleDouble() {
		Vecteur2D vect = new Vecteur2D(4,-8);
		assertEquals(vect.getX(),4,0);
		assertEquals(vect.getY(),-8,0);
	}

	/**
	 * Test method for {@link roomba.Vecteur2D#Vecteur2D(roomba.Vecteur2D)}.
	 */
	@Test
	public void testVecteur2DVecteur2D() {
		Vecteur2D vect1 = new Vecteur2D(4,-8);
		Vecteur2D vect = new Vecteur2D(vect1);
		assertEquals(vect.getX(),4,0);
		assertEquals(vect.getY(),-8,0);
	}

	/**
	 * Test method for {@link roomba.Vecteur2D#toString()}.
	 */
	@Test
	public void testToString() {
		Vecteur2D vect = new Vecteur2D(42,1);
		assertEquals(vect.toString(),"42.0 1.0");
	}

	/**
	 * Test method for {@link roomba.Vecteur2D#plus(roomba.Vecteur2D)}.
	 */
	@Test
	public void testPlus() {
		Vecteur2D vect = new Vecteur2D(42,1);
		Vecteur2D vect2 = new Vecteur2D(2,-4);
		Vecteur2D vect3 = vect.plus(vect2);
		assertEquals(vect3.getX(),44,0);
		assertEquals(vect3.getY(),-3,0);
	}
	
	/**
	 * Test method for {@link roomba.Vecteur2D#moins(roomba.Vecteur2D)}.
	 */
	@Test
	public void testMoins() {
		Vecteur2D vect = new Vecteur2D(42,1);
		Vecteur2D vect2 = new Vecteur2D(2,-4);
		Vecteur2D vect3 = vect.moins(vect2);
		assertEquals(vect3.getX(),40,0);
		assertEquals(vect3.getY(),5,0);
	}
	
	/**
	 * Test method for {@link roomba.Vecteur2D#pScal(roomba.Vecteur2D)}.
	 */
	@Test
	public void testPScal() {
		Vecteur2D vect = new Vecteur2D(4,1);
		Vecteur2D vect2 = new Vecteur2D(-3,2);
		assertEquals(vect.pScal(vect2),-10,0);
	}
	
	/**
	 * Test method for {@link roomba.Vecteur2D#det(roomba.Vecteur2D)}.
	 */
	@Test
	public void testDet() {
		Vecteur2D vect = new Vecteur2D(3,-1);
		Vecteur2D vect2 = new Vecteur2D(4,-2);
		assertEquals(vect.det(vect2),-2,0);
	}

}
