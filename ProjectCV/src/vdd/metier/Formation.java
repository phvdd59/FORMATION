package vdd.metier;

public class Formation {

	private String dateFormation;
	private String lieuFormation;
	private String domaineFormation;

	public Formation(String dateFormation, String lieuFormation, String domaineFormation) {
		super();
		this.dateFormation = dateFormation;
		this.lieuFormation = lieuFormation;
		this.domaineFormation = domaineFormation;
	}

	public String getDateFormation() {
		return dateFormation;
	}

	public void setDateFormation(String dateFormation) {
		this.dateFormation = dateFormation;
	}

	public String getLieuFormation() {
		return lieuFormation;
	}

	public void setLieuFormation(String lieuFormation) {
		this.lieuFormation = lieuFormation;
	}

	public String getDomaineFormation() {
		return domaineFormation;
	}

	public void setDomaineFormation(String domaineFormation) {
		this.domaineFormation = domaineFormation;
	}
}
