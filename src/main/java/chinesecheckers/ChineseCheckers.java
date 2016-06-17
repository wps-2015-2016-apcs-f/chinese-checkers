/*
 * ChineseCheckers.java
 *
 * @author 2015-2016 APCS F-Block
 * @author David C. Petty <dpetty@winchesterps.org>
 */
package chinesecheckers;

import java.awt.*;
import javax.swing.*;

/**
 * ChineseCheckers class.
 */
public class ChineseCheckers {

    /** ChineseCheckers game {@link Window}. */
    private static Board board;
    /** ChineseCheckers game {@link Grid}. */
    private static Grid grid;

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

        c.add(board);
        frame.pack();
        frame.setVisible(true);
        System.out.print(grid);
    }
}
