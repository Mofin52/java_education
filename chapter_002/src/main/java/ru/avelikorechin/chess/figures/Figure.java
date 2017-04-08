package ru.avelikorechin.chess.figures;

import ru.avelikorechin.chess.Cell;
import ru.avelikorechin.chess.exceptions.ImpossibleMoveException;

/**
 * Abstract figure for chess game.
 * @author Alexander Velikorechin
 * @since 08.09.2017
 */
public abstract class Figure {
    /**
     * Initial position of figure.
     */
    final Cell position;

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
    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        Cell[] path = new Cell[0];
        return path;
    }

    public Figure clone(Cell dist) {
        Figure result = new Figure(dist);
        // записать ячейку в ячейку новое положение
        return result;
    }
}
