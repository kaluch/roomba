package com.roomba.ui;

import com.roomba.environnement.Environnement;

/**
 * represents the user interface
 * @author Lucas
 *
 */
public abstract class Interface {

	/**
	 * returns the current state of the animation of the simulation
	 * @return  true if the animation of the simulation is running
	 */
	abstract public boolean getAnimated();

	/**
	 * updates the display according to the situation
	 */
	abstract public void mAJ();

	/**
	 *  Return the state of the simulation
	 * @return true if the simulation is over
	 */
	abstract public boolean getClosed();

	/**
	 * behavior at the beginning of the simulation : initialization
	 */
	public abstract void debut();
	
	/**
	 * returns the current Environnement of the simulation
	 * @return  current Environnement of the simulation
	 */
	abstract public Environnement getEnviron();
	
}
