package ru.avelikorechin.testtask;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
	* Tests for JoinSortedArrays class.
	* @author Alexander Velikorechin
	* @since 25.01.2017
*/

public class JoinSortedArraysTest {
	/**
		* Test joinArrays method with 2 arrays of equal length.
	*/
	@Test
	public void whenJoinTwoArraysWithEqualLengthThenReturnsSortedArrays() {
		final int[] first = {1, 3, 5};
		final int[] second = {2, 4, 6};
		final int[] expect = {1, 2, 3, 4, 5, 6};
		final JoinSortedArrays joiner = new JoinSortedArrays();
		int[] res = joiner.joinArrays(first, second);
		assertThat(res, is(expect));
	}

	/**
		* Test joinArrays method with 2 arrays of not equal length.
	*/
	@Test
	public void whenJoinTwoArraysWithNotEqualLengthThenReturnsSortedArrays() {
		final int[] first = {1, 3, 5, 7, 8, 9};
		final int[] second = {2, 4, 6};
		final int[] expect = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		final JoinSortedArrays joiner = new JoinSortedArrays();
		int[] res = joiner.joinArrays(first, second);
		assertThat(res, is(expect));
	}

}