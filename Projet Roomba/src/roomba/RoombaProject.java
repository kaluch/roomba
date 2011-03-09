package roomba;

public class RoombaProject {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

			Roomba roomba = new Roomba(0.2);
			System.out.println(roomba.toString());
			double prec = 0;
			for(double temps = 1;temps<13;temps+=0.5){
				
				roomba.calculVitesseRoue(new IdiotVillage());
				roomba.move(temps-prec);
				System.out.println(roomba.toString());
				prec = temps;
				
			}
	}
				
	

}
