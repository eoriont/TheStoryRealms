package com.ohmaststudios.main;

import com.ohmaststudios.engine.GameWindow;
import com.ohmaststudios.gameloop.GameLoop;
import com.ohmaststudios.movableObjects.Player;

import java.awt.*;

public class Game {

    public static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    public static int width = gd.getDisplayMode().getWidth();
    public static int height = gd.getDisplayMode().getHeight();

    public static void main(String[] args) {
        GameWindow frame = new GameWindow("The Story Realms", width, height);
        frame.setFullscreen(1);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Cursor cursor = toolkit.createCustomCursor(toolkit.getImage(""), new Point(0, 0), "Cursor");
        frame.setCursor(cursor);
        frame.addKeyListener(new Player());
        frame.add(new GameLoop(width, height));
        frame.setVisible(true);
    }

}
