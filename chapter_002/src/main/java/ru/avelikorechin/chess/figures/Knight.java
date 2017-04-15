package ru.avelikorechin.chess.figures;

import ru.avelikorechin.chess.Board;
import ru.avelikorechin.chess.Cell;
import ru.avelikorechin.chess.exceptions.ImpossibleMoveException;

/**
 * Class describes Knight figure logic.
 * @author Alexander Velikorechin
 * @since 14.04.2017
 */
public class Knight extends Figure {
    /**
     * Constructor for Knight class.
     * @param position position of figure
     */
    public Knight(Cell position) {
        super(position);
    }
    /**
     * Method checks whether figure can move along the given path.
     * @param dist designated point
     * @return array of cells figure must pass to arrive the destination
     * @throws ImpossibleMoveException if figure cant' go along this way
     */
    @Override
    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        int rowChange = dist.getRow() - this.getPosition().getRow();
        int colChange = dist.getColumn() - this.getPosition().getColumn();
        int rowChangeAbs = Math.abs(rowChange);
        int colChangeAbs = Math.abs(colChange);
        Cell[] result = new Cell[1];
        if (rowChangeAbs + colChangeAbs == 3 && dist.getColumn() >= 0 && dist.getRow() >= 0 && dist.getColumn() < Board.SIZE && dist.getColumn() < Board.SIZE && rowChangeAbs > 0 && colChangeAbs > 0) {
            result[0] = new Cell(dist.getRow(), dist.getColumn());
        } else {
            throw new ImpossibleMoveException();
        }
        return result;
    }

    /**
     * Writes figure to the new cell.
     * @param dist new cell
     * @return new Knight
     */
    @Override
    public Knight clone(Cell dist) {
        return new Knight(dist);
    }
}
