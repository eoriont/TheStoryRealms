package com.ohmaststudios.main;

import com.ohmaststudios.engine.GameWindow;
import com.ohmaststudios.gameloop.GameLoop;
import com.ohmaststudios.managers.MouseManager;

import java.awt.*;

public class Game {

    public static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    public static int width = gd.getDisplayMode().getWidth();
    public static int height = gd.getDisplayMode().getHeight();
    public static GameWindow frame;

    public static void main(String[] args) {
        GameLoop gl = new GameLoop(width, height);

        frame = new GameWindow("The Story Realms", width, height);
        frame.setFullscreen(1);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Cursor cursor = toolkit.createCustomCursor(toolkit.getImage(""), new Point(0, 0), "Cursor");
        frame.setCursor(cursor);
        frame.addMouseListener(new MouseManager());
        frame.addMouseMotionListener(new MouseManager());
        frame.addMouseWheelListener(new MouseManager());
        frame.addKeyListener(gl);
        frame.add(gl);
        frame.setVisible(true);
    }

}
