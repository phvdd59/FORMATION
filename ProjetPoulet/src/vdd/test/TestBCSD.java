package vdd.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bcsd.legume.Legume;

public class TestBCSD {

	Legume l;

	@Before
	public void avant() {
		l = new Legume("", 0, null);
	}

	@Test
	public void test() {
		// fail("Not yet implemented");
	}

	@Test
	public void testLegume() {
		Legume lVide = new Legume("", 0, null);
		Legume lNormal = new Legume("Normal", 0, null);
		assertEquals("", lVide.getNom());
		assertEquals("Normal", lNormal.getNom());
		//assertEquals(0, lNormal.getPoids());
	}

	@Test
	public void testLaver() {
		Legume l = new Legume("carotte", 1, "sale");
		l.laver(l.getPoids());
		assertEquals("propre", l.getEtat());
	}

	@Test
	public void testDecouper() {
		Legume l = new Legume("carotte", 1, "propre");
		l.decouper(l.getPoids());
		assertEquals("decouper", l.getEtat());
	}

	@Test
	public void testEplucher() {
		Legume l = new Legume("carotte", 1, "pas epluché");
		l.eplucher(l.getPoids());
		assertEquals("epluché", l.getEtat());
	}
}
