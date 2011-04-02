package com.roomba.robot;
import com.roomba.shape.Forme;
abstract class CapteurContact extends Capteur {

	protected boolean contact;

	CapteurContact(Forme forme) {
		super(forme);
		contact = false;
	}

	@Override
	public double lecture() {
		return (contact) ? 1 : 0;
	}

	public String toString() {
		return (contact) ? "contact" : "non-contact";
	}

}
