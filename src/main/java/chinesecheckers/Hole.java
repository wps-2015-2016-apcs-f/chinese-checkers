/*
 * Hole.java
 *
 * @author 2015-2016 APCS F-Block
 * @author David C. Petty <dpetty@winchesterps.org>
 */
package chinesecheckers;

/**
 * Hole class which IS-A {@link Location}.
 */
public class Hole extends Location {
    /**
     * Constructs a {@link Hole}.
     *
     * @param row row of this Hole
     * @param col col of this Hole
     */
    public Hole(int row, int col) {
        super(row, col);
    }

    /**
     * Constructs a copy of a {@link Hole}.
     *
     * @param that Hole to copy
     */
    public Hole(Hole that) {
        super(that.getRow(), that.getCol());
    }

    /**
     * Returns true if <code>this</code> {@link Location} is a {@link Hole},
     * false otherwise.
     *
     * @return true if this Location is a Hole, false otherwise
     */
    public boolean isHole() {
        return true;
    }

    /**
     * Return {@link String} representation of <code>this</code>.
     *
     * @return String representation of this
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        return sb.append(")").toString();
    }
}