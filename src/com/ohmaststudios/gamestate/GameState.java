package com.ohmaststudios.gamestate;

import java.awt.*;

public abstract class GameState {

    GameStateManager gsm;

    public GameState(GameStateManager gsm) {
        this.gsm = gsm;
        init();
    }

    public abstract void init();
    public abstract void tick(double deltaTime);
    public abstract void render(Graphics2D g);

}
