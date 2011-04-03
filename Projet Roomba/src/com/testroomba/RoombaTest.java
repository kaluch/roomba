/**
 * 
 */
package com.testroomba;

import static org.junit.Assert.*;
import com.roomba.comportement.*;
import com.roomba.robot.*;
import com.roomba.environnement.*;
import com.roomba.shape.*;
import org.junit.Test;

/**
 * @author Lucas
 *
 */
public class RoombaTest {

	/**
	 * Test method for {@link com.roomba.robot.Roomba#Roomba(double,com.roomba.comportement.Comportement)}.
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
	 * Test method for {@link com.roomba.robot.Roomba#move(double,com.roomba.environnement.Environnement)}.
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
	 * Test method for {@link com.roomba.robot.Roomba#toString()}.
	 */
	@Test
	public void testToString() {
		IdiotVillage comp = new IdiotVillage();
		Roomba test = new Roomba(1,comp);
		assertEquals(test.toString(),"0.0 0.0 0.0");
	}

	/**
	 * Test method for {@link com.roomba.robot.Roomba#calculVitesseRoue()}.
	 */
	@Test
	public void testCalculVitesseRoue() {
		IdiotVillage comp = new IdiotVillage();
		Roomba test = new Roomba(1,comp);
		test.calculVitesseRoue();
		assertEquals(test.getRoues().get(0).getVitesse(),0,0);
		assertEquals(test.getRoues().get(1).getVitesse(),0.1,0);
	}


}
