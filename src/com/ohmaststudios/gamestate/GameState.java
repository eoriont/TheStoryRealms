package com.ohmaststudios.gamestate;

import java.awt.*;
import java.awt.event.KeyEvent;

public abstract class GameState {

    GameStateManager gsm;

    public GameState(GameStateManager gsm) {
        this.gsm = gsm;
        init();
    }

    public abstract void init();
    public abstract void tick(double deltaTime);
    public abstract void render(Graphics2D g);
    public abstract void keyPressed(KeyEvent e);
    public abstract void keyReleased(KeyEvent e);

}
