/*
 * Board.java
 *
 * @author 2015-2016 APCS F-Block
 * @author David C. Petty <dpetty@winchesterps.org>
 */
package chinesecheckers;
/*
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Board extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}
*/
import java.awt.*;
import javax.swing.*;

/**
 * Board test class. So far, this simply creates a Chinese Checkers board.
 */
public class Board extends JComponent {
    // Magic numbers.
    private static final int MIN_HOLE = 20;
    private static final int H_SPACES = 27;
    private static final int V_SPACES = 35;
    private static final float ROOT3 = (float) Math.sqrt(3);

    // One-letter colors.
    private static final Color W = Color.WHITE;
    private static final Color Y = Color.YELLOW;
    private static final Color K = Color.BLACK;
    private static final Color G = Color.GREEN;
    private static final Color L = Color.BLUE;
    private static final Color R = Color.RED;
    private static final Color P = Color.PINK;
    private static final Color X = Color.MAGENTA;

    // A grid of colors.
    private Color grid[][] = {
        { W, W, W, W, W, W, Y, W, W, W, W, W, W, },
          { W, W, W, W, W, Y, Y, W, W, W, W, W, W, },
        { W, W, W, W, W, Y, Y, Y, W, W, W, W, W, },
          { W, W, W, W, Y, Y, Y, Y, W, W, W, W, W, },
        { K, K, K, K, X, X, X, X, X, G, G, G, G, },
          { K, K, K, X, X, X, X, X, X, G, G, G, W, },
        { W, K, K, X, X, X, X, X, X, X, G, G, W, },
          { W, K, X, X, X, X, X, X, X, X, G, W, W, },
        { W, W, X, X, X, X, X, X, X, X, X, W, W, },
          { W, P, X, X, X, X, X, X, X, X, L, W, W, },
        { W, P, P, X, X, X, X, X, X, X, L, L, W, },
          { P, P, P, X, X, X, X, X, X, L, L, L, W, },
        { P, P, P, P, X, X, X, X, X, L, L, L, L, },
          { W, W, W, W, R, R, R, R, W, W, W, W, W, },
        { W, W, W, W, W, R, R, R, W, W, W, W, W, },
          { W, W, W, W, W, R, R, W, W, W, W, W, W, },
        { W, W, W, W, W, W, R, W, W, W, W, W, W, },
    };
        
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int dHole = Math.round(Math.min(getWidth() / H_SPACES, getHeight() / V_SPACES * ROOT3));

        // draw entire component white
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        // draw holes
        for (int row = 0; row < grid.length * 2; row++) {
            for (int col = 0; col < grid[row / 2].length * 2; col++) {
                if (col % 2 != 0 && row % 2 != 0 ) {
                    int offset = row / 2 % 2 != 0 ? dHole : 0;
                    g.setColor(grid[row / 2][col / 2]);
                    if (g.getColor().equals(X))
                    g.drawOval(col * dHole + offset, Math.round(row * dHole / ROOT3), dHole, dHole);
                    else
                    g.fillOval(col * dHole + offset, Math.round(row * dHole / ROOT3), dHole, dHole);
                }
            }
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension((H_SPACES + 1 - 1) * MIN_HOLE, Math.round(V_SPACES * MIN_HOLE / ROOT3));
    }
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

    /**
     * Board main method.
     *
     * @param args command-line arguments
     */
    public static void main(String args[]) {
        JFrame mainFrame = new JFrame("Chinese Checkers");
        mainFrame.getContentPane().add(new Board());
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}
