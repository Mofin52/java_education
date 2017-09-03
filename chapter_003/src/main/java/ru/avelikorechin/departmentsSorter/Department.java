package ru.avelikorechin.departmentsSorter;

import java.util.Set;
import java.util.TreeSet;

/**
 * Model describing department.
 * @author Alexander Velikorechin
 * @since 26.08.2017
 */

public class Department {
    /**
     * List representation of departments structure.
     */
    private Set<String> structure = new TreeSet<>();
    /**
     * String code of department.
     */
    private String code;

    /**
     * Constructor for department.
     * @param code string code of department
     */
    public Department(String code) {
        this.code = code;
        String[] depCodes = code.split("\\\\");
        for (String line : depCodes) {
            structure.add(line);
        }
    }

    /**
     * Getter for structure.
     * @return list representation of structure
     */
    public Set<String> getStructure() {
        return this.structure;
    }

    /**
     * Getter for code.
     * @return string code of department
     */
    public String getCode() {
        return this.code;
    }
}
