package ru.avelikorechin.chess.figures;

import ru.avelikorechin.chess.Cell;
import ru.avelikorechin.chess.exceptions.ImpossibleMoveException;

/**
 * Class describes Bishop figure logic.
 * @author Alexander Velikorechin
 * @since 13.04.2017
 */
public class Bishop extends Figure {
    /**
     * Constructor for Bishop class.
     * @param position position of figure
     */
    public Bishop (Cell position) {
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
        if (rowChangeAbs == colChangeAbs && dist.getColumn() <= 7 && dist.getColumn() > 0 && dist.getRow() <= 7 && dist.getRow() > 0) {
            for (int i = 1; i < rowChangeAbs; i++) {
                result[i-1] = new Cell((this.getPosition().getColumn() + i) * (colChange / colChangeAbs),(this.getPosition().getRow() + i) * (rowChange / rowChangeAbs));
            }
        } else {
            throw new ImpossibleMoveException();
        }
        return result;
    }

    /**
     * Writes figure to the new cell.
     * @param dist new cell
     */
    @Override
    public void clone(Cell dist) {

    }
}
