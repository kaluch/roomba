package roomba;


abstract class CapteurContact extends Capteur {

protected boolean contact;
	
	CapteurContact(Vecteur position){
		super(position);
		contact = false;
	}
	
	CapteurContact(Vecteur position,int facteurEchelle){
		super(position,facteurEchelle);
		contact = false;
	}
	
	@Override
	public double lecture() {
		return (contact)? 1 :0;
	}
	public String toString(){
		return (contact)?position.toString()/*+" " + "contact" */:position.toString() /*+ " " +"non-contact"*/; 
	}

}
