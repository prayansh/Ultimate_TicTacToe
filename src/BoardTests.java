import models.Board;
import models.Cell;
import models.CellVal;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Prayansh on 2016-05-11.
 */
public class BoardTests {

    private CellVal[] board1 = {
            CellVal.X, CellVal.O, CellVal.B,
            CellVal.X, CellVal.O, CellVal.B,
            CellVal.X, CellVal.B, CellVal.B};

    private CellVal[] board2 = {
            CellVal.X, CellVal.O, CellVal.B,
            CellVal.O, CellVal.X, CellVal.B,
            CellVal.O, CellVal.B, CellVal.X};

    private CellVal[] board3 = {
            CellVal.O, CellVal.X, CellVal.X,
            CellVal.O, CellVal.O, CellVal.O,
            CellVal.X, CellVal.B, CellVal.B};
    //todo
    private CellVal[] board4 = {
            CellVal.X, CellVal.O, CellVal.B,
            CellVal.X, CellVal.O, CellVal.B,
            CellVal.O, CellVal.B, CellVal.B};

    private CellVal[] board5 = {
            CellVal.X, CellVal.O, CellVal.B,
            CellVal.X, CellVal.O, CellVal.B,
            CellVal.X, CellVal.B, CellVal.B};

    private CellVal[] board6 = {
            CellVal.X, CellVal.O, CellVal.B,
            CellVal.X, CellVal.O, CellVal.B,
            CellVal.X, CellVal.B, CellVal.B};

    private CellVal[] board7 = {
            CellVal.X, CellVal.O, CellVal.B,
            CellVal.X, CellVal.O, CellVal.B,
            CellVal.X, CellVal.B, CellVal.B};

    @Test
    public void testBoard1() {
        Board board = new Board();
        board.setCellAt(0, 0, CellVal.X);
        board.setCellAt(0, 2, CellVal.O);
        board.setCellAt(1, 1, CellVal.X);
        board.setCellAt(2, 2, CellVal.X);
        assertTrue(board.solved());
        assertTrue(board.winner().equals(CellVal.X));
    }

    @Test
    public void testBoard2() {
        Board board = new Board();
        board.setCellAt(0, 0, CellVal.O);
        board.setCellAt(0, 2, CellVal.O);
        board.setCellAt(1, 1, CellVal.O);
        board.setCellAt(2, 2, CellVal.O);
        assertTrue(board.solved());
        assertTrue(board.winner().equals(CellVal.O));
    }

    @Test
    public void testBoard3() {
        Board board = new Board();
        board.setCellAt(0, 0, CellVal.O);
        board.setCellAt(0, 1, CellVal.O);
        board.setCellAt(0, 2, CellVal.O);
        board.setCellAt(2, 2, CellVal.X);
        assertTrue(board.solved());
        assertTrue(board.winner().equals(CellVal.O));
    }

    @Test
    public void testBoard4() {
        Board board = new Board();
        board.setCellAt(0, 0, CellVal.O);
        board.setCellAt(0, 1, CellVal.O);
        board.setCellAt(2, 2, CellVal.O);
        board.setCellAt(1, 2, CellVal.X);
        assertFalse(board.solved());
    }

    @Test
    public void testScore() {
        Board b = new Board(board1);
        assertEquals(CellVal.X, b.winner());
        b = new Board(board2);
        assertEquals(CellVal.X, b.winner());
        b = new Board(board3);
        assertEquals(CellVal.O, b.winner());
        b = new Board(board4);
        assertFalse(b.solved());
    }
}
