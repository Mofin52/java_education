package ru.avelikorechin.chess;

import ru.avelikorechin.chess.exceptions.FigureNotFoundException;
import ru.avelikorechin.chess.exceptions.ImpossibleMoveException;
import ru.avelikorechin.chess.exceptions.OccupiedWayException;
import ru.avelikorechin.chess.figures.Bishop;
import ru.avelikorechin.chess.figures.Figure;

/**
 * Chess board.
 * @author Alexander Velikorechin
 * @since 08.09.2017
 */
public class Board {
    /**
     * Array to keep all the figures.
     */
    private Figure[][] figures;
    /**
     * Size of board.
     */
    public static final int SIZE = 8;
    /**
     * Constructor to create default board.
     */
    public Board() {
        this.figures = new Figure[SIZE][SIZE];
    }

    /**
     * Checks whether figure can move from one cell to another and if yes, does it.
     * @param source cell to move from
     * @param dist cell to move to
     * @return true - move completed, false - move incompleted
     * @throws ImpossibleMoveException if figure can'f move this way
     * @throws OccupiedWayException if there is another figure of the figure's way
     * @throws FigureNotFoundException if there is no figure in 'source' cell
     */
    public boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
        Figure fig;

        if (this.figures[source.getRow()][source.getColumn()] == null) {
            throw new FigureNotFoundException();
        } else {
            fig = this.figures[source.getRow()][source.getColumn()];
        }

        Cell[] way = fig.way(dist);

        for (Cell cell : way) {
            if (this.figures[cell.getRow()][cell.getColumn()] != null) {
                throw new OccupiedWayException();
            }
        }

        Figure newFig = fig.clone(dist);
        this.figures[source.getRow()][source.getColumn()] = null;
        this.figures[dist.getRow()][dist.getColumn()] = newFig;
        System.out.println("Передвинули");
        return true;
    }

    private void addFigure(Figure fig) {
        this.figures[fig.getPosition().getRow()][fig.getPosition().getColumn()] = fig;
    }

    public static void main(String[] args) {
        Board board = new Board();
        board.addFigure(new Bishop(new Cell(0,0)));
        board.move(new Cell(0,0), new Cell(1,1));
        board.move(new Cell(1,1), new Cell(3,4));
    }
}
