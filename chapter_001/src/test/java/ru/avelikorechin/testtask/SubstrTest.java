package ru.avelikorechin.testtask;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
	* Tests for Substr class.
	* @author Alexander Velikorechin
	* @since 22.01.2017
*/

public class SubstrTest {
	/**
		* Test contain method with 3 chars substr, expect true.
	*/
	@Test
	public void whenSubOf3CharsIsInOriginThenReturnsTrue() {
		final String origin  = "abcdefj";
		final String sub = "cde";
		final Substr check = new Substr();
		final boolean expect = true;
		boolean res = check.contains(origin, sub);
		assertThat(res, is(expect));
	}

	/**
		* Test contain method with 3 chars substr, expect false.
	*/
	@Test
	public void whenSubOf3CharsIsInOriginThenReturnsFalse() {
		final String origin  = "abcdefj";
		final String sub = "xxx";
		final Substr check = new Substr();
		final boolean expect = false;
		boolean res = check.contains(origin, sub);
		assertThat(res, is(expect));
	}

	/**
		* Test contain method with 5 chars substr, expect true.
	*/
	@Test
	public void whenSubOf5CharsIsInOriginThenReturnsFalse() {
		final String origin  = "abcdefjklmnopqrstwxyz";
		final String sub = "mnopq";
		final Substr check = new Substr();
		final boolean expect = true;
		boolean res = check.contains(origin, sub);
		assertThat(res, is(expect));
	}
}