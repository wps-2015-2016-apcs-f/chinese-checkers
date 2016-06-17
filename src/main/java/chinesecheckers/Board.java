/*
 * Board.java
 *
 * @author 2015-2016 APCS F-Block
 * @author David C. Petty <dpetty@winchesterps.org>
 * @author Sharon Xiang
 * @author Joy Zhang
 * @author Ruoxi Zhang
 */
package chinesecheckers;

import java.awt.*;
import javax.swing.*;

/**
 * Board test class. So far, this simply creates a Chinese Checkers board.
 */
public class Board extends JPanel {
    // Magic numbers.
    private static final int DIAMETER = 20;         // Diameter of circle
    private static final int SPACE = 10;            // Empty space between two circles
    private static final int DISTANCE = 30;         // Distance between the centers of two adjacent circles
    private static final int BORDER = DISTANCE / 2; // Distance between the centers of two adjacent circles
    private static final float ROOT3 = (float) Math.sqrt(3);

    // One-letter colors.
    
    private static final Color BOARD_COLOR = UIManager.getColor("Panel.background");
    private static final Color HOLE_COLOR = Color.LIGHT_GRAY; 
    

    public void paintComponent(Graphics g) {
        super.paintComponent(g);       

        // Draw board objects.
        for (int row = 0; row < Grid.SIZE; row++) {
            for (int col = 0; col < Grid.SIZE; col++) {
                Location location = ChineseCheckers.getGrid().getLocation(row, col);
                if (location == null)
                    g.setColor(BOARD_COLOR);
                else if (location.isHole())
                    g.setColor(HOLE_COLOR);
                else g.setColor(((Marble) location).getColor());
                int xPosition = Math.round(col * DISTANCE + row * DISTANCE / 2f);
                int yPosition = Math.round(row * DISTANCE * 3 / 2f / ROOT3);
                g.fillOval(xPosition + BORDER, yPosition + BORDER, DIAMETER, DIAMETER);
            }
        }
    }

    // RED_FLAG: this is not correct... need a better notion of the total board size
    public Dimension getPreferredSize() {
        Grid grid = ChineseCheckers.getGrid();
        int width = Math.round((grid.SIZE) * DISTANCE * 3 / 2f);
        int height = Math.round((grid.SIZE + 1) * DISTANCE * 3 / 2f / ROOT3);
        return new Dimension(width, height);
    }
    public Dimension getMinimumSize() {
        return getPreferredSize();
    }
}
/*
// Temporary code using JavaFX commented out...
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