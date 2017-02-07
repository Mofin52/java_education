package ru.avelikorechin.professions;

/**
 * Project class.
 * @author Alexander Velikorechin
 * @since 06.02.2017
 */
public class Project {
    /**
     * stage of project.
     */
    private String stage;
    /**
     * cost of materials for project.
     */
    private int costOfMaterials;

    /**
     * Getter for project stage.
     * @return stage of project
     */
    public String getStage() {
        return this.stage;
    }

    /**
     * Setter for stage of project.
     * @param stage to set
     */
    public void setStage(String stage) {
        this.stage = stage;
    }

    /**
     * Getter for cost of materials.
     * @return cost of materials
     */
    public int getCostOfMaterials() {
        return this.costOfMaterials;
    }

    /**
     * Setter for costOfMaterials.
     * @param costOfMaterials to set
     */
    public void setCostOfMaterials(int costOfMaterials) {
        this.costOfMaterials = costOfMaterials;
    }
}
