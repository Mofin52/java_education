package ru.avelikorechin.chess;

import ru.avelikorechin.chess.figures.Figure;

/**
 * Cell of chess board.
 * @author Alexander Velikorechin
 * @since 08.09.2017
 */
public class Cell {
    private int column;
    private int row;

    /**
     * Constructor of cell.
     * @param column to place figure
     * @param row to place figure
     */
    public Cell(int column, int row) {
        this.setColumn(column);
        this.setRow(row);
    }

    /**
     * Returns number of column where figure is placed.
     */
    public int getColumn() {
        return this.column;
    }

    /**
     * Sets number of column for figure.
     * @param column column
     */
    public void setColumn(int column) {
        this.column = column;
    }

    /**
     * Returns number of row where figure is placed.
     */
    public int getRow() {
        return this.row;
    }

    /**
     * Sets number of row for figure.
     * @param row row
     */
    public void setRow(int row) {
        this.row = row;
    }
}
