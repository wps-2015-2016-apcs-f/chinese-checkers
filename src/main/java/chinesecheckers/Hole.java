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
     * Returns true if <code>this</code> {@link Hole} is empty.
     *
     * @return true
     */
    public boolean isEmpty() {
        return true;
    }

    /**
     * Return {@link String} representation of <code>this</code>.
     *
     * @return String representation of this
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Hole@");
        return sb.append(super.toString()).toString();
    }
}