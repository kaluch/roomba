package roomba;

public class IdiotVillage extends Comportement {

	@Override
	public Vecteur vitesseRoue1() {
		return new Vecteur2D(0,0.1);
	}

	@Override
	public Vecteur vitesseRoue2() {
		// TODO Auto-generated method stub
		return new Vecteur2D(0,0);
	}

}
