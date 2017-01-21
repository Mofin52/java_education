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
	/**
		* Method sorts an array with bubble-sort algorithm.
		* @param arr - input array
		* @return Sorted array
	*/
	public int[] bubbleSort(int[] arr) {
		while (true) {
			int count = 0;
			for (int i = 0; i < (arr.length - 1); i++) {
				if (arr[i + 1] - arr[i] < 0) {
					int excluded = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = excluded;
					count++;
				} else {
					continue;
				}
			}
			if (count == 0) {
				return arr;
			} else {
				continue;
			}
		}
	}
}