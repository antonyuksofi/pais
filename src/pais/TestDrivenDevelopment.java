package pais;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestDrivenDevelopment {
	
	public static double division(double a, double b) {
		//returns the result of operation a/b
		return a/b;
	}
	
	@Test
	public void division_test() {
		assertEquals(5, division(35, 7), 0.1);
	}
}
