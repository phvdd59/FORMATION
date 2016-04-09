package vdd.test;

import static org.junit.Assert.*;

import java.util.Date;

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
		assertEquals(0, lNormal.getPoids(), 0.00001f);
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
		long deb = new Date().getTime();
		l.decouper(l.getPoids());
		long fin = new Date().getTime();
		assertEquals("decouper", l.getEtat());
		System.out.println(fin - deb);
		assertTrue((900 <= (fin - deb) || (fin - deb >= 1100)));
	}

	@Test
	public void testEplucher() {
		Legume l = new Legume("carotte", 1, "pas epluché");
		l.eplucher(l.getPoids());
		assertEquals("epluché", l.getEtat());
	}
}
