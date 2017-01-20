package ru.avelikorechin.loops;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
	* Tests for Factorial class.
	* @author Alexander Velikorechin
	* @since 20.01.2017
*/

public class FactorialTest {
	/**
		* Test add method.
	*/
	@Test
	public void whenFactorialOf7ThenReturns5040() {
		final int number = 7;
		final int expect = 5040;
		final Factorial fact = new Factorial();
		int res = fact.factorial(number);
		assertThat(res, is(expect));
	}
}