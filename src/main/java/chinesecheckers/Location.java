/*
 * Location.java
 *
 * @author 2015-2016 APCS A-Block
 * @author David C. Petty <dpetty@winchesterps.org>
 */
package chinesecheckers;

/**
 * Location class for the grid.
 */
public class Location {

    /** Holds row. */
    private int row;
    /** Holds column. */
    private int col;

    /** Construct a Location.
     */
    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /** Return row of this Location.
     * @return row of this Location
     */
    public int getRow() { return row; }

    /** Return column of this Location.
     * @return column of this Location
     */
    public int getCol() { return col; }

    /** Return true if that is non-null, rows are equal, and cols are equal.
     * @return this.row == that.row && this.col == that.col
     */
    public boolean equals(Location that) {
        if (that == null) return false;
        return this.getRow() == that.getRow() && this.getCol() == that.getCol();
    }

    /** Return String representation of this.
     * @return String representation of this
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        return sb.append(row).append(",").append(col).append(")").toString();
    }
}