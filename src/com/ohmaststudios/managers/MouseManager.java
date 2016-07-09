package com.ohmaststudios.managers;

import com.ohmaststudios.assets.Assets;
import java.awt.*;
import java.awt.event.*;

public class MouseManager implements MouseListener, MouseMotionListener, MouseWheelListener {

    private static int mouseMovedX, mouseMovedY;
    public static Point mouse;

    public static boolean pressed;

    public static MouseType mouseType;

    public void tick() {
        mouse = new Point(mouseMovedX, mouseMovedY);

    }

    public void render(Graphics2D g) {
        if (pressed) {
            if(mouseType == MouseType.POINTER) g.drawImage(Assets.mouse2, mouseMovedX, mouseMovedY, 32, 32, null);
            if(mouseType == MouseType.FINGER) g.drawImage(Assets.mouse4, mouseMovedX, mouseMovedY, 32, 32, null);
        } else {
            if(mouseType == MouseType.POINTER) g.drawImage(Assets.mouse1, mouseMovedX, mouseMovedY, 32, 32, null);
            if(mouseType == MouseType.FINGER) g.drawImage(Assets.mouse3, mouseMovedX, mouseMovedY, 32, 32, null);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            pressed = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            pressed = false;
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mouseMovedX = e.getX();
        mouseMovedY = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseMovedX = e.getX();
        mouseMovedY = e.getY();
    }


    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseClicked(MouseEvent e) {}

    public enum MouseType {
        FINGER, POINTER, DISABLED
    }
}
