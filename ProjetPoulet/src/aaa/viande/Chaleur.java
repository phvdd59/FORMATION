package aaa.viande;

import vdd.metier.Alimentaire;

public interface Chaleur {
	public void prechauffer();

	public void cuire(Alimentaire aliment);

	public boolean estChaud();

	public boolean estCuit(Alimentaire aliment);

}
