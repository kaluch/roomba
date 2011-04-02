package com.roomba.ui;

import com.roomba.environnement.Environnement;


public class InterfaceGraphique extends Interface {

	protected RoombaProjectX roombaX;
	
	public InterfaceGraphique(RoombaProjectX roombaX){
		this.roombaX = roombaX;
		roombaX.setVisible(true);
	}

	@Override
	public boolean getAnimated() {
		return roombaX.getAnimated();
	}
	@Override
	public void mAJ() {
		roombaX.mAJ();
		
	}

	public Environnement getEnviron(){
		return roombaX.getEnviron();
	}

	public RoombaProjectX getRoombaX() {
		return roombaX;
	}
	public boolean getClosed(){return roombaX.getClosed();}


}
