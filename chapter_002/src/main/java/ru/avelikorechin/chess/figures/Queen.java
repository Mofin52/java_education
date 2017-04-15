package ru.avelikorechin.chess.figures;

import ru.avelikorechin.chess.Board;
import ru.avelikorechin.chess.Cell;
import ru.avelikorechin.chess.exceptions.ImpossibleMoveException;

/**
 * Class describes Queen figure logic.
 * @author Alexander Velikorechin
 * @since 13.04.2017
 */
public class Queen extends Figure {
    /**
     * Constructor for Queen class.
     * @param position position of figure
     */
    public Queen(Cell position) {
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
        Cell[] result = new Cell[colChangeAbs];
        if (rowChangeAbs == colChangeAbs && dist.getColumn() < Board.SIZE && dist.getColumn() > 0 && dist.getRow() < Board.SIZE && dist.getRow() > 0) {
            for (int i = 0; i < rowChangeAbs; i++) {
                result[i] = new Cell((this.getPosition().getRow() + i + 1) * (rowChange / rowChangeAbs), (this.getPosition().getColumn() + i + 1) * (colChange / colChangeAbs));
            }
        } else {
            throw new ImpossibleMoveException();
        }
        return result;
    }

    /**
     * Writes figure to the new cell.
     * @param dist new cell
     * @return new Queen
     */
    @Override
    public Queen clone(Cell dist) {
        return new Queen(dist);
    }
}
