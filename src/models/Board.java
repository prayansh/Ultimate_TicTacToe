package models;

/**
 * Created by Prayansh on 2016-05-11.
 * INVARIANT: Size is always 9
 */

public class Board {
    private Cell[] cells;
    private int score[];

    public Board() {
        cells = new Cell[9];
        score = new int[8];
        for (int i = 0; i < 9; i++)
            cells[i] = new Cell();
    }

    public Board(Cell[] cells) {
        this();
        for (int i = 0; i < cells.length; i++) {
            setCellAt(i, cells[i].getVal());
        }
    }

    public Board(CellVal[] cells) {
        this();
        for (int i = 0; i < cells.length; i++) {
            setCellAt(i, cells[i]);
        }
    }

    /**
     * Set the cell at index to the player value
     *
     * @return true if new val is set, false if invalid cell
     */
    public boolean setCellAt(int index, CellVal player) {
        checkRobust();
        if (cellAt(index).getVal() != CellVal.B)
            return false;
        cells[index].setVal(player);
        score[index / 3] += player.getVal();
        score[3 + index % 3] += player.getVal();
        if ((index / 3) == (index % 3)) score[2 * 3] += player.getVal();
        if (3 - 1 - (index % 3) == (index / 3)) score[2 * 3 + 1] += player.getVal();
        return true;
    }

    public boolean setCellAt(int row, int column, CellVal player) {
        return setCellAt(row * 3 + column, player);
    }

    public Cell cellAt(int row, int column) {
        return cellAt(row * 3 + column);
    }

    public Cell cellAt(int index) {
        checkRobust();
        if (index > 9)
            throw new AssertionError("Position not valid");
        return cells[index];
    }


    /**
     * Next Best Position to play at
     *
     * @param cv player
     * @return next best position
     */
    public Cell bestPos(CellVal cv) {
        if (cv.equals(CellVal.B))
            throw new AssertionError("Invalid Player");
        return new Cell();//TODO
    }

    public boolean solved() {
        return (solved(CellVal.X) || solved(CellVal.O));
    }

    /**
     * PRECONDITION:solved()
     *
     * @return
     */
    public CellVal winner() {
        if (!solved())
            throw new AssertionError("Winner has not been decided");
        if (solved(CellVal.X))
            return CellVal.X;
        return CellVal.O;
    }

    private boolean solved(CellVal player) {
        checkRobust();
        int check = player.getVal() * 3;
        for (int i = 0; i < score.length; i++) {
            if (score[i] == check)
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                s += (cells[i * 3 + j].getVal() + " ");
            }
            s += "\n";
        }
        return s;
    }

    public void checkRobust() {
        if (cells.length != 9)
            throw new AssertionError("Board is invalid");
    }
}
