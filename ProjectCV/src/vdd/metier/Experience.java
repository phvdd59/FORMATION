package vdd.metier;

public class Experience {

	private int id;
	private String dateExp;
	private String entreprise;
	private String poste;
	private String description;
	private Etudiant etudiant;

	public Experience() {
		dateExp = "";
		entreprise = "";
		poste = "";
		description = "";
		etudiant = null;
	}

	public Experience(int id,String dateExp, String entreprise, String poste, String description, Etudiant etudiant) {
		this.id=id;
		this.dateExp = dateExp;
		this.entreprise = entreprise;
		this.poste = poste;
		this.description = description;
		this.etudiant = etudiant;
	}

	public Experience(String dateExp, String entreprise, String poste, String description) {
		this.dateExp = dateExp;
		this.entreprise = entreprise;
		this.poste = poste;
		this.description = description;
		etudiant = null;
	}

	public String getDateExp() {
		return dateExp;
	}

	public void setDateExp(String dateExp) {
		this.dateExp = dateExp;
	}

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

}
