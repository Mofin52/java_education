package ru.avelikorechin.collectionsFramework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Class to convert list to array and array to list.
 * @author Alexander Velikorechin
 * @since 20.05.2017
 */
public class ConvertList {
    /**
     * Converts array to List<Integer>.
     * @param array array to convert
     * @return collection made of array
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                result.add(array[i][j]);
            }
        }
        return result;
    }

    /**
     * Converts array to int[][].
     * @param list list to convert
     * @param rows rows needed in result array
     * @return array made of collection
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int lines = list.size() / rows;
        if (list.size() % rows > 0) {
            lines++;
        }
        int[][] result = new int[rows][lines];
        Iterator<Integer> iter = list.iterator();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < lines; j++) {
                result[i][j] = iter.hasNext() ? iter.next() : 0;
            }
        }
        return result;
    }

    /**
     * Converts list of int arrays to one list.
     * @param list list of int arrays
     * @return linked list of numbers
     */
    public List<Integer> convert(List<int[]> list) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        list.forEach((arr) -> {
            for (int num : arr) {
                result.add(num);
            }
        });
        return result;
    }
}