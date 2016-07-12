package com.ohmaststudios.gamestate;

import com.ohmaststudios.managers.MouseManager;

import java.awt.*;
import java.awt.event.KeyEvent;

public abstract class GameState {

    protected GameStateManager gsm;
    public  MouseManager mm;

    public GameState(GameStateManager gsm, MouseManager mm) {
        this.gsm = gsm;
        this.mm = mm;
        init();
    }

    public abstract void init();
    public abstract void tick(double deltaTime);
    public abstract void render(Graphics2D g);
    public abstract void keyPressed(KeyEvent e);
    public abstract void keyReleased(KeyEvent e);

}
