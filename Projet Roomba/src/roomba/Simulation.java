package roomba;

public class Simulation {

	protected Roomba roomba;
	protected Environnement environ;
	protected Interface out;
	private Thread thread;

	Simulation(Roomba roomba, Interface out, Environnement environ) {
		this.roomba = roomba;
		this.environ = environ;
		this.out = out;
	}

	public boolean startSimulation() {
		if (out.getAnimated()) {
			thread = new Thread(new PlayAnimation(roomba, environ));
			thread.start();
			System.out.println(roomba.toString());

		}
		return true;
	}

	public void go() {
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

	}

	class PlayAnimation implements Runnable {

		Roomba roomba;
		Environnement environ;

		PlayAnimation(Roomba roomba, Environnement environ) {
			this.roomba = roomba;
			this.environ = environ;
		}

		@Override
		public void run() {
			go();
		}
	}

}
