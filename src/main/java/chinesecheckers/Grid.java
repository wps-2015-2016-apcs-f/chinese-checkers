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
import java.util.*;

/**
 * Grid class mirrors the Chinese Checker {@link Board}.
 */
public class Grid {
    /** Size of square grid. */
    public static final int SIZE = 17;

    // One-letter colors.
    private static final Color W = Color.WHITE;
    private static final Color Y = Color.YELLOW;
    private static final Color K = Color.BLACK;
    private static final Color G = Color.GREEN;
    private static final Color L = Color.BLUE;
    private static final Color R = Color.RED; 
    private static final Color H = Color.MAGENTA;   //represent holes
    private static final Color X = Color.PINK;      // null spaces

    private static final Color[] colors = { W, Y, K, G, L, R, };
    private static final String colorChars = "?WYKGLR";
    
    // A grid of colors.
    private static final Color colorGrid[][] = {
        { X, X, X, X, X, X, X, X, X, X, X, X, R, X, X, X, X, },
          { X, X, X, X, X, X, X, X, X, X, X, R, R, X, X, X, X, },
            { X, X, X, X, X, X, X, X, X, X, R, R, R, X, X, X, X, },
              { X, X, X, X, X, X, X, X, X, R, R, R, R, X, X, X, X, },
                { X, X, X, X, Y, Y, Y, Y, H, H, H, H, H, K, K, K, K, },
                  { X, X, X, X, Y, Y, Y, H, H, H, H, H, H, K, K, K, X, },
                     { X, X, X, X, Y, Y, H, H, H, H, H, H, H, K, K, X, X, },
                       { X, X, X, X, Y, H, H, H, H, H, H, H, H, K, X, X, X, },
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

    /** Holds square {@link Grid} mirrors the Chinese Checker {@link Board}. */
    private Location[][] grid = new Location[SIZE][SIZE];

    /**
     * Constructs a square {@link Grid} that mirrors the Chinese Checker {@link Board}.
     */
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
                if (colorGrid[row][col].equals(K))
                    grid[row][col] = new Marble(row, col, K);
                if (colorGrid[row][col].equals(L))
                    grid[row][col] = new Marble(row, col, L);
                if (colorGrid[row][col].equals(R))
                    grid[row][col] = new Marble(row, col, R);
                if (colorGrid[row][col].equals(Y))
                    grid[row][col] = new Marble(row, col, Y);
            }
        }
    }

    /**
     * {@link Grid} copy constructor.
     *
     * @param that Grid to copy
     */
    public Grid(Grid that) {
        for (int row = 0; row < SIZE; row++)
            for (int col = 0; col < SIZE; col++)
                that.grid[row][col] = this.grid[row][col];
    }

    /**
     * Returns {@link Location} at <code>grid[row, col]</code>.
     *
     * @param row row of accessed grid Location
     * @param col column of accessed grid Location
     * @return Location at grid[row, col]
     */
    public Location getLocation(int row, int col) {
        return grid[row][col];
    }
    /**
     * Returns <code>grid</code> {@link Location} corresponding to 
     * <code>location</code>.
     *
     * @param location Location that provides grid coordinates 
     * @return grid Location corresponding to location
     */
    public Location getLocation(Location location) {
        return getLocation(location.getRow(), location.getCol());
    }
    /**
     * Sets <code>grid[row, col]</code> {@link Location} to <code>location</code>.
     *
     * @param row row of mutated grid Location
     * @param col column of returned grid Location
     * @param location new Location at grid[row, col]
     */
    public void setLocation(int row, int col, Location location) {
        assert row == location.getRow() && col == location.getCol() :
            "[" + row + "," + col + "] does not match " + location;
            grid[row][col] = location;
    }
    /**
     * Sets <code>grid</code> {@link Location} corresponding to <code>location</code>
     * to <code>location</code>.
     *
     * @param location new Location at location's grid coordinates
     */
    public void setLocation(Location location) {
        setLocation(location.getRow(), location.getCol(), location);
    }

    /**
     * Returns <code>grid</code> {@link Location} <code>deltaRow</code> and 
     * <code>deltaCol</code> away from <code>start</code>, or <code>null</code>
     * if <code>start</code> is <code>null</code> or new {@link Location} is
     * outside <code>grid</code>.
     *
     * @param start starting Location
     * @param deltaRow row change from start
     * @param deltaCol column change from start
     * @return Location deltaRow and deltaCol from start
     */
    private Location atLocation(Location start, int deltaRow, int deltaCol) {
        if (start == null)
            return null;
        assert grid[start.getRow()][start.getCol()] == start :
            "(grid[" + start.getRow() + "][" + start.getRow() + "]) != (" + start + ")";
            int row = start.getRow() + deltaRow, col = start.getCol() + deltaCol;
            if (row < 0 || row >= SIZE || col < 0 || col >= SIZE)
                return null;
            return grid[row][col];
    }

    /**
     * Returns <code>grid</code> {@link Location} left of <code>location</code>.
     *
     * @param location starting Location
     * @return Location left of location
     */
    public Location atLeft(Location location) 
    { return atLocation(location, 0, -1); }
    /**
     * Returns <code>grid</code> {@link Location} above left of <code>location</code>.
     *
     * @param location starting Location
     * @return Location above left of location
     */
    public Location atAboveLeft(Location location) 
    { return atLocation(location, -1, 0); }
    /**
     * Returns <code>grid</code> {@link Location} above right of <code>location</code>.
     *
     * @param location starting Location
     * @return Location above right of location
     */
    public Location atAboveRight(Location location) 
    { return atLocation(location, -1, +1); }
    /**
     * Returns <code>grid</code> {@link Location} right of <code>location</code>.
     *
     * @param location starting Location
     * @return Location right of location
     */
    public Location atRight(Location location) 
    { return atLocation(location, 0, +1); }
    /**
     * Returns <code>grid</code> {@link Location} below right of <code>location</code>.
     *
     * @param location starting Location
     * @return Location below right of location
     */
    public Location atBelowRight(Location location) 
    { return atLocation(location, +1, 0); }
    /**
     * Returns <code>grid</code> {@link Location} below left of <code>location</code>.
     *
     * @param location starting Location
     * @return Location below left of location
     */
    public Location atBelowLeft(Location location) 
    { return atLocation(location, +1, -1); }

    /**
     * Returns <code>true</code> if move of {@link Location} from <code>marble</code>
     * to <code>hole</code> is valid. That is, <code>marble</code>, a {@link Marble},
     * is once <code>deltaRow</code> and once <code>deltaCol</code> away from 
     * <code>hole</code>, a {@link Hole}.
     *
     * @param marble Location to move from
     * @param hole Location to move to
     * @param deltaRow row change from start
     * @param deltaCol column change from start
     * @return true if move from marble to hole is valid, otherwise false
     */
    private boolean checkMove(Location marble, Location hole, int deltaRow, int deltaCol) {
        if  (marble == null || marble.isHole() || hole == null || !hole.isHole())
            return false;
        Location oneDeltaAway = atLocation(marble, deltaRow, deltaCol);
        return hole.equals(oneDeltaAway);
    }
    /**
     * Returns <code>true</code> if <code>start</code> to <code>land</code> 
     * is a valid move to left.
     *
     * @param start starting Location
     * @param land landing Location
     * @return true if start to land is a valid move to left
     */
    public boolean checkMoveLeft(Location start, Location land)
    { return checkMove(start, land, 0, -1); }
    /**
     * Returns <code>true</code> if <code>start</code> to <code>land</code> 
     * is a valid move to above left.
     *
     * @param start starting Location
     * @param land landing Location
     * @return true if start to land is a valid move to above left
     */
    public boolean checkMoveAboveLeft(Location start, Location land)
    { return checkMove(start, land, -1, 0); }
    /**
     * Returns <code>true</code> if <code>start</code> to <code>land</code> 
     * is a valid move to above right.
     *
     * @param start starting Location
     * @param land landing Location
     * @return true if start to land is a valid move to above right
     */
    public boolean checkMoveAboveRight(Location start, Location land)
    { return checkMove(start, land, -1, +1); }
    /**
     * Returns <code>true</code> if <code>start</code> to <code>land</code> 
     * is a valid move to right.
     *
     * @param start starting Location
     * @param land landing Location
     * @return true if start to land is a valid move to right
     */
    public boolean checkMoveRight(Location start, Location land)
    { return checkMove(start, land, 0, +1); }
    /**
     * Returns <code>true</code> if <code>start</code> to <code>land</code> 
     * is a valid move to below right.
     *
     * @param start starting Location
     * @param land landing Location
     * @return true if start to land is a valid move to below right
     */
    public boolean checkMoveBelowRight(Location start, Location land)
    { return checkMove(start, land, +1, 0); }
    /**
     * Returns <code>true</code> if <code>start</code> to <code>land</code> 
     * is a valid move to below left.
     *
     * @param start starting Location
     * @param land landing Location
     * @return true if start to land is a valid move to below left
     */
    public boolean checkMoveBelowLeft(Location start, Location land)
    { return checkMove(start, land, +1, -1); }

    /**
     * Returns <code>true</code> if <code>start</code> to <code>land</code> 
     * is a valid move. That is, <code>start</code>, a {@link Marble}, is
     * adjacent to <code>land</code>, a {@link Hole}.
     *
     * @param start starting Location
     * @param land landing Location
     * @return true if start to land is a valid move
     */
    public boolean isValidMove(Location start, Location land) {
        return checkMoveLeft(start, land)
            || checkMoveAboveLeft(start, land)
            || checkMoveAboveRight(start, land)
            || checkMoveRight(start, land)
            || checkMoveBelowRight(start, land)
            || checkMoveBelowLeft(start, land);
    }

    /**
     * Returns <code>true</code> if jump of {@link Location} from <code>marble</code>
     * to <code>hole</code> is valid. That is, <code>marble</code>, a {@link Marble},
     * is twice <code>deltaRow</code> and twice <code>deltaCol</code> away from 
     * <code>hole</code>, a {@link Hole}.
     *
     * @param marble Location to move from
     * @param hole Location to move to
     * @param deltaRow row change from start
     * @param deltaCol column change from start
     * @return true if jump from marble to hole is valid, otherwise false
     */
    private boolean checkJump(Location marble, Location hole, int deltaRow, int deltaCol) {
        if  (marble == null || marble.isHole() || hole == null || !hole.isHole())
            return false;
        Location oneAway = atLocation(marble, deltaRow, deltaCol);
        Location twoAway = atLocation(marble, deltaRow * 2, deltaCol * 2);
        return oneAway != null && !oneAway.isHole() && hole.equals(twoAway);
    }
    /**
     * Returns <code>true</code> if <code>start</code> to <code>land</code> 
     * is a valid jump to left.
     *
     * @param start starting Location
     * @param land landing Location
     * @return true if start to land is a valid jump to left
     */
    public boolean checkJumpLeft(Location start, Location land)
    { return checkJump(start, land, 0, -1); }
    /**
     * Returns <code>true</code> if <code>start</code> to <code>land</code> 
     * is a valid jump to above left.
     *
     * @param start starting Location
     * @param land landing Location
     * @return true if start to land is a valid jump to above left
     */
    public boolean checkJumpAboveLeft(Location start, Location land)
    { return checkJump(start, land, -1, 0); }
    /**
     * Returns <code>true</code> if <code>start</code> to <code>land</code> 
     * is a valid jump to above right.
     *
     * @param start starting Location
     * @param land landing Location
     * @return true if start to land is a valid jump to above right
     */
    public boolean checkJumpAboveRight(Location start, Location land)
    { return checkJump(start, land, -1, +1); }
    /**
     * Returns <code>true</code> if <code>start</code> to <code>land</code> 
     * is a valid jump to right.
     *
     * @param start starting Location
     * @param land landing Location
     * @return true if start to land is a valid jump to right
     */
    public boolean checkJumpRight(Location start, Location land)
    { return checkJump(start, land, 0, +1); }
    /**
     * Returns <code>true</code> if <code>start</code> to <code>land</code> 
     * is a valid jump to below right.
     *
     * @param start starting Location
     * @param land landing Location
     * @return true if start to land is a valid jump to below right
     */
    public boolean checkJumpBelowRight(Location start, Location land)
    { return checkJump(start, land, +1, 0); }
    /**
     * Returns <code>true</code> if <code>start</code> to <code>land</code> 
     * is a valid jump to below left.
     *
     * @param start starting Location
     * @param land landing Location
     * @return true if start to land is a valid jump to below left
     */
    public boolean checkJumpBelowLeft(Location start, Location land)
    { return checkJump(start, land, +1, -1); }

    /**
     * Returns <code>true</code> if <code>start</code> to <code>land</code> 
     * is a valid move. That is, <code>start</code>, a {@link Marble}, is
     * a jump away from <code>land</code>, a {@link Hole}, with the correct
     * intervening {@link Marble}s and {@link Hole}s.
     *
     * @param start starting Location
     * @param land landing Location
     * @return true if start to land is a valid move
     */
    public boolean isValidJump(Location start, Location land) {
        return checkJumpLeft(start, land)
            || checkJumpAboveLeft(start, land)
            || checkJumpAboveRight(start, land)
            || checkJumpRight(start, land)
            || checkJumpBelowRight(start, land)
            || checkJumpBelowLeft(start, land);
    }

    public List<Location> getAllMoves(Location start) {
        List<Location> validMoves = new ArrayList<Location>();
        // No point in checking if start is invalid.
        if (start == null || start.isHole())
            return validMoves;
        // Check all six possible moves.
        if (checkMoveRight(start, atRight(start)))
            validMoves.add(atRight(start));
        if (checkMoveLeft(start, atLeft(start)))
            validMoves.add(atLeft(start));
        if (checkMoveAboveRight(start, atAboveRight(start)))
            validMoves.add(atAboveRight(start));
        if (checkMoveAboveLeft(start, atAboveLeft(start)))
            validMoves.add(atAboveLeft(start));
        if (checkMoveBelowRight(start, atBelowRight(start)))
            validMoves.add(atBelowRight(start));
        if (checkMoveBelowLeft(start, atBelowLeft(start)))
            validMoves.add(atBelowLeft(start));

        return validMoves;
    }
    public List<Location> getAllJumps(Location start) {
        List<Location> validJumps = new ArrayList<Location>();
        // No point in checking if start is invalid.
        if (start == null || start.isHole())
            return validJumps;
        // Check all six possible jumps.
        if (checkJumpRight(start, atRight(atRight(start))))
            validJumps.add(atRight(atRight(start)));
        if (checkJumpLeft(start, atLeft(atLeft(start))))
            validJumps.add(atLeft(atLeft(start)));
        if (checkJumpAboveRight(start, atAboveRight(atAboveRight(start))))
            validJumps.add(atAboveRight(atAboveRight(start)));
        if (checkJumpAboveLeft(start, atAboveLeft(atAboveLeft(start))))
            validJumps.add(atAboveLeft(atAboveLeft(start)));
        if (checkJumpBelowRight(start, atBelowRight(atBelowRight(start))))
            validJumps.add(atBelowRight(atBelowRight(start)));
        if (checkJumpBelowLeft(start, atBelowLeft(atBelowLeft(start))))
            validJumps.add(atBelowLeft(atBelowLeft(start)));

        return validJumps;
    }

    /* Returns a {@link List} of all marbles of a given color. */
    public List<Location> getAllMarbles(Color color) {
        List<Location> marbles = new ArrayList<Location>();
        for (int row = 0; row < grid.length; row++)
            for (int col = 0; col < grid[row].length; col++)
                if (grid[row][col] != null && !grid[row][col].isHole()
                   && ((Marble) grid[row][col]).getColor().equals(color))
                   marbles.add(grid[row][col]);
        return marbles;
    }

    public Marble move(Location start, Location land) {
        assert isValidMove(start, land) : "Invalid move from " + start + " to " + land;
        grid[start.getRow()][start.getCol()] = new Hole(start.getRow(), start.getCol());
        start.move(land.getRow(), land.getCol());
        grid[land.getRow()][land.getCol()] = start;
        return (Marble) start;
    }

    private char getColorChar(Color color) {
        return colorChars.charAt(Arrays.asList(colors).indexOf(color) + 1);
    }
    public String toString() {
        StringBuilder sb = new StringBuilder("{\n");
        StringBuilder indent = new StringBuilder(" ");
        for (int row = 0; row < grid.length; row++) {
            sb.append(indent).append("{ ");
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == null) sb.append("X");
                else if (grid[row][col].isHole()) sb.append("H");
                else sb.append(getColorChar(((Marble) grid[row][col]).getColor()));
                sb.append(",");
            }
            sb.append("},\n");
            indent.append(" ");
        }
        return sb.append("}").toString();
    }
}
