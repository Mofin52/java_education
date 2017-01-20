package ru.avelikorechin.loops;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
	* Tests for Counter class.
	* @author Alexander Velikorechin
	* @since 20.01.2017
*/

public class CounterTest {
	/**
		* Test add method.
	*/
	@Test
	public void whenCountFrom4To50ThenReturns648() {
		final int first = 4;
		final int second = 50;
		final int expect = 648;
		final Counter count = new Counter();
		int res = count.add(first, second);
		assertThat(res, is(expect));
	}
}