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
    private static final int DIAMETER = 20;
    private static final int SPACE = 10;
    private static final int DISTANCE = 30;
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
        
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        
        //int dHole = Math.round(Math.min(getWidth() / H_SPACES, getHeight() / V_SPACES * ROOT3));

        // draw entire component white
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, 500, 500);

        // draw holes
        for (int row = 0; row < Grid.SIZE; row++) 
        {
            for (int col = 0; col < Grid.SIZE; col++) 
            {    
                
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