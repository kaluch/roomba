package roomba;



public class Forme {

	/*
	 * ATTRIBUTS
	 */
	
	protected int nbDeCote;
	protected int dimension;
	protected Posture posture;
	
	/*
	 * METHODES
	 */
	//Constructor
	Forme(int nbCote,double x, double y, double theta, int dim)
	{
		nbDeCote = nbCote;
		this.posture = new Posture(x,y,theta);
		dimension = dim; 
	}

	public int getDimension() {
		return dimension;
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
