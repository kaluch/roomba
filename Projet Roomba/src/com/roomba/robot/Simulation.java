package com.roomba.robot;

import com.roomba.environnement.Environnement;
import com.roomba.ui.Interface;


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

	public boolean startSimulation() {
		if(out.getAnimated()&&!running){
			running = true;
			thread = new Thread(new PlayAnimation(roomba, environ, running));
			thread.start();
			
		}
		return !out.getClosed();
	}

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
