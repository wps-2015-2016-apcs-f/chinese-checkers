/*
 * ChineseCheckers.java
 *
 * @author 2015-2016 APCS F-Block
 * @author David C. Petty <dpetty@winchesterps.org>
 */
package chinesecheckers;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * ChineseCheckers class.
 */
public class ChineseCheckers {

    // States.
    private static enum State { WAITING, STARTED, MOVED, JUMPED, };

    /** ChineseCheckers game {@link Window}. */
    private static Board board;
    /** ChineseCheckers game {@link Grid}. */
    private static Grid grid;
    /** ChineseCheckers state {@link State}. */
    private static State state = State.WAITING;

    /**
     * Returns {@link Window} object for this ChineseCheckers game.
     *
     * @return Window object for this ChineseCheckers game
     */
    public static Board getBoard() { return board; }
    /**
     * Returns {@link Grid} object for this ChineseCheckers game.
     *
     * @return Grid object for this ChineseCheckers game
     */
    public static Grid getGrid() { return grid; }

    private static Marble lastMarble = null;  // signifies move completed
    public static Marble getLastMarble() { return lastMarble; }

    public static void clicked(MouseEvent e) {
        System.out.printf("%s: %s ->", e, state); // RED_FLAG: debugging state transtions
        Location location = getBoard().clickedLocation(e.getPoint());
        switch (state) {
            case WAITING:
                if (location != null && !location.isHole()) {
                    lastMarble = (Marble) location;
                    state = State.STARTED;
                }
                break;
            case STARTED:
                if (location != null && location.equals(lastMarble)) {
                    lastMarble = null;          // signifies move completed                    state = State.WAITING;
                    state = State.WAITING;
                }
                if (location != null && location.isHole() && getGrid().isValidMove(lastMarble, location)) {
                    lastMarble = getGrid().move(lastMarble, location);
                    state = State.MOVED;
                }
                if (location != null && location.isHole() && getGrid().isValidJump(lastMarble, location)) {
                    lastMarble = getGrid().move(lastMarble, location);
                    state = State.JUMPED;
                }
                break;
            case MOVED:
                if (location != null && location.equals(lastMarble)) {
                    lastMarble = null;          // signifies move completed                    state = State.WAITING;
                    state = State.WAITING;
                }
                break;
            case JUMPED:
                if (location != null && location.equals(lastMarble)) {
                    lastMarble = null;          // signifies move completed                    state = State.WAITING;
                    state = State.WAITING;
                }
                if (location != null && location.isHole() && getGrid().isValidJump(lastMarble, location)) {
                    lastMarble = getGrid().move(lastMarble, location);
                    state = State.JUMPED;
                }
                break;
            default:
                break;
        }
        ChineseCheckers.getBoard().repaint();   // repaint after every click
        System.out.printf("%s\n", state); // RED_FLAG: debugging state transtions
    }

    /**
     * ChineseCheckers Game main method.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("# ChineseCheckers");
        JFrame frame = new JFrame("ChineseCheckers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = frame.getContentPane();

        // Initialize static objects board and grid.
        grid = new Grid();
        board = new Board();
        board.addMouseListener(new Mouse());
        board.addMouseMotionListener(new Mouse());

        c.add(board);
        frame.pack();
        frame.setVisible(true);
        System.out.print(grid);
    }
}
