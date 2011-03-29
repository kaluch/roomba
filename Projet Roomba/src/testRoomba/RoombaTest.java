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
public class RoombaTest {

	/**
	 * Test method for {@link roomba.Roomba#Roomba(double)}.
	 */
	@Test
	public void testRoomba() {
		IdiotVillage comp = new IdiotVillage();
		Roomba test = new Roomba(1,comp);
		assertEquals(test.getDiametre(),1,0);
		assertEquals(test.getCapteurs().size(),4,0);
		assertEquals(test.getRoues().size(),2,0);
	}
	
	/**
	 * Test method for {@link roomba.Roomba#move(double)}.
	 */
	@Test
	public void testMove() {
		IdiotVillage comp = new IdiotVillage();
		Roomba test = new Roomba(1,comp);
		Arene arene = new Arene(new Carre(0,0,0,5));
		Environnement environ = new Environnement(arene);
		assertEquals(test.getPosture().getX(),0,0);
		test.move(0.5, environ);
		assertEquals(test.getPosture().getX(),0.025,0.01);
	}

	/**
	 * Test method for {@link roomba.Roomba#toString()}.
	 */
	@Test
	public void testToString() {
		IdiotVillage comp = new IdiotVillage();
		Roomba test = new Roomba(1,comp);
		assertEquals(test.toString(),"0.0 0.0 0.0");
	}

	/**
	 * Test method for {@link roomba.Roomba#calculVitesseRoue(roomba.Comportement)}.
	 */
	@Test
	public void testCalculVitesseRoue() {
		IdiotVillage comp = new IdiotVillage();
		Roomba test = new Roomba(1,comp);
		test.calculVitesseRoue(); //TODO necessité de comp en param?
		assertEquals(test.getRoues().get(0).getVitesse(),0,0);
		assertEquals(test.getRoues().get(1).getVitesse(),0.1,0);
	}


}
