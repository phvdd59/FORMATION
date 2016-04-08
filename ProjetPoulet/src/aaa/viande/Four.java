package aaa.viande;

import vdd.metier.Alimentaire;
import vdd.metier.Consommable;

public class Four extends Consommable implements Chaleur {
	String etatDuFour = "froid";
	String etatAliment = "cru";

	public Four() {
		super();

	}

	@Override
	public void prechauffer() {
		etatDuFour = "en Prechauffage";
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		etatDuFour = "Prechauffe";

	}

	@Override

	public void cuire(Alimentaire aliment) {
		if (etatAliment == "cru") {
			etatAliment = "en cuisson";
			float p = aliment.getPoids();
			try {
				float time = 10000 * p;
				Thread.sleep(((long) time));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean estChaud() {
		boolean chaud = false;
		if (etatDuFour == "Prechauffe") {
			chaud = true;
		}
		return chaud;
	}

	@Override
	public boolean estCuit(Alimentaire aliment) {
		boolean cuit = false;
		if (etatAliment == "cuit") {
			cuit = true;
		}
		return cuit;
	}

	public String getEtatDuFour() {
		return etatDuFour;
	}

	public void setEtatDuFour(String etatDuFour) {
		this.etatDuFour = etatDuFour;
	}

	public String getEtatAliment() {
		return etatAliment;
	}

	public void setEtatAliment(String etatAliment) {
		this.etatAliment = etatAliment;
	}

}
