package ru.avelikorechin.start;

/**
 * Exception for invalid menu option.
 * @author Alexander Velikorechin
 * @since 17.03.2017
 */
public class MenuOutException extends RuntimeException {
    /**
     * Constructor for exception.
     * @param msg message to show.
     */
    public MenuOutException(String msg) {
        super(msg);
    }
}
