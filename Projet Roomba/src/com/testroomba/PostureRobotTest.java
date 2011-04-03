package com.testroomba;

import static org.junit.Assert.*;
import com.roomba.roombautil.*;
import org.junit.Test;

public class PostureRobotTest {

	@Test
	public void testPostureRobot() {
		PostureRobot post = new PostureRobot(1,4,3);
		assertEquals(post.getX(),1,0);
		assertEquals(post.getY(),4,0);
		assertEquals(post.getTheta(),3,0);
	}

	@Test
	public void testMove() {
		PostureRobot post = new PostureRobot(1,4,3);
		post.move(0, 0.1*Math.PI, 0.1);
		assertEquals(post.getX(),1,0.1);
		assertEquals(post.getY(),4,0.1);
		assertEquals(post.getTheta(),3-Math.PI,0.1);
	}

	@Test
	public void testPosture() {
		Posture post = new Posture(2,-3,1);
		assertEquals(post.getX(),2,0);
		assertEquals(post.getY(),-3,0);
		assertEquals(post.getTheta(),1,0);
	}

	@Test
	public void testRotate() {
		Posture post = new Posture(1,2,3);
		post.rotate(Math.PI);
		assertEquals(post.getX(),-1,0.1);
		assertEquals(post.getY(),-2,0.1);
		assertEquals(post.getTheta(),3-Math.PI,0.1);
	}

	@Test
	public void testToString() {
		Posture post = new Posture(1,2,3);
		assertEquals(post.toString(),"1.0 2.0 3.0");
	}


}
