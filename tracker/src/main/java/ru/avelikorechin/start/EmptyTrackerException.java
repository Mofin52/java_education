package ru.avelikorechin.start;

/**
 * Class for user interface.
 * @author Alexander Velikorechin
 * @since 17.03.2017
 */
public class EmptyTrackerException extends RuntimeException {
    /**
     * Constructor.
     * @param msg message to show
     */
    public EmptyTrackerException(String msg) {
        super(msg);
    }
}
