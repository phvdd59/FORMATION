package aaa.viande;

public class Volaille extends Viande implements ViandeGenerale {

	private String etatAliment = "non pr�par�";
	
	public Volaille() {
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
		if (etatAliment == "deplum�") {
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
