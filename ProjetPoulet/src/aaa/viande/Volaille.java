package aaa.viande;

public class Volaille extends Viande implements ViandeGenerale {

	private String etatVolaille = "non pr�par�";

	public Volaille() {
		super();
	}

	@Override
	public void deplumage() {
		etatVolaille = "deplumage";
		float p = this.getPoids();
		try {
			float time = 1000 * p;
			Thread.sleep(((long) time));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		etatVolaille = "deplumer";

	}

	@Override
	public void lavage() {
		etatVolaille = "sale";
		float p = this.getPoids();
		try {
			float time = 1000 * p;
			Thread.sleep(((long) time));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		etatVolaille = "propre";

	}

	@Override
	public boolean estDeplume() {
		boolean plume = false;
		if (etatVolaille == "deplum�") {
			plume = true;
		}
		return plume;
	}

	@Override
	public boolean estLave() {
		boolean lave = false;
		if (etatVolaille == "propre") {
			lave = true;
		}
		return lave;
	}

	@Override
	public void decoupe() {
		etatVolaille = "non decoup�";
		float p = this.getPoids();
		try {
			float time = 1000 * p;
			Thread.sleep(((long) time));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		etatVolaille = "decoup�";

	}

	@Override
	public boolean estDecoupe() {
		// TODO Auto-generated method stub
		return false;
	}

}
