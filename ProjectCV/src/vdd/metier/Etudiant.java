package vdd.metier;

public class Etudiant {

	private String nom;
	private String prenom;
	private String mail;
	private String metier;
	private String cv;

	private Formation formation;

	public Etudiant(String nom, String prenom, String mail, String metier,String cv, Formation formation) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.metier = metier;
		this.cv=cv;
		this.formation = formation;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMetier() {
		return metier;
	}

	public void setMetier(String metier) {
		this.metier = metier;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

}
