package ru.avelikorechin.chess.figures;

import ru.avelikorechin.chess.Board;
import ru.avelikorechin.chess.Cell;
import ru.avelikorechin.chess.exceptions.ImpossibleMoveException;

/**
 * Class describes Bishop figure logic.
 * @author Alexander Velikorechin
 * @since 13.04.2017
 */
public class Pawn extends Figure {
    /**
     * Does pawn makes move first time.
     */
    private boolean firstMove;
    /**
     * Constructor for Pawn class.
     * @param position position of figure
     */
    public Pawn(Cell position) {
        super(position);
        this.firstMove = true;
    }
    /**
     * Constructor for Pawn made first move.
     * @param position position of figure
     * @param firstMove is pawn made first move or not
     */
    public Pawn(Cell position, boolean firstMove) {
        super(position);
        this.firstMove = firstMove;
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
        Cell[] result = new Cell[rowChange];
        if (firstMove) {
            if(rowChange < 3 && rowChange > 0 && dist.getRow() > 0 && dist.getRow() < Board.SIZE && colChange == 0) {
                for (int i = 0; i < rowChange; i++) {
                    result[i] = new Cell((this.getPosition().getRow() + i + 1) * (rowChange / rowChange), (this.getPosition().getColumn()));
                }
                this.firstMove = false;
            } else {
                throw new ImpossibleMoveException();
            }
        } else {
            if(rowChange == 1 && dist.getRow() > 0 && dist.getRow() < Board.SIZE && colChange == 0) {
                result[0] = new Cell(dist.getRow(), this.getPosition().getColumn());
            } else {
                throw new ImpossibleMoveException();
            }
        }
        return result;
    }

    /**
     * Writes figure to the new cell.
     * @param dist new cell
     * @return new Pawn
     */
    @Override
    public Pawn clone(Cell dist) {
        return new Pawn(dist, false);
    }
}
