package ag.metier.produit;

public abstract class Produit {

	public static int CPT = 0;
	private float PrixUnitaire;
	private String nom;
	private int id;

	public Produit() {
		id = Produit.CPT;
		CPT++;
	}
	public Produit(String nom,float PrixUnitaire){
		id=Produit.CPT;
		this.nom=nom;
		this.nom=nom;
		CPT++;
	}
	public static int getCPT() {
		return CPT;
	}
	public static void setCPT(int cPT) {
		CPT = cPT;
	}
	public float getPrixUnitaire() {
		return PrixUnitaire;
	}
	public void setPrixUnitaire(float prixUnitaire) {
		PrixUnitaire = prixUnitaire;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public abstract float getPrix();
    public abstract boolean rajoute(Produit e);
 

    @Override
    public String toString() {
        return getNom() + " : " + getPrix();
    }

}
