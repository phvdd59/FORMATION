package vdd.frogjmp;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCodilityFrogJmp {

	CodilityFrogJmp frogJmp;

	@Before
	public void setUp() throws Exception {
		frogJmp = new CodilityFrogJmp();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
	}

	@Test
	public void testClassique() {
		assertEquals(3, frogJmp.solution(10, 85, 30));
	}

	@Test
	public void testGrand() {
		assertEquals(142857143, frogJmp.solution(1, 1000000000, 7));
	}

}
