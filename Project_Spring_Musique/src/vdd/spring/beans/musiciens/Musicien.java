package vdd.spring.beans.musiciens;

import vdd.spring.beans.instruments.Instrument;
import vdd.spring.exception.JouerException;

public class Musicien implements Joueur {

	private String morceau;

	private Instrument instrument;

	public void jouer() throws JouerException {
		System.out.print(" joue " + morceau + " : ");
		instrument.jouer();
	}

	public void setMorceau(String morceau) {
		this.morceau = morceau;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public void arranger() {
		System.out.println("Arrangement de l'instrument avant utilisation");
	}

	public void nettoyer() {
		System.out.println("Nettoyage de l'instrument après utilisation");
	}

	public String getMorceau() {
		return morceau;
	}

	public Instrument getInstrument() {
		return instrument;
	}

}
