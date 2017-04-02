package ru.avelikorechin.bankStat.utils;

/**
 * Methods to sort and merge arrays.
 * @author Alexander Velikorechin
 * @since 02.04.2017
 */
public class ArrayUtils {
    /**
     * Method sorts an array with bubble-sort algorithm.
     * @param arr - input array
     * @return Sorted array
     */
    public static double[] bubbleSort(double[] arr) {
        while (true) {
            int count = 0;
            for (int i = 0; i < (arr.length - 1); i++) {
                if (arr[i + 1] - arr[i] < 0) {
                    double excluded = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = excluded;
                    count++;
                }
            }
            if (count == 0) {
                return arr;
            }
        }
    }
    /**
     * Method joins two sorted Arrays.
     * @param first — first Array
     * @param second — second Array
     * @return joined and still sorted array
     */
    public static double[] joinArrays(double[] first, double[] second) {
        double[] goalArray = new double[first.length + second.length];
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
