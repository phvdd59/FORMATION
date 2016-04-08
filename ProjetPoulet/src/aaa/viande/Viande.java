package aaa.viande;

public class Viande extends vdd.metier.Alimentaire implements Volaille {

	private String etatAliment = "non préparé";

	public Viande() {
		super();
	}

	@Override
	public void deplumage() {
		etatAliment = "deplumage";
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		etatAliment = "deplumer";

	}

	@Override
	public void lavage() {
		etatAliment = "sale";
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		etatAliment = "propre";

	}

	@Override
	public boolean estDeplume() {
		boolean plume = false;
		if (etatAliment == "deplumé") {
			plume = true;
		}
		return plume;
	}

	@Override
	public boolean estLave() {
		boolean lave = false;
		if (etatAliment == "propre") {
			lave = true;
		}
		return lave;
	}

}
