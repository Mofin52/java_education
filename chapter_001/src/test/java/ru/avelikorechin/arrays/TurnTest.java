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
	/**
		* Test bubbleSort method with unsorted array.
	*/
	@Test
	public void whenSetUnsortedArrayThenReturnsSortedArray() {
		final int[] arr  = new int[]{4, 6, 1, 9, 14, 2};
		final int[] expect = new int[]{1, 2, 4, 6, 9, 14};
		final Turn execute  = new Turn();
		int[] res = execute.bubbleSort(arr);
		assertThat(res, is(expect));
	}
	/**
		* Test bubbleSort method with sorted array.
	*/
	@Test
	public void whenSetUnsortedArrayThenReturnsTheSame() {
		final int[] arr  = new int[]{1, 2, 3, 4, 5};
		final int[] expect = new int[]{1, 2, 3, 4, 5};
		final Turn execute  = new Turn();
		int[] res = execute.bubbleSort(arr);
		assertThat(res, is(expect));
	}
	/**
		* Test turnArray90Degrees method with 3-row square array.
	*/
	@Test
	public void whenSetThreeRowArrayThenReturnsCorrectResult() {
		final int[][] arr  = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		final int[][] expect = new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
		final Turn execute  = new Turn();
		int[][] res = execute.turnArray90Degrees(arr);
		assertThat(res, is(expect));
	}

	/**
		* Test turnArray90Degrees method with 4-row square array.
	*/
	@Test
	public void whenSetFourRowArrayThenReturnsCorrectResult() {
		final int[][] arr  = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
		final int[][] expect = new int[][]{{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}};
		final Turn execute  = new Turn();
		int[][] res = execute.turnArray90Degrees(arr);
		assertThat(res, is(expect));
	}

	/**
		* Test turnArray90Degrees method with 6-row square array.
	*/
	@Test
	public void whenSetSixRowArrayThenReturnsCorrectResult() {
		final int[][] arr  = new int[][]{{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 18}, {19, 20, 21, 22, 23, 24}, {25, 26, 27, 28, 29, 30}, {31, 32, 33, 34, 35, 36}};
		final int[][] expect = new int[][]{{31, 25, 19, 13, 7, 1}, {32, 26, 20, 14, 8, 2}, {33, 27, 21, 15, 9, 3}, {34, 28, 22, 16, 10, 4}, {35, 29, 23, 17, 11, 5}, {36, 30, 24, 18, 12, 6}};
		final Turn execute  = new Turn();
		int[][] res = execute.turnArray90Degrees(arr);
		assertThat(res, is(expect));
	}

	/**
		* Test of cleaning arrays from dublicates.
	*/
	@Test
	public void whenSetUniqueArrayThenClearsIt() {
		final String[] arr  = new String[]{"Привет", "Привет", "Мир", "Мир"};
		final String[] expect = new String[]{"Привет", "Мир"};
		final Turn execute  = new Turn();
		String[] res = execute.clearArrayFromCopies(arr);
		assertThat(res, is(expect));
	}
}