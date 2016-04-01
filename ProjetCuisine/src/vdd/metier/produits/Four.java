package vdd.metier.produits;

public class Four extends Consomable {
	public static int ETAT_FOUR_FROID = 0;
	public static int ETAT_FOUR_EN_CHAUFFE = 1;
	public static int ETAT_FOUR_CHAUD = 2;
	
	private int degre;
	private int etat;
	
	public void cuire(Alimentaire aliment) {
	}
}
