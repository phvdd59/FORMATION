package vdd.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import vdd.personne.Personne;

public class TestVdd {

	Personne p;

	@Before
	public void avant() {
		p = new Personne("");
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
	}

	public void testPersonneConstructeur() {
		Personne pNull = new Personne(null);
		Personne pVide = new Personne("");
		Personne pNormal = new Personne("Normal");
		assertEquals("Personne0", pNull);
		assertEquals("", pVide);
		assertEquals("Normal", pNormal);
	}
}
