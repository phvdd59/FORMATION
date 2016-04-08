package aaa.viande;

import mapf.feculent.Preparer;

public class Volaille extends Viande implements ViandeGenerale, Preparer {

	private String etatVolaille = "non préparé";

	public Volaille() {
		super();
	}

	public Volaille(String nom, float poids) {
		super(nom, poids);
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
	public boolean estDeplume() {
		boolean plume = false;
		if (etatVolaille == "deplumé") {
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
		etatVolaille = "non decoupé";
		float p = this.getPoids();
		try {
			float time = 1000 * p;
			Thread.sleep(((long) time));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		etatVolaille = "decoupé";

	}

	@Override
	public boolean estDecoupe() {
		boolean decoupe = false;
		if (etatVolaille == "decoupé") {
			decoupe = true;
		}
		return decoupe;
	}

	public String getEtatVolaille() {
		return etatVolaille;
	}

	public void setEtatVolaille(String etatVolaille) {
		this.etatVolaille = etatVolaille;
	}

	@Override
	public void nettoyer() {

		etatVolaille = "sale";
		float p = this.getPoids();
		try {
			float time = 1000 * p;
			Thread.sleep(((long) time));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		etatVolaille = "nettoye";
	}

	@Override
	public void eplucher() {
		System.out.println("on epluche pas un poulet");

	}

	@Override
	public void lavage() {
		System.out.println("lavage c'est pas assez bien, il faut nettoyer...");

	}

}
