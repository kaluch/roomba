package roomba;

public class RoombaProject {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

			Roomba roomba = new Roomba(0.2);
			double prec = 0;
			int i =-1;
			double delta = 0.02;

			System.out.print("pos = [");
			prec = 0;
			System.out.println(roomba.toString());
			for(double temps = 1;temps<5;temps+=delta){
				
				roomba.calculVitesseRoue(new IdiotVillage());
				roomba.move(temps-prec);
				System.out.println(roomba.toString());
				prec = temps;
				
			}
			System.out.println("];");

			System.out.print("X = [");
			prec = 0;
			i++;
			System.out.println(roomba.getCapteurs().get(i).getPosition().toString());
			for(double temps = 1;temps<5;temps+=delta){
				
				roomba.calculVitesseRoue(new IdiotVillage());
				roomba.move(temps-prec);
				System.out.println(roomba.getCapteurs().get(i).getPosition().toString());
				prec = temps;
				
			}
			System.out.println("];");
			
			System.out.print("Y = [");
			prec = 0;
			i++;
			System.out.println(roomba.getCapteurs().get(i).getPosition().toString());
			for(double temps = 1;temps<5;temps+=delta){
				
				roomba.calculVitesseRoue(new IdiotVillage());
				roomba.move(temps-prec);
				System.out.println(roomba.getCapteurs().get(i).getPosition().toString());
				prec = temps;
				
			}
			System.out.println("];");
			System.out.print("Z = [");
			prec = 0;
			i++;
			System.out.println(roomba.getCapteurs().get(i).getPosition().toString());
			for(double temps = 1;temps<5;temps+=delta){
				
				roomba.calculVitesseRoue(new IdiotVillage());
				roomba.move(temps-prec);
				System.out.println(roomba.getCapteurs().get(i).getPosition().toString());
				prec = temps;
				
			}
			System.out.println("];");
			System.out.print(" W= [");
			prec = 0;
			i++;
			System.out.println(roomba.getCapteurs().get(i).getPosition().toString());
			for(double temps = 1;temps<5;temps+=delta){
				
				roomba.calculVitesseRoue(new IdiotVillage());
				roomba.move(temps-prec);
				System.out.println(roomba.getCapteurs().get(i).getPosition().toString());
				prec = temps;
				
			}
			System.out.println("];");
			System.out.print(" V= [");
			prec = 0;
			i++;
			System.out.println(roomba.getCapteurs().get(i).getPosition().toString());
			for(double temps = 1;temps<5;temps+=delta){
				
				roomba.calculVitesseRoue(new IdiotVillage());
				roomba.move(temps-prec);
				System.out.println(roomba.getCapteurs().get(i).getPosition().toString());
				prec = temps;
				
			}
			System.out.println("];");

	}
				
	

}
