package mapf.feculent;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class TestMapf {

	Patate patate;

	@Before
	public void avant() {
		patate = new Patate();
	}

	@Test
	public void test() {
		// fail("Not yet implemented");
	}
	@Test
	public void testNettoyer(){
		Patate patatePropre = new Patate();
		long debut = new Date().getTime();
		patatePropre.nettoyer();
		long fin = new Date().getTime();
		long dif = fin - debut;
		boolean methodeOK = false;
		if (dif > 400 && dif<600) {
			methodeOK= true;
		} 
		assertTrue(methodeOK);
		assertEquals("propre", patatePropre.getEtatProprete());
		long debut2 = new Date().getTime();
		patatePropre.nettoyer();
		long fin2 = new Date().getTime();
		long dif2 = fin2 - debut2;
		boolean methodeOK2 = false;
		if (dif2<100) {
			methodeOK2= true;
		} 
		assertTrue(methodeOK2);
		assertEquals("propre", patatePropre.getEtatProprete());
	}
	
	@Test
	public void testEplucher(){
		Patate patate = new Patate();
		long debut = new Date().getTime();
		patate.eplucher();
		long fin = new Date().getTime();
		long dif = fin - debut;
		boolean methodeOK = false;
		if (dif > 900 && dif<1100) {
			methodeOK= true;
		} 
		assertTrue(methodeOK);
		assertEquals("epluchee", patate.getEtatPreparation());
		long debut2 = new Date().getTime();
		patate.eplucher();
		long fin2 = new Date().getTime();
		long dif2 = fin2 - debut2;
		boolean methodeOK2 = false;
		if (dif2<100) {
			methodeOK2= true;
		} 
		assertTrue(methodeOK2);
		assertEquals("epluchee", patate.getEtatPreparation());
	}
	

}
