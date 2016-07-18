package vdd.metier;

public class Formateur {

	private int id;
	private String nom;
	private String mail;
	private String tel;
	private Formation formation;
	
	public Formateur(int id, String nom, String mail, String tel, Formation formation) {
		super();
		this.id = id;
		this.nom = nom;
		this.mail = mail;
		this.tel = tel;
		this.formation = formation;
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Formation getFormation() {
		return formation;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
	}
}
