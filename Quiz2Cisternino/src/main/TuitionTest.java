/**
 * @Author Michael Cisternino
 */
package main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TuitionTest {
	Tuition t;
	double total = t.totalTuition(12520, .01);
	double testTotal = 58076.71;
	double payment = t.payment(.07, 10, 58076.71);
	double testPayment = -674.32;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTuition() {
		System.out.println("@Test Tuition(): " + total + " = " + testTotal);
		assertEquals(total, testTotal, .01);
	}
	
	@Test
	public void testPayment() {
		System.out.println("@Test MonthlyPayment(): " + payment + " = " +testPayment);
		assertEquals(payment, testPayment, .01);
	}

}
