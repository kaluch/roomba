package roomba;

public class InterfaceGraphique extends Interface {

	protected RoombaProjectX roombaX;
	
	InterfaceGraphique(RoombaProjectX roombaX){
		this.roombaX = roombaX;
	}
	@Override
	void startSimulation() {
		roombaX.setVisible(true);

	}

}
