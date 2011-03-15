package testRoomba;

import static org.junit.Assert.*;

import org.junit.Test;

import roomba.Environnement;

public class EnvironnementTest {

	@Test
	public void testEnvironnement() {
		Environnement environ=new Environnement();
		assertEquals(environ.getObstacles().size(),3);
		assertEquals((int)environ.getObstacles().get(0).getPosture().getX(),0);
		assertEquals((int)environ.getObstacles().get(2).getPosture().getX(),50);
	
	}

	@Test
	public void testAjouterObstacle() {
		fail("Not yet implemented");
	}

	@Test
	public void testAjouterTache() {
		fail("Not yet implemented");
	}

	@Test
	public void testNettoyerTache() {
		fail("Not yet implemented");
	}

}
