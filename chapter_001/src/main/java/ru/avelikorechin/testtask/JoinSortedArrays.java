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
		// filling goalArray comparing elements of smaller array with the elements of the same index in bigger
		for (int i = 0; i < minLength - 1;) { // i increment should be in the inner loop
			for (int j = 0; j < minLength; j++) {
				if (first[j] > second[j]) {
					goalArray[i] = second[j];
					goalArray[i + 1] = first[j];
				} else {
					goalArray[i] = first[j];
					goalArray[i + 1] = second[j];
				}
				i += 2;
			}
		}
		// if one array is bigger than other, filling the rest of goalArray with end elements of bigger one
		if (first.length != second.length) {
			int[] biggerArray = first.length > second.length ? first : second;
			int lengthDifference = Math.abs(first.length - second.length);
			for (int i = goalArray.length - lengthDifference; i < goalArray.length;) { // i increment should be in the inner loop
				for (int j = biggerArray.length - lengthDifference; j < biggerArray.length; j++) {
					goalArray[i] = biggerArray[j];
					i++;
				}
			}
		}

		return goalArray;
	}
}