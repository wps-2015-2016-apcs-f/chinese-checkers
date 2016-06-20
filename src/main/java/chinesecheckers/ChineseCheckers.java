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
    private static enum State { WAITING, STARTED, LANDED, };

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

    private static Location lastLocation;

    public static void clicked(MouseEvent e) {
        System.out.printf("%s %s\n", state, e);
        Location location = getBoard().clickedLocation(e.getPoint());
        switch (state) {
            case WAITING:
                if (location != null && !location.isHole()) {
                    lastLocation = location;
                    state = State.STARTED;
                }
                break;
            case STARTED:
                if (location != null && location.isHole() && getGrid().isValidMove(lastLocation, location)) {
                    getGrid().move(lastLocation, location);
                    state = State.LANDED;
                }
                break;
            case LANDED:
                if (location != null && location.isHole() && getGrid().isValidMove(lastLocation, location)) {
                    getGrid().move(lastLocation, location);
                    state = State.STARTED;
                }
                break;
            default:
                break;
        }
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
