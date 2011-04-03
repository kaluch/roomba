/**
 * 
 */
package com.testroomba;

import static org.junit.Assert.*;
import com.roomba.robot.*;
import org.junit.Test;

/**
 * @author Lucas
 *
 */
public class RoueTest {

	/**
	 * Test method for {@link com.roomba.robot.Roue#Roue()}.
	 */
	@Test
	public void testRoue() {
		Roue test = new Roue();
		assertEquals(test.getVitesse(),0,0);
	}

	/**
	 * Test method for {@link com.roomba.robot.Roue#Roue(double)}.
	 */
	@Test
	public void testRoueDouble() {
		Roue test = new Roue(15.3);
		assertEquals(test.getVitesse(),15.3,0);
	}

	/**
	 * Test method for {@link com.roomba.robot.Roue#toString()}.
	 */
	@Test
	public void testToString() {
		Roue test = new Roue(-21.8);
		assertEquals(test.toString(),"-21.8");
	}

}
