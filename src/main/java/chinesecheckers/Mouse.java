/*
 * Mouse.java
 *
 * @author 2015-2016 APCS F-Block
 * @author Sharon Xiang
 * @author Joy Zhang
 * @author Ruoxi Zhang
 */
package chinesecheckers;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Mouse extends MouseInputAdapter {
    /** Invoked when the mouse button has been clicked (pressed and released) on a component. */
    public void mouseClicked(MouseEvent e) {
        //System.out.printf("%s %s %s; ", e, e.getX(), e.getY());
    }
    /** Invoked when a mouse button has been pressed on a component. */
    public void mousePressed(MouseEvent e) {
    }
    /** Invoked when a mouse button has been released on a component. */
    public void mouseReleased(MouseEvent e) {
    }
    /** Invoked when the mouse enters a component. */
    public void mouseEntered(MouseEvent e) {
    }
    /** Invoked when the mouse exits a component. */
    public void mouseExited(MouseEvent e) {
    }

    /** Invoked when a mouse button is pressed on a component and then dragged. */
    public void mouseDragged(MouseEvent e) {
    }
    /** Invoked when the mouse cursor has been moved onto a component but no buttons have been pushed. */
    public void mouseMoved(MouseEvent e) {
        //System.out.printf("%s %s %s; ", e, e.getX(), e.getY());
        ((Board) e.getComponent()).setPoint(new Point(e.getX(), e.getY()));
        e.getComponent().repaint();
    }
}