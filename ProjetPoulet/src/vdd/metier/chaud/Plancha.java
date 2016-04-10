package vdd.metier.chaud;

import vdd.metier.Consommable;

public class Plancha extends Consommable implements Chaud {
	private static final int TEMPERATURE_MAX=100;
	private static final long serialVersionUID = 1L;
	public static final int ETAT_PLAQUE_FROID = 0x00;
	public static final int ETAT_PLAQUE_CHAUD = 0x01;

	private int temperature;
	private int etat;
	private boolean encours;

	public Plancha(String nom) {
		super(nom);
		etat = ETAT_PLAQUE_FROID;
		temperature = 0;
		encours = false;
	}

	@Override
	public void cuire() {

	}

	@Override
	public boolean estCuit() {
		return (etat & ETAT_PLAQUE_CHAUD) != 0;
	}

	@Override
	public boolean dorer() {
		return false;
	}

	@Override
	public boolean chauffer(int temperature) {
		while (this.temperature != TEMPERATURE_MAX) {
			System.out.println(this.getNom()+" non préchauffée");
			encours=true;
			etat=ETAT_PLAQUE_FROID;
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
			}
			this.temperature = this.temperature + (int) Math.signum(TEMPERATURE_MAX-this.temperature);
			System.out.println(this.getNom()+" préchauffée à "+this.temperature);
		}
		etat=ETAT_PLAQUE_CHAUD;
		encours=false;
		System.out.println(this.getNom()+" à température");
		return true;
	}
}
