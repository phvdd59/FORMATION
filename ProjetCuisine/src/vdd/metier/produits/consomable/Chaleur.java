package vdd.metier.produits.consomable;

public interface Chaleur {
	public boolean cuit=false;

	public void prechauffer();
	public void cuire();
	public boolean estCuit();
	public boolean estPreChauffer();
}
