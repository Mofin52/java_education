package ru.avelikorechin.professions;

/**
 * Engineer class.
 * @author Alexander Velikorechin
 * @since 06.02.2017
 */
public class Engineer {
    /**
     * Engineer's qualification.
     */
    private int qualification;
    /**
     * Engineer's project.
     */
    private Project currentProject = new Project();
    /**
     * Start a project.
     */
    private void createProject() {
        currentProject.setStage("Just Created");
    }
    /**
     * Analyze project.
     */
    private void makeAnalisis() {
        currentProject.setStage("Analisis Competed");
    }
    /**
     * Calculate cost of project.
     */
    private void calculateCostOfMaterials() {
        currentProject.setStage("Material Cost Is Calculated");
        final int cost = 150;
        currentProject.setCostOfMaterials(cost);
    }
    /**
     * Send project to production.
     */
    private void sendToProduction() {
        currentProject.setStage("In Production");
    }
    /**
     * Check project.
     */
    private void checkResult() {
        currentProject.setStage("Result Approved");
    }
    /**
     * Getter for qualification.
     * @return qualification of engineer
     */
    public int getQualification() {
        return this.qualification;
    }
    /**
     * Setter for qualification.
     * @param qualification to set.
     */
    public void setQualification(int qualification) {
        this.qualification = qualification;
    }
    /**
     * Getter for project.
     * @return current project
     */
    public Project getCurrentProject() {
        return this.currentProject;
    }
    /**
     * Setter for qualification.
     * @param currentProject - project to work on
     */
    public void setCurrentProject(Project currentProject) {
        this.currentProject = currentProject;
    }
}
