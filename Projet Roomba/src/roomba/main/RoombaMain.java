package roomba.main;

import com.roomba.comportement.*;
import com.roomba.robot.*;
import com.roomba.shape.*;
import com.roomba.ui.Interface;
import com.roomba.ui.InterfaceConsole;
import com.roomba.ui.InterfaceGraphique;
import com.roomba.ui.RoombaProjectX;

public class RoombaMain {

	/**
	 * usage : [-option] [--size=(100-150)] 
	 * option : X interface graphique
	 * 		size : mise a l'echelle de l'interface graphique
	 */
	public static void main(String[] args) {
		boolean isX = false;
		int size = 150;

		Comportement comportTest = new Hazard();
		Roomba roomba = new Roomba(0.34, comportTest);
		Interface out;
		Simulation simulation;
		roomba.addCapteur(new CapteurDistance(
				new Cercle(0.17 * Math.cos(Math.PI / 2)
						+ roomba.getPosture().getPosition().getX(), 0.17
						* Math.sin(Math.PI / 2)
						+ roomba.getPosture().getPosition().getY(),
						Math.PI / 12, 0.025), Math.PI / 12));
		roomba.addCapteur(new CapteurDistance(new Cercle(0.17
				* Math.cos(-Math.PI / 2)
				+ roomba.getPosture().getPosition().getX(), 0.17
				* Math.sin(-Math.PI / 2)
				+ roomba.getPosture().getPosition().getY(), -Math.PI / 12,
				0.025), -Math.PI / 12));
		if (args.length >= 1 && args.length <= 2) {
			for (String x : args) {
				if (x.equals("-X"))
					isX = true;
				if (x.contains("--size=")) {
					size = Integer.valueOf(x.substring(7));
					if (size < 100 || size > 150) {
						usage();
						return;
					}

				}
			}
		}

		if (args.length > 2) {
			RoombaMain.usage();
		}
		if (isX)
			out = new InterfaceGraphique(new RoombaProjectX(
					"Simulation Roomba", comportTest, size, roomba));

		else
			out = new InterfaceConsole(roomba);

		simulation = new Simulation(roomba, out, out.getEnviron());
		while (simulation.startSimulation())
			;

	}

	protected static void usage() {
		System.out.println("usage : [-option] [--size=(100-150)] ");
		System.out.println("option : X interface graphique");
		System.out.println("size : mise a l'echelle");
	}
}
