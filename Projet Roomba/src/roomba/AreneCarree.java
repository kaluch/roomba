package roomba;

public class AreneCarree extends Arene {

	AreneCarree() {
	//Initialise un carr� de 4m de cot�
		super(4);
		for(int i=0;i<4;i++)
			this.getDimensions().set(i,new Integer(4));
	}
	
}
