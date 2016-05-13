package models;

/**
 * Created by Prayansh on 2016-05-11.
 */
public enum CellVal {
    X(1), O(-1), B(0);
    private int val;


    CellVal(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}

