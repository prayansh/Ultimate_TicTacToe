package models;

/**
 * Created by Prayansh on 2016-05-11.
 */
public class Cell {
    private CellVal val;

    public Cell() {
        val = CellVal.B;
    }

    public void setVal(CellVal val) {
        this.val = val;
    }

    public CellVal getVal() {
        return val;
    }

    @Override
    public String toString() {
        return val.name();
    }
}
