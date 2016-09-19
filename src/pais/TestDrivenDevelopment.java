package pais;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestDrivenDevelopment {
	
	public static double division() {
		//returns the result of operation 35/7
		return 35/7;
	}
	
	@Test
	public void division_test() {
		assertEquals(5, division(), 0.1);
	}
}
