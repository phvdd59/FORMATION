package vdd.metier.produits;

public abstract class Produit implements Comparable<Produit> {
	public static int CPT = 0;

	private int id;
	private String nom;
	private float prixUnitaire;

	public Produit() {
		id = Produit.CPT;
		CPT++;
	}

	public Produit(String nom, float prixUnitaire) {
		id = Produit.CPT;
		this.nom = nom;
		this.prixUnitaire = prixUnitaire;
		CPT++;
	}

	public abstract float getPrix();

	public static int getCPT() {
		return CPT;
	}

	public static void setCPT(int cPT) {
		CPT = cPT;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	@Override
	public String toString() {
		return getNom()+" : "+getPrix()+"€";
	}

	public abstract boolean rajoute(Produit e);
}
