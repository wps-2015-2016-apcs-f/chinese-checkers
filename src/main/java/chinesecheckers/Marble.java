/*
 * Marble.java
 *
 * @author 2015-2016 APCS F-Block
 * @author David C. Petty <dpetty@winchesterps.org>
 */
package chinesecheckers;

/**
 * Marble class which IS-A {@link Location}.
 */
public class Marble extends Location {
    /**
     * Constructs a {@link Marble}.
     *
     * @param row row of this Marble
     * @param col col of this Marble
     */
    public Marble(int row, int col) {
        super(row, col);
    }

    /**
     * Returns true if <code>this</code> {@link Marble} is empty.
     *
     * @return false
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * Return {@link String} representation of <code>this</code>.
     *
     * @return String representation of this
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Marble@");
        return sb.append(super.toString()).toString();
    }
}