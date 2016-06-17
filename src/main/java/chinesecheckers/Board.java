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
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Board test class. So far, this simply creates a Chinese Checkers board.
 */
public class Board extends JPanel {
    // Magic numbers.
    private static final int DIAMETER = 20; // diameter of circle
    private static final int SPACE = 10; // empty space between two circles
    private static final int DISTANCE = 30; // distance between the centers of two adjacent circles
    private static final float ROOT3 = (float) Math.sqrt(3);

    // One-letter colors.
    private static final Color BOARD_COLOR = Color.LIGHT_GRAY;
    private static final Color HOLE_COLOR = Color.WHITE;   
    private static final Color W = Color.WHITE;
    private static final Color Y = Color.YELLOW;
    private static final Color B = Color.BLACK;
    private static final Color G = Color.GREEN;
    private static final Color L = Color.BLUE;
    private static final Color R = Color.RED; 
        
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);       

        // draw board objects
        for (int row = 0; row < Grid.SIZE; row++) 
        {
            for (int col = 0; col < Grid.SIZE; col++) 
            {    
                if (ChineseCheckers.getGrid().getLocation(row, col) == null)
                {
                  g.fillOval((int)(((col + 1.0) * 30.0 - 15.0) + 15.0 * row), (int)((row + 1.0) * ((30.0 / ROOT3) + (15.0 / ROOT3)) - (15.0 / ROOT3)), DIAMETER, DIAMETER);
                  g.setColor(BOARD_COLOR);
                }
                else if (ChineseCheckers.getGrid().getLocation(row, col).isHole())
                {
                  g.fillOval((int)(((col + 1.0) * 30.0 - 15.0) + 15.0 * row), (int)((row + 1.0) * ((30.0 / ROOT3) + (15.0 / ROOT3)) - (15.0 / ROOT3)), DIAMETER, DIAMETER);
                  g.setColor(HOLE_COLOR);
                }
                else 
                {
                  if (((Marble)ChineseCheckers.getGrid().getLocation(row, col)).getColor().equals(R))
                  {
                    g.fillOval((int)(((col + 1.0) * 30.0 - 15.0) + 15.0 * row), (int)((row + 1.0) * ((30.0 / ROOT3) + (15.0 / ROOT3)) - (15.0 / ROOT3)), DIAMETER, DIAMETER);
                    g.setColor(Color.RED);
                  }
                  if (((Marble)ChineseCheckers.getGrid().getLocation(row, col)).getColor().equals(L))
                  {
                    g.fillOval((int)(((col + 1.0) * 30.0 - 15.0) + 15.0 * row), (int)((row + 1.0) * ((30.0 / ROOT3) + (15.0 / ROOT3)) - (15.0 / ROOT3)), DIAMETER, DIAMETER);
                    g.setColor(Color.BLUE);
                  }  
                  if (((Marble)ChineseCheckers.getGrid().getLocation(row, col)).getColor().equals(G))
                  { 
                    g.fillOval((int)(((col + 1.0) * 30.0 - 15.0) + 15.0 * row), (int)((row + 1.0) * ((30.0 / ROOT3) + (15.0 / ROOT3)) - (15.0 / ROOT3)), DIAMETER, DIAMETER);
                    g.setColor(Color.GREEN);
                  }  
                  if (((Marble)ChineseCheckers.getGrid().getLocation(row, col)).getColor().equals(Y))
                  {
                    g.fillOval((int)(((col + 1.0) * 30.0 - 15.0) + 15.0 * row), (int)((row + 1.0) * ((30.0 / ROOT3) + (15.0 / ROOT3)) - (15.0 / ROOT3)), DIAMETER, DIAMETER);
                    g.setColor(Color.YELLOW);
                  }  
                  if (((Marble)ChineseCheckers.getGrid().getLocation(row, col)).getColor().equals(B))
                  {
                    g.fillOval((int)(((col + 1.0) * 30.0 - 15.0) + 15.0 * row), (int)((row + 1.0) * ((30.0 / ROOT3) + (15.0 / ROOT3)) - (15.0 / ROOT3)), DIAMETER, DIAMETER);
                    g.setColor(Color.ORANGE);
                  }  
                  if (((Marble)ChineseCheckers.getGrid().getLocation(row, col)).getColor().equals(W))
                  {
                    g.fillOval((int)(((col + 1.0) * 30.0 - 15.0) + 15.0 * row), (int)((row + 1.0) * ((30.0 / ROOT3) + (15.0 / ROOT3)) - (15.0 / ROOT3)), DIAMETER, DIAMETER);
                    g.setColor(Color.PINK);
                  }
               }  
            }
        }
      
    }
    // RED_FLAG: this is not correct... just something to make the panel visible
    public Dimension getPreferredSize() {
        Grid grid = ChineseCheckers.getGrid();
        return new Dimension((grid.SIZE) * DISTANCE, Math.round((grid.SIZE) * DISTANCE / ROOT3));
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