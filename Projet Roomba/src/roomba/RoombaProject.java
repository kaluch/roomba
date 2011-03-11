package roomba;

import javax.swing.JFrame;

public class RoombaProject {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

			Roomba roomba0 = new Roomba(0.2);
			//*
			Roomba roomba1 = new Roomba(0.2);
			Roomba roomba2 = new Roomba(0.2);
			Roomba roomba3 = new Roomba(0.2);
			Roomba roomba4 = new Roomba(0.2);

			double prec = 0;
			double temps_f = 12.6;
			int i =-1;
			double delta = 0.1;

			System.out.print("pos = [");
			prec = 0;
			System.out.println(roomba0.toString());
			for(double temps = 0+delta;temps<temps_f;temps+=delta){
				
				roomba0.calculVitesseRoue(new IdiotVillage());
				roomba0.move(temps-prec);
				System.out.println(roomba0.toString());
				prec = temps;
				
			}
			System.out.println("];");

			System.out.print("X = [");
			prec = 0;
			i++;
			System.out.println(roomba1.getCapteurs().get(i).getPosition().toString());
			for(double temps = 0+delta;temps<temps_f;temps+=delta){
				
				roomba1.calculVitesseRoue(new IdiotVillage());
				roomba1.move(temps-prec);
				System.out.println(roomba1.getCapteurs().get(i).getPosition().toString());
				prec = temps;
				
			}
			System.out.println("];");
			
			System.out.print("Y = [");
			prec = 0;
			i++;
			System.out.println(roomba2.getCapteurs().get(i).getPosition().toString());
			for(double temps = 0+delta;temps<temps_f;temps+=delta){
				
				roomba2.calculVitesseRoue(new IdiotVillage());
				roomba2.move(temps-prec);
				System.out.println(roomba2.getCapteurs().get(i).getPosition().toString());
				prec = temps;
				
			}
			System.out.println("];");
			System.out.print("Z = [");
			prec = 0;
			i++;
			System.out.println(roomba3.getCapteurs().get(i).getPosition().toString());
			for(double temps = 0+delta;temps<temps_f;temps+=delta){
				
				roomba3.calculVitesseRoue(new IdiotVillage());
				roomba3.move(temps-prec);
				System.out.println(roomba3.getCapteurs().get(i).getPosition().toString());
				prec = temps;
				
			}
			System.out.println("];");
			System.out.print(" W= [");
			prec = 0;
			i++;
			System.out.println(roomba4.getCapteurs().get(i).getPosition().toString());
			for(double temps = 0+delta;temps<temps_f;temps+=delta){
				
				roomba4.calculVitesseRoue(new IdiotVillage());
				roomba4.move(temps-prec);
				System.out.println(roomba4.getCapteurs().get(i).getPosition().toString());
				prec = temps;
				
			}
			System.out.println("];");
			//*/
			/*
			JFrame ma_fenetre = new JFrame("Cercle rouge");
		    Move m = new Move();
		    ma_fenetre.setContentPane(m);
		    //    ma_fenetre.pack();
		    ma_fenetre.show();
		    int x = 0;
		    boolean sens = true;

		    while (true)
		      {
			m.moveRobot(x, 0);
			if (sens)
			  x += 1;
			else
			  x -= 1;
			if (x == 0 || x == 100)
			  sens = !sens;
			// attend 0.01 sec
			try  { Thread.sleep(10); }
			catch (Exception e) {}
			// redessine (appelle entre autres paint())
			m.repaint();
		      }
		      //*/

	}
				
	

}
