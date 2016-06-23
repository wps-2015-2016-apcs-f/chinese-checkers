/*
 * Location.java
 *
 * @author 2015-2016 APCS F-Block
 * @author David C. Petty <dpetty@winchesterps.org>
 */
package chinesecheckers;

/**
 * Location class for the {@link Board}.
 */
public abstract class Location {

    /** Holds row. */
    private int row;
    /** Holds column. */
    private int col;

    /**
     * Constructs a {@link Location}.
     *
     * @param row row of this Location
     * @param col col of this Location
     */
    public Location(int row, int col) {
        move(row, col);
    }

    /**
     * Returns row of this {@link Location}.
     *
     * @return row of this Location
     */
    public int getRow() { return row; }

    /**
     * Returns column of this {@link Location}.
     *
     * @return column of this Location
     */
    public int getCol() { return col; }

    /**
     * Move this {@link Location} to new row and column.
     *
     * @param row new row for this Location
     * @param col new column for this Location
     */
    public void move(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Returns true if <code>this</code> {@link Location} is a {@link Hole},
     * false otherwise.
     *
     * @return true if this Location is a Hole, false otherwise
     */
    public abstract boolean isHole();

    /**
     * Returns true if <code>that</code> is non-null and row and col are equal. 
     * (Not done completely in accordance with 
     * <a href="http://www.javapractices.com/topic/TopicAction.do?Id=17">overriding</a>
     * <code>.equals</code> in {@link Object}).
     *
     * @param that {@link Location} who's state is to be compared with <code>this</code>
     * @return this.row == that.row &amp;&amp; this.col == that.col
     */
    public boolean equals(Location that) {
        return that != null
            && this.getRow() == that.getRow()
            && this.getCol() == that.getCol();
    }

    /**
     * Return {@link String} representation of <code>this</code>.
     *
     * @return String representation of this
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(getClass().getName());
        return sb.append("@(").append(row).append(",").append(col).toString();
    }
}