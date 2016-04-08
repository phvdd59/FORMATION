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
		volaille = new Volaille("Poulet",0.5f);
		four=new Four();
	}

	@Test
	public void testDeplumer() {
		// fail("Not yet implemented");
		volaille.setEtatVolaille("non pr�par�");
		volaille.deplumage();
		String etat = volaille.getEtatVolaille();
		assertEquals("deplumer", etat);
	}

	@Test
	public void testLavage() {
		volaille.setEtatVolaille("non pr�par�");
		volaille.nettoyer();
		String etat = volaille.getEtatVolaille();
		assertEquals("nettoye", etat);
	}

	@Test
	public void testDecoupe() {
		volaille.setEtatVolaille("non pr�par�");
		volaille.decoupe();
		String etat = volaille.getEtatVolaille();
		assertEquals("decoup�", etat);
	}

	@Test
	public void testEstDecoupe() {
		boolean b=false;
		volaille.setEtatVolaille("decoup�");
		b=volaille.estDecoupe();
		assertTrue(b);
	}
	@Test 
	public void testPrechauffer(){
		four.setEtatDuFour("froid");
		four.prechauffer();
		String etat=four.getEtatDuFour();
		assertEquals("Prechauffe",etat);
	}
	@Test
	public void testCuire(){
		four.setEtatDuFour("froid");
		four.setEtatAliment("cru");
		four.cuire(volaille);
		String etat=four.getEtatAliment();
		assertEquals("est cuit",etat);
	}

}
