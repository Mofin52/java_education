package ru.avelikorechin.professions;

/**
 * Profession class.
 * @author Alexander Velikorechin
 * @since 06.02.2017
 */
public class Profession {
    /**
     * Name of spec.
     */
    private String name;
    /**
     * Years of practice.
     */
    private int yearsOfPractice;
    /**
     * Education of spec.
     */
    private String education;
    /**
     * Specialization of spec.
     */
    private String specialization;
    /**
     * Salary of spec.
     */
    private int salary;

    /**
     * Default constructor for profession class.
     */
    public Profession() {

    }

    /**
     * Custom constructor for Profession class.
     * @param name - spec name
     * @param specialization - spec specialization
     */
    public Profession(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    /**
     * Getter for name.
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for years of practice.
     * @return years of practice
     */
    public int getYearsOfPractice() {
        return this.yearsOfPractice;
    }

    /**
     * Getter for education.
     * @return education
     */
    public String getEducation() {
        return this.education;
    }

    /**
     * Getter for specialization.
     * @return specialization
     */
    public String getSpecialization() {
        return this.specialization;
    }

    /** Getter for salary.
     * @return salary
     */
    public int getSalary() {
        return this.salary;
    }

    /**
     * Setter for name.
     * @param newname to set
     */
    public void setName(String newname) {
        this.name = newname;
    }

    /**
     * Setter for yearsOfPractice.
     * @param newYears to set
     */
    public void setYearsOfPractice(int newYears) {
        this.yearsOfPractice = newYears;
    }

    /**
     * Setter for education.
     * @param newEducation to set
     */
    public void setEducation(String newEducation) {
        this.education = newEducation;
    }

    /**
     * Setter for specialization.
     * @param newSpec to set
     */
    public void setSpecialization(String newSpec) {
        this.specialization = newSpec;
    }

    /**
     * Setter for salary.
     * @param newSalary to set
     */
    public void setSalary(int newSalary) {
        this.salary = newSalary;
    }
}