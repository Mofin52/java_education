package ru.avelikorechin.arrays;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
	* Tests for Turn class.
	* @author Alexander Velikorechin
	* @since 21.01.2017
*/

public class TurnTest {
	/**
		* Test back method with odd numbers of array elements.
	*/
	@Test
	public void whenSetArrayOf5ElementsThenReturnsCorrectResult() {
		final int[] arr  = new int[]{1, 2, 3, 4, 5};
		final int[] expect = new int[]{5, 4, 3, 2, 1};
		final Turn execute  = new Turn();
		int[] res = execute.back(arr);
		assertThat(res, is(expect));
	}
	/**
		* Test back method with even numbers of array elements.
	*/
	@Test
	public void whenSetArrayOf4ElementsThenReturnsCorrectResult() {
		final int[] arr  = new int[]{1, 2, 3, 4};
		final int[] expect = new int[]{4, 3, 2, 1};
		final Turn execute  = new Turn();
		int[] res = execute.back(arr);
		assertThat(res, is(expect));
	}
	/**
		* Test back method with 3 array elements.
	*/
	@Test
	public void whenSetArrayOf3ElementsThenReturnsCorrectResult() {
		final int[] arr  = new int[]{1, 2, 3};
		final int[] expect = new int[]{3, 2, 1};
		final Turn execute  = new Turn();
		int[] res = execute.back(arr);
		assertThat(res, is(expect));
	}
}