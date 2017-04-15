package ru.avelikorechin.chess;

import org.junit.Test;
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
     * Array of figures initial positions.
     */
    public final Cell[] positions = {
            new Cell(0,0), //0. Rook
            new Cell(0,1), //1. Knight
            new Cell(0,2), //2. Bishop
            new Cell(0,3), //3. Queen
            new Cell(0,4), //4. King
            new Cell(0,5), //5. Bishop
            new Cell(0,6), //6. Knight
            new Cell(0,7), //7. Rook
            new Cell(1,5)  //8. Pawn
    };
    /**
     * Bishop tests.
     */
    @Test
    public void whenMoveBishopThenShouldMoveCorrectly() {

    }
    @Test
    public void whenMoveBishopIncorrectlyThenShouldThrowException() {

    }

    /**
     * King tests.
     */
    @Test
    public void whenMoveKingThenShouldMoveCorrectly() {

    }
    @Test
    public void whenMoveKingIncorrectlyThenShouldThrowException() {

    }
    /**
     * King tests.
     */
    @Test
    public void whenMoveKnightThenShouldMoveCorrectly() {

    }
    @Test
    public void whenMoveKnightIncorrectlyThenShouldThrowException() {

    }
    @Test
    public void whenMoveKnightOverAnotherFigureThenShouldMoveCorrectly() {

    }

    /**
     * Pawn tests.
     */
    @Test
    public void whenMovePawnFirstTimeThenShouldMoveCorrectly() {

    }
    @Test
    public void whenMovePawnSecondTimeThenShouldThrowException() {

    }
    @Test
    public void whenMovePawnIncorrectlyThenShouldThrowException() {

    }

    /**
     * Queen tests.
     */
    @Test
    public void whenMoveQueenThenShouldMoveCorrectly() {

    }
    @Test
    public void whenMoveQueenIncorrectlyThenShouldThrowException() {

    }

    /**
     * Rook tests.
     */
    @Test
    public void whenMoveRookThenShouldMoveCorrectly() {

    }
    @Test
    public void whenMoveRookIncorrectlyThenShouldThrowException() {

    }

    /**
     * Utility method to prepare board for tests.
     * @return ready to test board.
     */
    public Board prepareBoard(){
        Board board = new Board();
        Figure[] figures = {
                new Rook(positions[0]),
                new Knight(positions[1]),
                new Bishop(positions[2]),
                new Queen(positions[3]),
                new King(positions[4]),
                new Bishop(positions[5]),
                new Knight(positions[6]),
                new Rook(positions[7]),
                new Pawn(positions[8])
        };
        for (Figure fig : figures) {
            board.addFigure(fig);
        }
        return board;
    }
}
