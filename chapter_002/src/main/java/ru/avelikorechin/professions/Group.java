package ru.avelikorechin.professions;

/**
 * Group class.
 * @author Alexander Velikorechin
 * @since 06.02.2017
 */
public class Group {
    /**
     * Number of group.
     */
    private int number;
    /**
     * Is parental meeting held.
     */
    private boolean isParentalMeetingHeld;
    /**
     * Last lesson theme.
     */
    private String lastLessonTheme;
    /**
     * Assigned task.
     */
    private String assignedTask;

    /**
     * Constructor for Group class.
     * @param number of group
     */
    public Group(int number) {
        this.number = number;
    }

    /**
     * Getter for number of group.
     * @return number of group
     */
    public int getNumber() {
        return this.number;
    }

    /**
     * Setter for number of group.
     * @param newNumber to set
     */
    public void setNumber(int newNumber) {
        this.number = newNumber;
    }

    /**
     * Getter for parental meeting field.
     * @return true or false
     */
    public boolean isParentalMeetingHeld() {
        return this.isParentalMeetingHeld;
    }

    /**
     * Update status of parental meeting.
     * @param newParentalMeetingHeld to set
     */
    public void setParentalMeetingHeld(boolean newParentalMeetingHeld) {
        isParentalMeetingHeld = newParentalMeetingHeld;
    }

    /**
     * Getter for last lesson theme.
     * @return last lesson theme
     */
    public String getLastLessonTheme() {
        return this.lastLessonTheme;
    }

    /**
     * Setter for lastlessontheme.
     * @param newLastLessonTheme to set
     */
    public void setLastLessonTheme(String newLastLessonTheme) {
        this.lastLessonTheme = newLastLessonTheme;
    }

    /**
     * Getter for assignedTask.
     * @return assigned task
     */
    public String getAssignedTask() {
        return this.assignedTask;
    }

    /**
     * Setter for assigned task.
     * @param newAssignedTask to set
     */
    public void setAssignedTask(String newAssignedTask) {
        this.assignedTask = newAssignedTask;
    }
}
