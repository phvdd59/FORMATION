package mfa.sql;

public class Experience {

	private String dateExp;
	private String entreprise;
	private String poste;
	
	public Experience(String dateExp,String entreprise, String poste){
		this.dateExp=dateExp;
		this.entreprise=entreprise;
		this.poste=poste;
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
	
}
