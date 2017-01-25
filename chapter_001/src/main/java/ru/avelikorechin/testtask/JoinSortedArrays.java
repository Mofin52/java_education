package ru.avelikorechin.testtask;

/**
	* Class joins two sorted Arrays.
	* @author Alexander Velikorechin
	* @since 25.01.2017
*/

public class JoinSortedArrays {
	/**
		* Method joins two sorted Arrays.
		* @param first — first Array
		* @param second — second Array
		* @return joined and still sorted array
	*/
	public int[] joinArrays(int[] first, int[] second) {
		int[] goalArray = new int[first.length + second.length];
		int minLength = first.length <= second.length ? first.length : second.length;
		int countFirst = 0;
		int countSecond = 0;
		// filling goalArray comparing elements of smaller array with the elements of the same index in bigger
		for (int i = 0; i < goalArray.length;) { // i increment should be in the inner loop
			for (int j = 0; j < goalArray.length; j++) {
				i++;
				// Adding values that was bigger that their pairs to the end of Array when made the main iteration
				if (countSecond == minLength || countFirst == minLength) {
					if (countFirst > countSecond) {
						for (int k = countSecond; k < second.length; k++) {
							goalArray[minLength + countSecond] = second[countSecond];
							countSecond++;
						}
					} else {
						for (int k = countFirst; k < first.length; k++) {
							goalArray[minLength + countFirst] = first[countFirst];
							countFirst++;
						}
					}
					break;
				}
				// Comparing two arrays and adding smaller values to the goalArray
				if (first[countFirst] < second[countSecond]) {
					goalArray[i - 1] = first[countFirst];
					countFirst++;
				} else {
					goalArray[i - 1] = second[countSecond];
					countSecond++;
				}
			}
		}
		return goalArray;
	}
}