package ru.avelikorechin.chess;

import ru.avelikorechin.chess.exceptions.FigureNotFoundException;
import ru.avelikorechin.chess.exceptions.ImpossibleMoveException;
import ru.avelikorechin.chess.exceptions.OccupiedWayException;
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
    private int size;
    /**
     * Constructor to create default board.
     * @param size number of figures to keep
     */
    public Board(int size) {
        this.size = size;
        this.figures = new Figure[size][size];
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
    public boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException{
        boolean result = false;

        if (source.getCurrentFigure().equals(null)) {
            throw new FigureNotFoundException();
        }



//        Проверить что в заданной ячейки есть фигура. если нет. то выкинуть исключение
//        Если фигура есть. Проверить может ли она так двигаться. Если нет то упадет исключение
//        Проверить что полученный путь. не занят фигурами. Если занят выкинуть исключение
//        Если все отлично. Записать в ячейку новое новое положение Figure figure.clone(Cell dist)
        return result;
    }
}
