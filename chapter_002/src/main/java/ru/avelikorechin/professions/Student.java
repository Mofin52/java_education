package ru.avelikorechin.professions;

/**
 * Student class.
 * @author Alexander Velikorechin
 * @since 06.02.2017
 */
public class Student {
    /**
     * Are parents called.
     */
    private boolean areParentsCalled;
    /**
     * Last mark acquired.
     */
    private int lastMark;

    /**
     * Getter for are parents called.
     * @return are parents called
     */
    public boolean getAreParentsCalled() {
        return this.areParentsCalled;
    }

    /**
     * Setter for are parents called.
     * @param newAreParentsCalled to set
     */
    public void setAreParentsCalled(boolean newAreParentsCalled) {
        this.areParentsCalled = newAreParentsCalled;
    }

    /**
     * Getter for last mark.
     * @return last mark
     */
    public int getLastMark() {
        return this.lastMark;
    }

    /**
     * Setter for last mark.
     * @param newLastMark to set
     */
    public void setLastMark(int newLastMark) {
        this.lastMark = newLastMark;
    }
}
