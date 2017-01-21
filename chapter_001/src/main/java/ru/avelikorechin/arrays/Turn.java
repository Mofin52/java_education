package ru.avelikorechin.arrays;

/**
	* Arrays turning methods.
	* @author Alexander Velikorechin
	* @since 21.01.2017
*/

public class Turn {
	/**
		* Method turns array backwards (1,2,3 -> 3,2,1).
		* @param arr — input array
		* @return Turned backwards array
	*/
	public int[] back(int[] arr) {
		for (int i = 0; i < (arr.length / 2); i++) {
				int excluded = arr[i];
				arr[i] = arr[arr.length - (i + 1)];
				arr[arr.length - (i + 1)] = excluded;
		}
		return arr;
	}
}