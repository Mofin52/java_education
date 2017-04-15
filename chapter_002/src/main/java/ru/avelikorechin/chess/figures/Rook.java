package ru.avelikorechin.chess.figures;

import ru.avelikorechin.chess.Board;
import ru.avelikorechin.chess.Cell;
import ru.avelikorechin.chess.exceptions.ImpossibleMoveException;

/**
 * Class describes Rook figure logic.
 * @author Alexander Velikorechin
 * @since 14.04.2017
 */
public class Rook extends Figure {
    /**
     * Constructor for Rook class.
     * @param position position of figure
     */
    public Rook(Cell position) {
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
        Cell[] result = new Cell[rowChangeAbs > colChangeAbs ? rowChangeAbs : colChangeAbs];
        if (rowChangeAbs * colChangeAbs == 0 && dist.getColumn() >= 0 && dist.getRow() >= 0 && dist.getColumn() < Board.SIZE && dist.getRow() < Board.SIZE && rowChangeAbs != colChangeAbs) {
            if (rowChangeAbs == 0) {
                for (int i = 0; i < colChangeAbs; i++) {
                    result[i] = new Cell(this.getPosition().getRow(), (this.getPosition().getColumn() + i + 1) * (colChange / colChangeAbs));
                }
            } else {
                for (int i = 0; i < rowChangeAbs; i++) {
                    result[i] = new Cell((this.getPosition().getRow() + i + 1) * (rowChange / rowChangeAbs), this.getPosition().getColumn());
                }
            }
        } else {
            throw new ImpossibleMoveException();
        }
        return result;
    }

    /**
     * Writes figure to the new cell.
     * @param dist new cell
     * @return new Bishop
     */
    @Override
    public Rook clone(Cell dist) {
        return new Rook(dist);
    }
}
