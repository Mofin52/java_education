package ru.avelikorechin.chess.figures;

import ru.avelikorechin.chess.Cell;
import ru.avelikorechin.chess.exceptions.ImpossibleMoveException;

/**
 * Abstract figure for chess game.
 * @author Alexander Velikorechin
 * @since 08.04.2017
 */
public abstract class Figure {
    /**
     * Initial position of figure.
     */
    private final Cell position;

    /**
     * Constructor for figure.
     * @param position initial position of figure.
     */
    public Figure(Cell position) {
        this.position = position;
    }

    /**
     * Method checks whether figure can move along the given path.
     * @param dist designated point
     * @return array of cells figure must pass to arrive the destination
     * @throws ImpossibleMoveException if figure cant' go along this way
     */
     public abstract Cell[] way(Cell dist) throws ImpossibleMoveException;

    /**
     * Writes figure to the new cell.
     * @param dist new cell
     * @return new figure on new cell
     */
     public abstract Figure clone(Cell dist);

    /**
     * Getter for position.
     * @return position
     */
    public Cell getPosition() {
        return this.position;
    }
}
