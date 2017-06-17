package ru.avelikorechin.collectionsFramework;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Tests for convert list class.
 * @author Alexander Velikorechin
 * @since 20.05.2017
 */
public class ConvertListTest {
    /**
     * Initial array for convertation.
     */
    private final int[][] initialArray = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
    /**
     * Goal array for case without zeros.
     */
    private final int[][] goalArrayWithoutZeros = {{1, 1}, {1, 1}, {1, 1}};
    /**
     * Goal array for case with zeros.
     */
    private final int[][] goalArrayWithZeros = {{1, 1, 1}, {1, 1, 1}, {1, 0, 0}};
    /**
     * Rows needed in goal array.
     */
    private final int rowsInGoalArray = 3;

    /**
     * Test convert array to list.
     */
    @Test
    public void whenConvertArrayToListThenReturnsCorrectList() {
        ConvertList converter = new ConvertList();
        final int size = 9;
        assertThat(converter.toList(initialArray), is(prepareList(size)));
    }

    /**
     * Test convert list to array with no zeros expected.
     */
    @Test
    public void whenConvertListToArrayThenReturnsCorrectListCaseWithoutZeros() {
        ConvertList converter = new ConvertList();
        final int size = 6;
        assertThat(converter.toArray(prepareList(size), rowsInGoalArray), is(goalArrayWithoutZeros));
    }

    /**
     * Test convert list to array with zeros expected.
     */
    @Test
    public void whenConvertListToArrayThenReturnsCorrectListCaseWithZeros() {
        ConvertList converter = new ConvertList();
        final int size = 7;
        assertThat(converter.toArray(prepareList(size), rowsInGoalArray), is(goalArrayWithZeros));
    }

    /**
     * Test convert list of many arrays to single row list.
     */
    @Test
    public void whenConvertListOfThreeDifferentSizesArraysThenReturnsCorrectList() {
        ConvertList converter = new ConvertList();
        final int[] firstMember = {1, 2, 3};
        final int[] secondMember = {4, 5};
        final int[] thirdMember = {6};
        final Integer[] goalArray = {1, 2, 3, 4, 5, 6};
        LinkedList<int[]> basic = new LinkedList<>();
        final LinkedList<Integer> result = new LinkedList<Integer>();
        result.addAll(Arrays.asList(goalArray));

        basic.add(firstMember);
        basic.add(secondMember);
        basic.add(thirdMember);

        assertThat(converter.convert(basic), is(result));

    }

    /**
     * Method to prepare lists of 1's for tests.
     * @param iterations number of 1's needed in collection
     * @return list of size iterations
     */
    public List<Integer> prepareList(int iterations) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < iterations; i++) {
            result.add(1);
        }
        return result;
    }

}
