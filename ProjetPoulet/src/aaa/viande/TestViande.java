package aaa.viande;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestViande {
	Volaille volaille;
	Four four;

	@Before
	public void before() {
		volaille = new Volaille("Poulet",3.5f);
		four=new Four();
	}

	@Test
	public void testDeplumer() {
		// fail("Not yet implemented");
		volaille.deplumage();
		String etat = volaille.getEtatVolaille();
		assertEquals("deplumer", etat);
	}

	@Test
	public void testLavage() {
		volaille.lavage();
		String etat = volaille.getEtatVolaille();
		assertEquals("propre", etat);
	}

	@Test
	public void testDecoupe() {
		volaille.decoupe();
		String etat = volaille.getEtatVolaille();
		assertEquals("decoupé", etat);
	}

	@Test
	public void testEstDecoupe() {
		boolean b=false;
		volaille.setEtatVolaille("decoupé");
		b=volaille.estDecoupe();
		assertTrue(b);
	}
	@Test 
	public void testPrechauffer(){
		four.prechauffer();
		String etat=four.getEtatDuFour();
		assertEquals("Prechauffe",etat);
	}
	@Test
	public void testCuire(){
		four.cuire(volaille);
		String etat=four.getEtatAliment();
		assertEquals("est cuit",etat);
	}

}
