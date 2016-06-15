/*
 * Grid.java
 *
 * @author 2015-2016 APCS F-Block
 * @author David C. Petty <dpetty@winchesterps.org>
 * @author Emilia Lew
 * @author Kallisti St. John
 */
package chinesecheckers;

import java.awt.Color;

/**
 * Grid class mirrors the Chinese Checker {@link Board}.
 */
public class Grid {
    /** Size of square grid. */
    public static final int SIZE = 17;

    // One-letter colors.
    private static final Color W = Color.WHITE;
    private static final Color Y = Color.YELLOW;
    private static final Color B = Color.BLACK;
    private static final Color G = Color.GREEN;
    private static final Color L = Color.BLUE;
    private static final Color R = Color.RED; 
    private static final Color H = Color.MAGENTA;   //represent holes
    private static final Color X = Color.PINK;      // null spaces

    // A grid of colors.
    private static final Color colorGrid[][] = {
        { X, X, X, X, X, X, X, X, X, X, X, X, R, X, X, X, X, },
          { X, X, X, X, X, X, X, X, X, X, X, R, R, X, X, X, X, },
            { X, X, X, X, X, X, X, X, X, X, R, R, R, X, X, X, X, },
              { X, X, X, X, X, X, X, X, X, R, R, R, R, X, X, X, X, },
                { X, X, X, X, Y, Y, Y, Y, H, H, H, H, H, B, B, B, B, },
                  { X, X, X, X, Y, Y, Y, H, H, H, H, H, H, B, B, B, X, },
                    { X, X, X, X, Y, Y, H, H, H, H, H, H, H, B, B, X, X, },
                      { X, X, X, X, Y, H, H, H, H, H, H, H, H, B, X, X, X, },
                        { X, X, X, X, H, H, H, H, H, H, H, H, H, X, X, X, X, },
                          { X, X, X, W, H, H, H, H, H, H, H, H, L, X, X, X, X, },
                            { X, X, W, W, H, H, H, H, H, H, H, L, L, X, X, X, X, },
                              { X, W, W, W, H, H, H, H, H, H, L, L, L, X, X, X, X, },
                                { W, W, W, W, H, H, H, H, H, L, L, L, L, X, X, X, X, },
                                  { X, X, X, X, G, G, G, G, X, X, X, X, X, X, X, X, X, },
                                    { X, X, X, X, G, G, G, X, X, X, X, X, X, X, X, X, X, },
                                      { X, X, X, X, G, G, X, X, X, X, X, X, X, X, X, X, X, },
                                        { X, X, X, X, G, X, X, X, X, X, X, X, X, X, X, X, X, },
    };

    private Location[][] grid = new Location[SIZE][SIZE];

    public Grid()
    {
        assert colorGrid.length == SIZE;
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
            assert colorGrid[row].length == SIZE;
            if (colorGrid[row][col].equals(X))
                grid[row][col] = null;
            if (colorGrid[row][col].equals(H))
                grid[row][col] = new Hole(row, col);
            if (colorGrid[row][col].equals(W))
                grid[row][col] = new Marble(row, col, W);
            if (colorGrid[row][col].equals(G))
                grid[row][col] = new Marble(row, col, G);
            if (colorGrid[row][col].equals(B))
                grid[row][col] = new Marble(row, col, B);
            if (colorGrid[row][col].equals(L))
                grid[row][col] = new Marble(row, col, L);
            if (colorGrid[row][col].equals(R))
                grid[row][col] = new Marble(row, col, R);
            if (colorGrid[row][col].equals(Y))
                grid[row][col] = new Marble(row, col, Y);
            }
        }
    }

    public Location getLocation(int row, int col) {
        return grid[row][col];
    }
    public Location getLocation(Location location) {
        return getLocation(location.getRow(), location.getCol());
    }
    public void setLocation(int row, int col, Location location) {
        grid[location.getRow()][location.getCol()] = location;
    }
    public void setLocation(Location location) {
        setLocation(location.getRow(), location.getCol(), location);
    }

    /**
     * Returns {@link Location} in this {@link Grid} <code>deltaRow</code> and 
     * <code>deltaCol</code> away from <code>start</code>.
     *
     * @param start starting Location
     * @param deltaRow row change from start
     * @param deltaCol column change from start
     * @return Location <code>deltaRow</code> and <code>deltaRow</code> from this
     */
    private Location atLocation(Location start, int deltaRow, int deltaCol) {
        if (start == null)
            return null;
        int row = start.getRow() + deltaRow, col = start.getCol() + deltaCol;
        assert grid[start.getRow()][start.getCol()] == start :
            "(grid[" + start.getRow() + "][" + start.getRow() + "]) != (" + start + ")";
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE)
            return null;
        return grid[row][col];
    }
    
    public Location atLeft(Location location) { return atLocation(location, 0, -1); }
    
    public Location atAboveLeft(Location location) { return atLocation(location, -1, 0); }
    
    public Location atAboveRight(Location location) { return atLocation(location, -1, +1); }
    
    public Location atRight(Location location) { return atLocation(location, 0, +1); }
    
    public Location atBelowRight(Location location) { return atLocation(location, +1, 0); }
    
    public Location atBelowLeft(Location location) { return atLocation(location, +1, -1); }

    public static boolean isValidMove(Location marble, Location land) {
        return true; //STUB
    }

    public boolean move(int fromRow, int fromCol, int toRow, int toCol) {
        return true; // STUB
    }
}