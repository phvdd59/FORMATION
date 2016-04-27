package vdd.spring.beans.instruments;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import vdd.spring.beans.musiciens.Joueur;
import vdd.spring.exception.JouerException;

@Component("groupe")
public class GroupeMusique implements Joueur {

	@Value("{instruments}")
	private Collection<Instrument> instruments;

	public GroupeMusique() {
		super();
	}

	public void jouer() throws JouerException {
		for (Instrument instrument : instruments) {
			instrument.jouer();
		}
	}

	public void setInstruments(Collection<Instrument> instruments) {
		this.instruments = instruments;
	}
}
