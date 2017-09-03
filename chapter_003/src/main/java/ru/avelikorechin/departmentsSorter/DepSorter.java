package ru.avelikorechin.departmentsSorter;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Sorter for departments.
 * @author Alexander Velikorechin
 * @since 26.07.2017
 */

public class DepSorter {
    /**
     * Sorts departments in ascending or descending order.
     * @param departments list of departments to sort
     * @param comparator type of comparing: ascending or descending
     * @return array of departments codes sorted in ascending order
     */
    public String[] sortDep(String[] departments, Comparator comparator) {
        Set<Department> deps = new TreeSet<>(comparator);
        for (String line : departments) {
            deps.add(new Department(line));
        }
        Set<Department> missing = findMissing(deps, comparator);
        deps.addAll(missing);
        String[] result = new String[deps.size()];
        int i = 0;
        for (Department dep : deps) {
            result[i++] = dep.getCode();
        }
        return result;
    }

    /**
     * Method to find department codes that are missing in the incoming set.
     * @param departmentSet incoming department set
     * @param comparator type of comparing: ascending or descending
     * @return set of departments without missing items
     */
    private Set<Department> findMissing(Set<Department> departmentSet, Comparator comparator) {
        Set<Department> missingDeps = new TreeSet<>(comparator);
        for (Department dep : departmentSet) {
            if (dep.getStructure().size() > 1) {
                String[] structure = dep.getCode().split("\\\\");
                int structureLength = structure.length;
                String newStructure = "";
                for (int i = 0; i < structureLength - 1; i++) {
                    newStructure += (structure[i]);
                    if (i < structureLength - 2) {
                        newStructure += "\\";
                    }
                }
                Department depToAdd  = new Department(newStructure);
                if (!missingDeps.contains(depToAdd) && !departmentSet.contains(depToAdd)) {
                    missingDeps.add(depToAdd);
                }
            }
        }
        return missingDeps;
    }



//    public static void main(String[] args) {
//        String[] departments = {"K1\\SK1", "K1\\SK2", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
//        DepSorter sorter = new DepSorter();
//        departments = sorter.sortDep(departments, new CompareDepartmentsAscending());
//        System.out.println("По убыванию: ");
//        for (String line : departments) {
//            System.out.println(line);
//        }
//    }
}