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
public class CapteurDistanceTest {

	/**
	 * Test method for {@link roomba.CapteurDistance#miseAjour(roomba.Environnement)}.
	 */
	@Test
	public void testMiseAjour() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link roomba.CapteurDistance#lecture()}.
	 */
	@Test
	public void testLecture() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link roomba.CapteurDistance#CapteurDistance(roomba.Forme, double)}.
	 */
	@Test
	public void testCapteurDistance() {
		Cercle c = new Cercle(0,1,0,0.4);
		CapteurDistance capt = new CapteurDistance(c,0);
		assertEquals(capt.getForme(),c);
		assertEquals(capt.getOrientation(),0,0);
	}

}
