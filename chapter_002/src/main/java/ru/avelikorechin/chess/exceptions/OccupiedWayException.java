package ru.avelikorechin.chess.exceptions;

/**
 * Exception thrown when user tries to make an impossible move.
 * @author Alexander Velikorechin
 * @since 08.04.2017
 */
public class OccupiedWayException extends RuntimeException {
    /**
     * Constructor.
     */
    public OccupiedWayException() {
        System.out.println("There is another figure of the figure's way");
    }
}
