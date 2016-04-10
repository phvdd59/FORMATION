package vdd.metier.dessert;

import vdd.metier.chaud.Chaud;
import vdd.metier.epice.Sucre;

public interface PreparerFruit {

	public void ecraser();

	public void sucre(Sucre sucre);

	public void decoupe();

	public void griller(Chaud chaud);
}
