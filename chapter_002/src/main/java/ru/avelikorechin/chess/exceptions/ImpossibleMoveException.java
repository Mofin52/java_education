package ru.avelikorechin.chess.exceptions;

/**
 * Exception thrown when user tries to make an impossible move.
 * @author Alexander Velikorechin
 * @since 08.04.2017
 */
public class ImpossibleMoveException extends RuntimeException {
    public ImpossibleMoveException() {
        super("This figure can't move this way");
    }
}
