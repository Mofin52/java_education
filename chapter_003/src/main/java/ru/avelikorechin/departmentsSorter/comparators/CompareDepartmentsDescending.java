package ru.avelikorechin.departmentsSorter.comparators;

import ru.avelikorechin.departmentsSorter.Department;
import java.util.Comparator;
import java.util.Set;

/**
 * Comparator to sort departments in descending order.
 * @author Alexander Velikorechin
 * @since 26.08.2017
 */

public class CompareDepartmentsDescending implements Comparator<Department> {
    /**
     * Overriding compare method.
     * If first item contains all that is kept in the second one or vice versa, we compare their size: the shorter goes upper.
     * If not we compare their codes by default String method.
     * @param department first comparing item
     * @param t1 second comparing item
     * @return 0 if equals, >0 if first is bigger, <0 if first is smaller
     */
    @Override
    public int compare(Department department, Department t1) {
        Set<String> depOneStr = department.getStructure();
        Set<String> depTwoStr = t1.getStructure();
        return depOneStr.containsAll(depTwoStr) || depTwoStr.containsAll(depOneStr) ? depOneStr.size() - depTwoStr.size() : t1.getCode().compareTo(department.getCode());
    }
}
