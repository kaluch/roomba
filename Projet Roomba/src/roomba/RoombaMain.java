package roomba;

public class RoombaMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean isX = false;
		int size = 150;

		Comportement comportTest = new Hazard();
		Roomba roomba = new Roomba(0.34, comportTest);
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
		if (isX) {
			InterfaceGraphique kGraphique = new InterfaceGraphique(
					new RoombaProjectX("Simulation Roomba", comportTest, size,
							roomba));
			Simulation simulation = new Simulation(roomba, kGraphique,
					kGraphique.getEnviron());
			 while(!kGraphique.getClosed()){
				 simulation.startSimulation();
				 System.out.println("coucou");}

		} else {
			InterfaceConsole kConsole = new InterfaceConsole();
			kConsole.startSimulation();
		}

	}

	protected static void usage() {
		System.out.println("usage : [-option] [--size=(100-150)] ");
		System.out.println("option : X interface graphique");
		System.out.println("size : mise a l'echelle");
	}
}
