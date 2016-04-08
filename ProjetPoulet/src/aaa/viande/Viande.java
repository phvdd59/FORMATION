package aaa.viande;

public class Viande extends vdd.metier.Alimentaire implements Volaille {

	private String etat = "frigo";

	public Viande() {
		super();
	}

	@Override
	public void deplumage() {
		etat = "deplumage";
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		etat = "deplumer";

	}

	@Override
	public void lavage() {
		etat = "sale";
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		etat = "propre";

	}

	@Override
	public boolean estDeplume() {
		boolean plume = false;
		if (etat == "deplumé") {
			plume = true;
		}
		return plume;
	}

	@Override
	public boolean estLave() {
		boolean lave = false;
		if (etat == "propre") {
			lave = true;
		}
		return lave;
	}

}
