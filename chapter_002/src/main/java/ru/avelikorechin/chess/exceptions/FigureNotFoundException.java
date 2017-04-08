package ru.avelikorechin.chess.exceptions;

/**
 * Created by Александр on 08.04.2017.
 */
public class FigureNotFoundException extends RuntimeException {
    public FigureNotFoundException() {
        super("Figure not found. Try again");
    }
}
