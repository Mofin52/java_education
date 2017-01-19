package ru.avelikorechin.conditions;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Test class for maximum methods.
 * @author Alexander Velikorechin
 * @since 19.01.2017
*/

public class MaxTest {
	/**
	* Test for max with two args.
	*/
	@Test
	public void whenInput5And10ThenReturns10() {
		final int first = 5;
		final int second = 10;
		final int expect = 10;
		final Max maximum = new Max();
		int res = maximum.max(first, second);
		assertThat(res, is(expect));
	}
	/**
	* Test for max with three args.
	*/
	@Test
	public void whenInput1And7And3ThenReturns7() {
		final int first = 1;
		final int second = 7;
		final int third = 3;
		final int expect = 7;
		final Max maximum = new Max();
		int res = maximum.max(first, second, third);
		assertThat(res, is(expect));
	}
}