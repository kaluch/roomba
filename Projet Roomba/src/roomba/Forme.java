package roomba;


import java.util.ArrayList;

public class Forme {

	/*
	 * ATTRIBUTS
	 */
	
	protected int nbDeCote;
	protected ArrayList<Integer> dimensions;
	protected Posture posture;
	
	/*
	 * METHODES
	 */
	//Constructor
	Forme(int nbCote)
	{
		nbDeCote = nbCote;
		for(int i = 0;i<nbCote;i++)
			dimensions.add(new Integer(1));
	}

	public ArrayList<Integer> getDimensions() {
		return dimensions;
	}

	public void setDimensions(int dim, int index) {
		this.dimensions.set(index, dim);
	}

	public Posture getPosture() {
		return posture;
	}

	public void setPosture(Posture posture) {
		this.posture = posture;
	}

	public int getNbDeCote() {
		return nbDeCote;
	}

	
}
