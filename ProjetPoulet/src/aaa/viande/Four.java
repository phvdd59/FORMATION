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
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			etatAliment = "cuit";
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

}
