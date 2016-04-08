package bcsd.legume;

import vdd.metier.Alimentaire;

public class Legume extends Alimentaire implements PreparerLegume {

	private static final long serialVersionUID = 1L;

	private String estLave;
	private String estEpluche;
	private String estDecoupe;
	private String estCuit;

	public Legume() {
		super();
		this.estLave = "pas lavé";
		this.estEpluche = "pas epluché";
		this.estDecoupe = "pas decoupé";
		this.estCuit = "pas cuit";
	}

	public Legume(String nom, float poids, String estLave, String estEpluche, String estDecoupe, String estCuit) {
		super(nom, poids);
		this.estLave = estLave;
		this.estEpluche = estEpluche;
		this.estDecoupe = estDecoupe;
		this.estCuit = estCuit;
	}

	@Override
	public void laver(float poids) {
		try {
			Thread.sleep(1000 * ((long) poids));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("C'est lavé");
	}

	@Override
	public void decouper(float poids) {
		try {
			Thread.sleep((long) (1000 * poids));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("C'est decoupé");
	}

	@Override
	public void eplucher(float poids) {
		try {
			Thread.sleep((long) (1000 * poids));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("C'est epluché");
	}

	public String getEstLave() {
		return estLave;
	}

	public void setEstLave(String estLave) {
		this.estLave = estLave;
	}

	public String getEstEpluche() {
		return estEpluche;
	}

	public void setEstEpluche(String estEpluche) {
		this.estEpluche = estEpluche;
	}

	public String getEstDecoupe() {
		return estDecoupe;
	}

	public void setEstDecoupe(String estDecoupe) {
		this.estDecoupe = estDecoupe;
	}

	public String getEstCuit() {
		return estCuit;
	}

	public void setEstCuit(String estCuit) {
		this.estCuit = estCuit;
	}

}
