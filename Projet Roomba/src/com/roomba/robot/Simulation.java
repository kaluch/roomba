package com.roomba.robot;

import com.roomba.environnement.Environnement;
import com.roomba.ui.Interface;

/**
 * represents the whole simulation.
 * It contains the robot, the environment and an user interface
 * @author Lucas
 *
 */
public class Simulation {

	protected Roomba roomba;
	protected Environnement environ;
	protected Interface out;
	private Thread thread;
	Boolean running = false;

	public Simulation(Roomba roomba, Interface out, Environnement environ) {
		this.roomba = roomba;
		this.environ = environ;
		this.out = out;
		out.debut();
	}

	/**
	 * launch the simulation
	 * @return
	 */
	public boolean startSimulation() {
		if(out.getAnimated()&&!running){
			running = true;
			thread = new Thread(new PlayAnimation(roomba, environ, running));
			thread.start();
			
		}
		return !out.getClosed();
	}

	/**
	 * behavior when the simulation is not paused
	 * @return
	 */
	public boolean go() {
		out.mAJ();
		while (out.getAnimated()) {
			roomba.move(0.01, environ);
			out.mAJ();
			// attend 0.01 sec
			try {
				Thread.sleep(10);
			} catch (Exception e) {
			}
		}
		return false;
	}

	/**
	 * Concerns the thread of the animation of the movement of the robot
	 * @author Lucas
	 *
	 */
	class PlayAnimation implements Runnable {

		Roomba roomba;
		Environnement environ;

		PlayAnimation(Roomba roomba, Environnement environ,Boolean mooving) {
			this.roomba = roomba;
			this.environ = environ;
		}
		@Override
		public void run() {
			running = go();

		}
	}
}
