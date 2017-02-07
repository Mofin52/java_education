package ru.avelikorechin.professions;

/**
 * Doctor class.
 * @author Alexander Velikorechin
 * @since 06.02.2017
 */
public class Doctor extends Profession {
    /**
     * Scientific degree.
     */
    private String scientificDegree;
    /**
     * Number of hospital in which doctor works.
     */
    private int hospitalNumber;
    /**
     * Is a doctor a head of some department.
     */
    private boolean isHeadOfDepartment;
    /**
     * Level of qualification, doctor category.
     */
    private int qualification = 0;
    /**
     * Watch patient.
     * @param patient to watch
     */
    private void watchPatient(Patient patient) {
        patient.setWatched(true);
    }
    /**
     * Make procedures on Patient.
     * @param patient to make procedures on
     * @param proc - procedure to perform
     */
    private void makeProcedures(Patient patient, String proc) {
        patient.setLastProcedure(proc);
    }
    /**
     * Set diagnosis for patient.
     * @param patient to set diagnosis
     * @param diagnosis to set
     */
    private void makeDiagnosis(Patient patient, String diagnosis) {
        patient.setDiagnosis(diagnosis);
    }
    /**
     * Give patient a recipe.
     * @param patient to give recipe
     */
    private void giveRecipe(Patient patient) {
        patient.setHasRecipe(true);
    }
    /**
     * Send patient to make some health test.
     * @param patient to send to test
     * @param test to make
     */
    private void assignTests(Patient patient, String test) {
        patient.setTestToPass(test);
    }
    /**
     * Visit patient at its house.
     * @param patient to visit
     */
    private void visitPatientAtHome(Patient patient) {
        patient.setHomeVisited(true);
    }
    /**
     * Improve qualification.
     */
    private void improveQualification() {
        this.qualification++;
    }

    /**
     * Getter for scientificDegree.
     * @return doctor's scientific degree
     */
    public String getScientificDegree() {
        return this.scientificDegree;
    }
    /**
     * Setter for scientificDegree.
     * @param newScientificDegree - degree to set
     */
    public void setScientificDegree(String newScientificDegree) {
        this.scientificDegree = newScientificDegree;
    }
    /**
     * Getter for hospital number.
     * @return doctor's hospital
     */
    public int getHospitalNumber() {
        return this.hospitalNumber;
    }
    /**
     * Setter for hospital number.
     * @param newHospitalNumber - hospital number to set
     */
    public void setHospitalNumber(int newHospitalNumber) {
        this.hospitalNumber = newHospitalNumber;
    }
    /**
     * Getter for isHeadOfDepartment.
     * @return is doctor a head of department
     */
    public boolean getIsHeadOfDepartment() {
        return this.isHeadOfDepartment;
    }
    /**
     * Setter for isHeadOfDepartment.
     * @param newHeadOfDepartment - status to set
     */
    public void setHeadOfDepartment(boolean newHeadOfDepartment) {
        isHeadOfDepartment = newHeadOfDepartment;
    }
    /**
     * Getter for qualification.
     * @return doctor's qualification
     */
    public int getQualification() {
        return this.qualification;
    }
    /**
     * Setter for qualification.
     * @param newQualification - qualification to set
     */
    public void setQualification(int newQualification) {
        this.qualification = newQualification;
    }
}
