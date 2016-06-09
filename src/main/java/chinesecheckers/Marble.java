/*
 * Marble.java
 *
 * @author 2015-2016 APCS F-Block
 * @author David C. Petty <dpetty@winchesterps.org>
 */
package chinesecheckers;

import java.awt.*;

/**
 * Marble class which IS-A {@link Location}.
 */
public class Marble extends Location {
    /** RED_FLAG: temporary until we have a default Color in Grid */
    private static final Color NONE = Color.PINK;
    /** Holds marble {@link Color}. */
    private Color color = NONE;

    /**
     * Constructs a {@link Marble}.
     *
     * @param row row of this Marble
     * @param col col of this Marble
     * @param color color of this Marble
     */
    public Marble(int row, int col, Color color) {
        super(row, col);
        setColor(color);
    }

    /**
     * Constructs a {@link Marble}.
     *
     * @param row row of this Marble
     * @param col col of this Marble
     */
    public Marble(int row, int col) {
        this(row, col, NONE);
    }

    /**
     * Set the {@link Color} of this {@link Location}.
     *
     * @param color new color for this Marble
     */
    public void setColor(Color color) { this.color = color; }

    /**
     * Returns true if <code>this</code> {@link Location} is a {@link Hole},
     * false otherwise.
     *
     * @return true if this Location is a Hole, false otherwise
     */
    public boolean isHole() {
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