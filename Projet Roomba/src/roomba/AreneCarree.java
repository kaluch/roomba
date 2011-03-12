package roomba;


public class AreneCarree extends Arene {

	AreneCarree() {
	//Initialise un carre de 4m de cote
		super(4);
		for(int i=0;i<4;i++)
			this.getDimensions().set(i,new Integer(4));
	}
	
}
