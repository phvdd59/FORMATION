package aaa.metier;

public class Competence {
	private String type;
	private String detail;
	private String niveau;
	private int idEtudiant;

	public Competence() {
		idEtudiant=-1;
		type = "";
		detail = "";
		niveau = "";
	}

	public Competence(int idEtudiant,String type, String detail, String niveau) {
		this.idEtudiant=idEtudiant;
		this.type = type;
		this.detail = detail;
		this.niveau = niveau;
	}

	public int getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
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

}
