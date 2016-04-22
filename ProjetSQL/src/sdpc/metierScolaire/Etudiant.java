package sdpc.metierScolaire;

public class Etudiant {

	private int idEtudiant;
	private String nom;
	private String prenom;
	private String metier;
	private String email;
	private String commentaire;
	private Formation formation;

	public Etudiant(int idEtudiant, String nom, String prenom, String metier, String email, String commentaire,
			Formation formation) {
		this.idEtudiant = idEtudiant;
		this.nom = nom;
		this.prenom = prenom;
		this.metier = metier;
		this.email = email;
		this.commentaire = commentaire;
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

	public String getMetier() {
		return metier;
	}

	public void setMetier(String metier) {
		this.metier = metier;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public int getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

}
