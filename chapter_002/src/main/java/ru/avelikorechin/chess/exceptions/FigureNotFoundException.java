package ru.avelikorechin.chess.exceptions;

/**
 * Exception thrown when game can't find figure.
 * @author Alexander Velikorechin
 * @since 08.04.2017
 */
public class FigureNotFoundException extends RuntimeException {
    /**
     * Constructor.
     */
    public FigureNotFoundException() {
        System.out.println("Figure not found. Try again");
    }
}
