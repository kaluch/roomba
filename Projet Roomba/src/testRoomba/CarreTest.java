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
public class CarreTest {

	/**
	 * Test method for {@link roomba.Carre#Carre(double, double, double, double)}.
	 */
	@Test
	public void testCarreDoubleDoubleDoubleDouble() {
		Carre test = new Carre(3,5,5,8);
		assertEquals(test.getPosture().getX(),3,0);
		assertEquals(test.getPosture().getY(),5,0);
		assertEquals(test.getPosture().getTheta(),5,0);
		assertEquals(test.getCote(),8,0);
	}

	/**
	 * Test method for {@link roomba.Carre#Carre(roomba.Posture, double)}.
	 */
	@Test
	public void testCarrePostureDouble() {
		Posture init = new Posture(1,2,3);
		assertEquals(init.getX(),1,0);
		assertEquals(init.getY(),2,0);
		assertEquals(init.getTheta(),3,0);
		init = new Posture(-13,21,33);
		assertEquals(init.getX(),-13,0);
		assertEquals(init.getY(),21,0);
		assertEquals(init.getTheta(),33,0);
	}

	/**
	 * Test method for {@link roomba.Carre#collisionInterne(roomba.Carre)}.
	 */
	@Test
	public void testCollisionInterneCarre() {
		Carre carre = new Carre(0,0,0,2);
		Carre c1 = new Carre(0,0,0,1), c2 = new Carre(0.5,0.5,0,1), c3 = new Carre(1.5,0.5,0,2), c4 = new Carre(2,2,0,0.3);
		assertEquals(carre.collisionInterne(c1),false);
		assertEquals(carre.collisionInterne(c2),true);
		assertEquals(carre.collisionInterne(c3),true);
		assertEquals(carre.collisionInterne(c4),true);
	}

	/**
	 * Test method for {@link roomba.Carre#collisionExterne(roomba.Carre)}.
	 */
	@Test
	public void testCollisionExterneCarre() {
		Carre carre = new Carre(0,0,0,2);
		Carre c1 = new Carre(0,0,0,1), c2 = new Carre(0.5,0.5,0,1), c3 = new Carre(1.5,0.5,0,2), c4 = new Carre(2,2,0,0.3);
		assertEquals(carre.collisionInterne(c1),true);
		assertEquals(carre.collisionInterne(c2),true);
		assertEquals(carre.collisionInterne(c3),true);
		assertEquals(carre.collisionInterne(c4),false);
	}

	/**
	 * Test method for {@link roomba.Carre#collisionInterne(roomba.Cercle)}.
	 */
	@Test
	public void testCollisionInterneCercle() {
		Carre carre1 = new Carre(0,0,0,2);
		Cercle cercle1 = new Cercle(0,0,0,2), cercle2 = new Cercle(0,0,0,1), cercle3 = new Cercle(0,0,0,3),cercle4=new Cercle(1.5,1.5,0,1);
		assertEquals(carre1.collisionInterne(cercle1),true);
		assertEquals(carre1.collisionInterne(cercle2),false);
		assertEquals(carre1.collisionInterne(cercle3),true);
		assertEquals(carre1.collisionInterne(cercle4),true);
	}

	/**
	 * Test method for {@link roomba.Carre#collisionExterne(roomba.Cercle)}.
	 */
	@Test
	public void testCollisionExterneCercle() {
		Carre carre1 = new Carre(0,0,0,2);
		Cercle cercle1 = new Cercle(0,0,0,2), cercle2 = new Cercle(4,3,0,1), cercle3 = new Cercle(2,0,0,2), cercle4 = new Cercle(0,0,0,0.5);
		assertEquals(carre1.collisionExterne(cercle1),true);
		assertEquals(carre1.collisionExterne(cercle2),false);
		assertEquals(carre1.collisionExterne(cercle3),true);
		assertEquals(carre1.collisionExterne(cercle4),true);
	}

	/**
	 * Test method for {@link roomba.Carre#collisionInterne(roomba.Rectangle)}.
	 */
	@Test
	public void testCollisionInterneRectangle() {
		Carre carre1 = new Carre(0,0,0,2);
		Rectangle rect1 = new Rectangle(0,0,0,1,1.5), rect2 = new Rectangle(1,0,0,1,0.75), rect3 = new Rectangle(1,0,0,2,2), rect4 = new Rectangle(3,0,0,1,2);
		assertEquals(carre1.collisionInterne(rect1),false);//TODO foire
		assertEquals(carre1.collisionInterne(rect2),true);
		assertEquals(carre1.collisionInterne(rect3),true);
		assertEquals(carre1.collisionInterne(rect4),true);
	}

	/**
	 * Test method for {@link roomba.Carre#collisionExterne(roomba.Rectangle)}.
	 */
	@Test
	public void testCollisionExterneRectangle() {
		Carre carre1 = new Carre(0,0,0,2);
		Rectangle rect1 = new Rectangle(0,0,0,1,1.5), rect2 = new Rectangle(1,0,0,1,0.75), rect3 = new Rectangle(1,0,0,2,2), rect4 = new Rectangle(3,0,0,1,1.5);
		assertEquals(carre1.collisionExterne(rect1),true);
		assertEquals(carre1.collisionExterne(rect2),true);
		assertEquals(carre1.collisionExterne(rect3),true);
		assertEquals(carre1.collisionExterne(rect4),false);
	}


}
