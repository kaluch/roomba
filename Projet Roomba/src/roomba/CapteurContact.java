package roomba;


abstract class CapteurContact extends Capteur {

protected boolean contact;
	
	CapteurContact(Forme forme){
		super(forme);
		contact = false;
	}
	
	
	@Override
	public double lecture() {
		return (contact)? 1 :0;
	}
	public String toString(){
		return (contact)?forme.getPosture().getPosition().toString()+" " + "contact" :forme.getPosture().getPosition().toString() + " " +"non-contact"; 
	}

}
