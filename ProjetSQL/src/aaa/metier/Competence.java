package aaa.metier;

public class Competence {
	private String type;
	private String detail;
	private String niveau;

	public Competence() {
		type = "";
		detail = "";
		niveau = "";
	}

	public Competence(String type, String detail, String niveau) {
		this.type = type;
		this.detail = detail;
		this.niveau = niveau;
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
