package vdd.metier;

public class Competence {
	
	private int id;
	private String type;
	private String detail;
	private String niveau;
	private Etudiant etudiant;

	public Competence() {
		id=0;
		type = "";
		detail = "";
		niveau = "";
		etudiant=null;
	}

	public Competence(int id,String type, String detail, String niveau,Etudiant etudiant) {
		this.id=id;
		this.type = type;
		this.detail = detail;
		this.niveau = niveau;
		this.etudiant=etudiant;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
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
