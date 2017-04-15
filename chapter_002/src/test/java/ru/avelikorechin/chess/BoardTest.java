package ru.avelikorechin.chess;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;

import ru.avelikorechin.chess.exceptions.FigureNotFoundException;
import ru.avelikorechin.chess.exceptions.ImpossibleMoveException;
import ru.avelikorechin.chess.exceptions.OccupiedWayException;
import ru.avelikorechin.chess.figures.Bishop;
import ru.avelikorechin.chess.figures.Knight;
import ru.avelikorechin.chess.figures.Rook;
import ru.avelikorechin.chess.figures.Queen;
import ru.avelikorechin.chess.figures.King;
import ru.avelikorechin.chess.figures.Pawn;
import ru.avelikorechin.chess.figures.Figure;

/**
 * Class to test chess game.
 * @author Alexander Velikorechin
 * @since 15.04.2017
 */
public class BoardTest {
    /**
     * Var for rook.
     */
    private final int rook1 = 0;
    /**
     * Var for knight.
     */
    private final int knight1 = 1;
    /**
     * Var for bishop.
     */
    private final int bishop1 = 2;
    /**
     * Var for queen.
     */
    private final int queen = 3;
    /**
     * Var for king.
     */
    private final int king = 4;
    /**
     * Var for bishop.
     */
    private final int bishop2 = 5;
    /**
     * Var for knight.
     */
    private final int knight2 = 6;
    /**
     * Var for rook.
     */
    private final int rook2 = 7;
    /**
     * Var for pawn.
     */
    private final int pawn = 8;
    /**
     * Array of figures initial positions.
     */
    private final Cell[] positions = {
            new Cell(0, 0),  //0. Rook
            new Cell(0, 1),  //1. Knight
            new Cell(0, 2),  //2. Bishop
            new Cell(0, 3),  //3. Queen
            new Cell(0, 4),  //4. King
            new Cell(0, 5),  //5. Bishop
            new Cell(0, 6),  //6. Knight
            new Cell(0, 7),  //7. Rook
            new Cell(1, 6)   //8. Pawn
    };
    /**
     * Bishop tests.
     */
    @Test
    public void whenMoveBishopThenShouldMoveCorrectly() {
        Board board = prepareBoard();
        final Cell moveCell = new Cell(2, 0);
        board.move(positions[bishop1], moveCell);
        assertNotNull(board.getFigures()[moveCell.getRow()][moveCell.getColumn()]);
    }
    /**
     * Bishop tests.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenMoveBishopIncorrectlyThenShouldThrowException() {
        Board board = prepareBoard();
        final Cell incorrectMove = new Cell(1, 0);
        board.move(positions[bishop1], incorrectMove);
    }

    /**
     * King tests.
     */
    @Test
    public void whenMoveKingThenShouldMoveCorrectly() {
        Board board = prepareBoard();
        final Cell moveCell1 = new Cell(1, 4);
        final Cell moveCell2 = new Cell(2, 3);
        final Cell moveCell3 = new Cell(2, 2);
        board.move(positions[king], moveCell1);
        assertNotNull(board.getFigures()[moveCell1.getRow()][moveCell1.getColumn()]);
        board.move(moveCell1, moveCell2);
        assertNotNull(board.getFigures()[moveCell2.getRow()][moveCell2.getColumn()]);
        board.move(moveCell2, moveCell3);
        assertNotNull(board.getFigures()[moveCell3.getRow()][moveCell3.getColumn()]);
    }
    /**
     * King tests.
     */
    @Test (expected = ImpossibleMoveException.class)
    public void whenMoveKingIncorrectlyThenShouldThrowException() {
        Board board = prepareBoard();
        final Cell incorrectMove = new Cell(7, 7);
        board.move(positions[king], incorrectMove);
    }
    /**
     * King tests.
     */
    @Test (expected = ImpossibleMoveException.class)
    public void whenMoveKingForwardTwoCellsThenShouldThrowException() {
        Board board = prepareBoard();
        final Cell incorrectMove = new Cell(2, 4);
        board.move(positions[king], incorrectMove);
    }
    /**
     * Knight tests.
     */
    @Test
    public void whenMoveKnightThenShouldMoveCorrectly() {
        Board board = prepareBoard();
        final Cell moveCell = new Cell(2, 2);
        board.move(positions[knight1], moveCell);
        assertNotNull(board.getFigures()[moveCell.getRow()][moveCell.getColumn()]);
    }
    /**
     * Knight tests.
     */
    @Test (expected = ImpossibleMoveException.class)
    public void whenMoveKnightIncorrectlyThenShouldThrowException() {
        Board board = prepareBoard();
        final Cell incorrectMove = new Cell(7, 7);
        board.move(positions[knight1], incorrectMove);
    }
    /**
     * Knight tests.
     */
    @Test (expected = ImpossibleMoveException.class)
    public void whenMoveKnightOffBoardThenShouldThrowException() {
        Board board = prepareBoard();
        final Cell incorrectMove = new Cell(-1, -1);
        board.move(positions[knight1], incorrectMove);
    }
    /**
     * Knight tests.
     */
    @Test
    public void whenMoveKnightOverAnotherFigureThenShouldMoveCorrectly() {
        Board board = prepareBoard();
        final Cell moveCell = new Cell(2, 7);
        board.move(positions[knight2], moveCell);
        assertNotNull(board.getFigures()[moveCell.getRow()][moveCell.getColumn()]);
    }

    /**
     * Pawn tests.
     */
    @Test
    public void whenMovePawnFirstAndSecondTimeThenShouldMoveCorrectly() {
        Board board = prepareBoard();
        final Cell moveCell1 = new Cell(2, 6);
        final Cell moveCell2 = new Cell(3, 6);
        board.move(positions[pawn], moveCell1);
        assertNotNull(board.getFigures()[moveCell1.getRow()][moveCell1.getColumn()]);
        board.move(moveCell1, moveCell2);
        assertNotNull(board.getFigures()[moveCell2.getRow()][moveCell2.getColumn()]);
    }
    /**
     * Pawn tests.
     */
    @Test (expected = ImpossibleMoveException.class)
    public void whenMovePawnIncorrectlyThenShouldThrowException() {
        Board board = prepareBoard();
        final Cell incorrectMove = new Cell(7, 7);
        board.move(positions[pawn], incorrectMove);
    }

    /**
     * Queen tests.
     */
    @Test
    public void whenMoveQueenThenShouldMoveCorrectly() {
        Board board = prepareBoard();
        final Cell moveCell1 = new Cell(3, 0);
        final Cell moveCell2 = new Cell(7, 0);
        final Cell moveCell3 = new Cell(7, 7);
        board.move(positions[queen], moveCell1);
        assertNotNull(board.getFigures()[moveCell1.getRow()][moveCell1.getColumn()]);
        board.move(moveCell1, moveCell2);
        assertNotNull(board.getFigures()[moveCell2.getRow()][moveCell2.getColumn()]);
        board.move(moveCell2, moveCell3);
        assertNotNull(board.getFigures()[moveCell3.getRow()][moveCell3.getColumn()]);
    }
    /**
     * Queen tests.
     */
    @Test (expected = ImpossibleMoveException.class)
    public void whenMoveQueenIncorrectlyThenShouldThrowException() {
        Board board = prepareBoard();
        final Cell incorrectMove = new Cell(7, 7);
        board.move(positions[bishop1], incorrectMove);
    }

    /**
     * Rook tests.
     */
    @Test
    public void whenMoveRookThenShouldMoveCorrectly() {
        Board board = prepareBoard();
        final Cell moveCell1 = new Cell(7, 0);
        final Cell moveCell2 = new Cell(7, 7);
        board.move(positions[rook1], moveCell1);
        assertNotNull(board.getFigures()[moveCell1.getRow()][moveCell1.getColumn()]);
        board.move(moveCell1, moveCell2);
        assertNotNull(board.getFigures()[moveCell2.getRow()][moveCell2.getColumn()]);
    }
    /**
     * Rook tests.
     */
    @Test (expected = ImpossibleMoveException.class)
    public void whenMoveRookIncorrectlyThenShouldThrowException() {
        Board board = prepareBoard();
        final Cell incorrectMove = new Cell(7, 7);
        board.move(positions[rook1], incorrectMove);
    }
    /**
     * Occupied way test.
     */
    @Test (expected = OccupiedWayException.class)
    public void whenFiguresWayBlockedThrowsOccupiedWayException() {
        Board board = prepareBoard();
        final Cell kingMove = new Cell(1, 4);
        final Cell occupiedWayMove = new Cell(2, 3);
        board.move(positions[king], kingMove);
        board.move(positions[bishop2], occupiedWayMove);
    }

    /**
     * Figure not found way test.
     */
    @Test (expected = FigureNotFoundException.class)
    public void whenTryMoveEmptyFieldThrowsFigureNotFoundException() {
        Board board = prepareBoard();
        final Cell noFigure = new Cell(5, 5);
        final Cell fooMove = new Cell(6, 6);
        board.move(noFigure, fooMove);
    }

    /**
     * Utility method to prepare board for tests.
     * @return ready to test board.
     */
    public Board prepareBoard() {
        Board board = new Board();
        int i = 0;
        Figure[] figures = {
                new Rook(positions[i++]),
                new Knight(positions[i++]),
                new Bishop(positions[i++]),
                new Queen(positions[i++]),
                new King(positions[i++]),
                new Bishop(positions[i++]),
                new Knight(positions[i++]),
                new Rook(positions[i++]),
                new Pawn(positions[i++])
        };
        for (Figure fig : figures) {
            board.addFigure(fig);
        }
        return board;
    }
}
