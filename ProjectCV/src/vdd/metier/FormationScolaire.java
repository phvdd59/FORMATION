package vdd.metier;

public class FormationScolaire {

	private int id;
	private String date;
	private String diplome;
	private String ecole;
	private Etudiant etudiant; 

	public FormationScolaire() {
		id=0;
		date = "";
		diplome = "";
		ecole = "";
		etudiant=null;
	}


	public FormationScolaire(int id, String date, String diplome, String ecole,Etudiant etudiant) {
		this.id=id;
		this.date = date;
		this.diplome = diplome;
		this.ecole = ecole;
		this.etudiant=etudiant; 
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getDiplome() {
		return diplome;
	}


	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}


	public String getEcole() {
		return ecole;
	}


	public void setEcole(String ecole) {
		this.ecole = ecole;
	}

	
	public Etudiant getEtudiant() {
		return etudiant;
	}


	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}


	@Override
	public String toString() {
		return "Formation du " + date + " à " + ecole + " pour " + diplome;
	}
}
