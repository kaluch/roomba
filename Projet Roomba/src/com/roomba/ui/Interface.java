package com.roomba.ui;

/**
 * represents the user interface
 * @author Lucas
 *
 */
public abstract class Interface {


	abstract public boolean getAnimated();

	/**
	 * updates the display according to the situation
	 */
	abstract public void mAJ();

	abstract public boolean getClosed();

	/**
	 * behavior at the beginning of the simulation
	 */
	public abstract void debut();
	
}
