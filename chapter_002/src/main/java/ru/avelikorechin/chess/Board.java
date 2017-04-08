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
    private Figure[] figures;

    /**
     * Constructor to create board.
     * @param numOfFigures number of figures to keep
     */
    public Board(int numOfFigures) {
        this.figures = new Figure[numOfFigures];
    }

    public boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException{
        boolean result = false;
//        Проверить что в заданной ячейки есть фигура. если нет. то выкинуть исключение
//        Если фигура есть. Проверить может ли она так двигаться. Если нет то упадет исключение
//        Проверить что полученный путь. не занят фигурами. Если занят выкинуть исключение
//        Если все отлично. Записать в ячейку новое новое положение Figure figure.clone(Cell dist)
        return result;
    }
}
