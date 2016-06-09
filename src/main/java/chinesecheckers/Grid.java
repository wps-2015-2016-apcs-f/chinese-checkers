/*
 * Grid.java
 *
 * @author 2015-2016 APCS F-Block
 * @author David C. Petty <dpetty@winchesterps.org>
 */
package chinesecheckers;

/**
 * Grid class mirrors the Chinese Checkers {@link Board}.
 */
public class Grid {
    /** Size of square grid. */
    public static final int SIZE = 17;

    // One-letter Locations.
    private static final Location W = null;
    private static final Location Y = null;
    private static final Location K = null;
    private static final Location G = null;
    private static final Location L = null;
    private static final Location R = null;
    private static final Location P = null;
    private static final Location X = null;

    /** SIZE x SIZE array of {@link Location}s that holds the grid. */
    private Location[][] grid = new Location[SIZE][SIZE];

    public Location getLocation(int row, int col) {
        return grid[row][col];
    }
    public void set(Location location) {
    }
    public boolean move(int fromRow, int fromCol, int toRow, int toCol) {
        return true; // STUB
    }
}