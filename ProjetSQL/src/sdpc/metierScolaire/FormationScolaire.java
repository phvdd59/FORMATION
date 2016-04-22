package sdpc.metierScolaire;

public class FormationScolaire {

	private String date;
	private String diplome;
	private String ecole;

	public FormationScolaire() {
		date = "";
		diplome = "";
		ecole = "";

	}


	public FormationScolaire(String date, String diplome, String ecole) {
		this.date = date;
		this.diplome = diplome;
		this.ecole = ecole;

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
}
