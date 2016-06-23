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
    private static final int DISTANCE = 30;         // Distance between the centers of two adjacent circles
    private static final int BORDER = DISTANCE / 2; // Size of border
    private static final float ROOT3 = (float) Math.sqrt(3);

    private static final Color BOARD_COLOR = UIManager.getColor("Panel.background");
    private static final Color HOLE_COLOR = Color.LIGHT_GRAY; 

    /** Holds last point of mouse movement. Set by {@link Mouse}. */
    private Point mouse = null;
    public void setPoint(Point point) { mouse = point; }

    private Point getCorner(int row, int col) {
        return new Point((int) (col * DISTANCE + row * DISTANCE / 2f),
                         (int) (row * DISTANCE * ROOT3 / 2f));
    }
    private boolean isWithin(Point point, Point corner) {
/*
        // Determine whether point is within a radius of center of location 
        // determined by corner.
        double deltaX = corner.getX() + DIAMETER / 2 - point.getX();
        double deltaY = corner.getY() + DIAMETER / 2 - point.getY();
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY) < DIAMETER / 2;
*/
        // Determine whether point is within location rectangle determined by corner.
        return point.getX() >= corner.getX() && point.getX() <= corner.getX() + DIAMETER
            && point.getY() >= corner.getY() && point.getY() <= corner.getY() + DIAMETER;
    }

    public Location clickedLocation(Point point) {
        for (int row = 0; row < Grid.SIZE; row++) {
            for (int col = 0; col < Grid.SIZE; col++) {
                // Get grid location and corner point.
                Location location = ChineseCheckers.getGrid().getLocation(row, col);
                Point corner = getCorner(row, col);
                if (isWithin(mouse, corner)) {
                    return location;
                }
            }
        }
        return null;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw board objects.
        for (int row = 0; row < Grid.SIZE; row++) {
            for (int col = 0; col < Grid.SIZE; col++) {
                // Get grid location and corner point.
                Location location = ChineseCheckers.getGrid().getLocation(row, col);
                Point corner = getCorner(row, col);
                // Highlight location under mouse.
                if (location != null && mouse != null && isWithin(mouse, corner)) {
                    g.setColor(Color.ORANGE);
                    g.fillRect((int) corner.getX(), (int) corner.getY(), DIAMETER, DIAMETER);
                }
                // Set board / hole / marble color.
                if (location == null)
                    g.setColor(BOARD_COLOR);
                else if (location.isHole())
                    g.setColor(HOLE_COLOR);
                else g.setColor(((Marble) location).getColor());
                // Draw marble or hole.
                g.fillOval((int) corner.getX(), (int) corner.getY(), DIAMETER, DIAMETER);
                // Draw smaller dot of opposite color on selected marble.
                Marble lastMarble = ChineseCheckers.getLastMarble() ;
                if (lastMarble != null && lastMarble.equals(location)) {
                    g.setColor(lastMarble.getOppositeColor());
                    g.fillOval((int) corner.getX() + DIAMETER / 4, (int) corner.getY() + DIAMETER / 4, DIAMETER / 2, DIAMETER / 2);
                }
            }
        }
    }

    public Dimension getPreferredSize() {
        Point corner = getCorner(Grid.SIZE - 1, Grid.SIZE - 1);
        int width = (int) corner.getX() + DIAMETER;
        int height = (int) corner.getY() + DIAMETER;
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