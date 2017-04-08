package ru.avelikorechin.chess.exceptions;

/**
 * Created by Александр on 08.04.2017.
 */
public class OccupiedWayException extends RuntimeException{
    public OccupiedWayException() {
        super("There is another figure of the figure's way");
    }
}
