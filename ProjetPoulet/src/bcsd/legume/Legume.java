package bcsd.legume;

import vdd.metier.Alimentaire;

public class Legume extends Alimentaire implements PreparerLegume {

	private static final long serialVersionUID = 1L;

	private String etat;

	public Legume() {
		super();
		this.etat = "";
	}

	public Legume(String nom, float poids, String etat) {
		super(nom, poids);
		this.etat = etat;
	}

	@Override
	public void laver(float poids) {
		System.out.println("sale");
		try {
			System.out.println("en cours de lavage");
			Thread.sleep(1000 * ((long) getPoids()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("propre");
		this.etat = "propre";
	}

	@Override
	public void decouper(float poids) {
		if (this.getEtat().equals("propre")) {
			System.out.println("entier");
			try {
				System.out.println("En cours de d�coupage");
				Thread.sleep((long) (1000 * getPoids()));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("C'est decoup�");
			this.etat = "decouper";
		} else {
			System.out.println("Laver le produit avant de d�couper !");
		}
	}

	@Override
	public void eplucher(float poids) {
		System.out.println("pas epluch�");
		try {
			System.out.println("en cours d'�pluchage");
			Thread.sleep((long) (1000 * getPoids()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.etat = "epluch�";
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

}
