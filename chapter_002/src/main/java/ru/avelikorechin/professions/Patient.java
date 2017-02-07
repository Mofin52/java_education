package ru.avelikorechin.professions;

/**
 * Patient class.
 * @author Alexander Velikorechin
 * @since 06.02.2017
 */

public class Patient {
    /**
     * Is patient watched.
     */
    private boolean isWatched;
    /**
     * Last made procedure.
     */
    private String lastProcedure;
    /**
     * Patient's diagnosis.
     */
    private String diagnosis;
    /**
     * Is given recipe.
     */
    private boolean hasRecipe;
    /**
     * Tests to pass.
     */
    private String testToPass;
    /**
     * Is patient visited at home.
     */
    private boolean isHomeVisited;

    /**
     * Is patient watched by a doctor.
     * @return is patient watched
     */
    public boolean isWatched() {
        return this.isWatched;
    }

    /**
     * Setter for isPatientWatched.
     * @param watched or not
     */
    public void setWatched(boolean watched) {
        this.isWatched = watched;
    }

    /**
     * Getter for patient's last procedure.
     * @return lastProcedure made
     */
    public String getLastProcedure() {
        return this.lastProcedure;
    }

    /**
     * Setter for lastProcedure.
     * @param lastProcedure made
     */
    public void setLastProcedure(String lastProcedure) {
        this.lastProcedure = lastProcedure;
    }

    /**
     * Getter for diagnosis.
     * @return set diagnosis
     */
    public String getDiagnosis() {
        return this.diagnosis;
    }

    /**
     * Setter for diagnosis.
     * @param diagnosis to set
     */
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    /**
     * Getter for recipe given.
     * @return is patient has recipe or not
     */
    public boolean isHasRecipe() {
        return this.hasRecipe;
    }

    /**
     * Setter for recipe.
     * @param hasRecipe given or not
     */
    public void setHasRecipe(boolean hasRecipe) {
        this.hasRecipe = hasRecipe;
    }

    /**
     * Getter for assigned tests.
     * @return assigned tests
     */
    public String getTestToPass() {
        return this.testToPass;
    }

    /**
     * Setter for assigned tests.
     * @param testToPass tests to set
     */
    public void setTestToPass(String testToPass) {
        this.testToPass = testToPass;
    }

    /**
     * Getter for is patient visited at home.
     * @return is Patient visited at home or not
     */
    public boolean isHomeVisited() {
        return this.isHomeVisited;
    }

    /**
     * Setter for home visited param.
     * @param homeVisited or not
     */
    public void setHomeVisited(boolean homeVisited) {
        isHomeVisited = homeVisited;
    }
}
