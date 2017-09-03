package ru.avelikorechin.departmentsSorter;

import org.junit.Test;
import ru.avelikorechin.departmentsSorter.comparators.CompareDepartmentsAscending;
import ru.avelikorechin.departmentsSorter.comparators.CompareDepartmentsDescending;

import java.util.Comparator;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class to test DepSorter.
 * @author Alexander Velikorechin
 * @since 03.09.2017
 */

public class DepSorterTest {
    /**
     * Test sort ascending.
     */
    @Test
    public void whenSortAscendingThenReturnsCorrectResult() {
        final String[] incomingDepartments = {"K1\\SK2", "K1\\SK1", "K1\\SK1\\SSK2", "K1\\SK1\\SSK1", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        final String[] expected = {"K1", "K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K1\\SK2", "K2", "K2\\SK1", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        final Comparator comparator = new CompareDepartmentsAscending();
        DepSorter depSorter = new DepSorter();
        assertThat(depSorter.sortDep(incomingDepartments, comparator), is(expected));
    }

    /**
     * Test sort descending.
     */
    @Test
    public void whenSortDescendingThenReturnsCorrectResult() {
        final String[] incomingDepartments = {"K1\\SK2", "K1\\SK1", "K1\\SK1\\SSK2", "K1\\SK1\\SSK1", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        final String[] expected = {"K2", "K2\\SK1", "K2\\SK1\\SSK2", "K2\\SK1\\SSK1", "K1", "K1\\SK2", "K1\\SK1", "K1\\SK1\\SSK2", "K1\\SK1\\SSK1"};
        final Comparator comparator = new CompareDepartmentsDescending();
        DepSorter depSorter = new DepSorter();
        assertThat(depSorter.sortDep(incomingDepartments, comparator), is(expected));
    }
}
