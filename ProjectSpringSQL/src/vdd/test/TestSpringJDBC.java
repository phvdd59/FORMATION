package vdd.test;

import domaine.Employe;
import junit.framework.TestCase;
import vdd.sql.SpringJDBC;

public class TestSpringJDBC extends TestCase {

	private Employe emp;
	private String dataSource;
	private SpringJDBC springjdbc;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		emp = new Employe(4, "allan", "gros", "Gros", "Allan", "allan.gros@gmail.com", "employe");
		dataSource = "datasource1";
		springjdbc = new SpringJDBC();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		emp = null;
	}
	
	public void testCreateEmploye() {
		springjdbc.createEmploye(dataSource);
	}

	public void testSaveEmploye() {
		springjdbc.saveEmploye(emp, dataSource);
	}

	public void testGetEmployeById() {
		Employe employe = springjdbc.getEmployebyId(4);
		assertNotNull(employe);
	}
	
	public void testDropEmploye() {
		springjdbc.dropEmploye(dataSource);
	}
}
