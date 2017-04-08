package ru.avelikorechin.chess;

/**
 * Cell of chess board.
 * @author Alexander Velikorechin
 * @since 08.09.2017
 */
public class Cell {
    /**
     * Number of column where figure is placed.
     */
    private int column;
    /**
     * Number of row where figure is placed.
     */
    private int row;

    /**
     * Constructor of cell.
     * @param column to place figure
     * @param row to place figure
     */
    public Cell(int column, int row) {
        this.column = column;
        this.row = row;
    }
}
