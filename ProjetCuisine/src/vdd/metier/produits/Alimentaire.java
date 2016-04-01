package vdd.metier.produits;

public class Alimentaire extends Produit implements Comparable<Produit> {
	public static int ETAT_CRU = 0;
	public static int ETAT_EN_PREPARATION = 1;
	public static int ETAT_CUIT = 2;
	public static int ETAT_CRAME = 3;

	private float poids;
	private long dureeCuisson;
	private int etat;

	public Alimentaire() {
		super();
	}

	public Alimentaire(String nom, float poids, float prixUnitaire) {
		super(nom, prixUnitaire);
		this.poids = poids;
	}

	@Override
	public float getPrix() {
		return getPrixUnitaire() * getPoids();
	}

	public float getPoids() {
		return poids;
	}

	public void setPoids(float poids) {
		this.poids = poids;
	}

	@Override
	public boolean rajoute(Produit e) {
		boolean ok = false;
		if (e instanceof Alimentaire && e.getNom().equals(this.getNom())) {
			Alimentaire a = (Alimentaire) e;
			this.setPrixUnitaire((this.getPrix() + e.getPrix()) / (this.getPoids() + a.getPoids()));
			this.setPoids(this.getPoids() + a.getPoids());
			ok = true;
		}
		return ok;
	}

	@Override
	public boolean equals(Object obj) {
		boolean retour = false;
		if (obj instanceof Alimentaire) {
			Alimentaire e = (Alimentaire) obj;
			retour = this.getNom().equals(e.getNom());
		}
		System.out.println("equals Alimentaire " + this + " " + retour);
		return retour;
	}

	@Override
	public int hashCode() {
		return this.getNom().hashCode();
	}

	@Override
	public int compareTo(Produit p) {
		int retour = 0;
		if (p instanceof Consomable) {
			retour = 1;
		} else if (p instanceof Alimentaire) {
			retour = this.getNom().compareTo(p.getNom());
		}
		return retour;
	}
}
