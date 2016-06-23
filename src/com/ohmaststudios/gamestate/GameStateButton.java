package com.ohmaststudios.gamestate;

import com.ohmaststudios.engine.Vector2F;

import java.awt.*;

public class GameStateButton extends Rectangle {

    private Vector2F pos;
    private GameState gameState;
    GameStateManager gsm;

    private boolean isClicked, isHeldOver;
    private int width = 64*3, height = 64;

    public GameStateButton(float xpos, float ypos, GameState gameState, GameStateManager gsm) {
        this.gameState = gameState;
        this.pos.xpos = xpos;
        this.pos.ypos = ypos;
        this.gsm = gsm;

        setBounds((int) pos.xpos, (int) pos.ypos, width, height);
    }

    public GameStateButton(float xpos, float ypos) {
        this.pos.xpos = xpos;
        this.pos.ypos = ypos;
        setBounds((int) pos.xpos, (int) pos.ypos, width, height);
    }

    public void tick() {
        setBounds((int) pos.xpos, (int) pos.ypos, width, height);
    }

    public void render(Graphics2D g) {
        if(!isHeldOver) {
            g.fillRect((int) pos.xpos, (int) pos.ypos, width, height);
        } else {
            g.setColor(Color.GREEN);
            g.fillRect((int) pos.xpos, (int) pos.ypos, width, height);
            g.setColor(Color.YELLOW);
        }
    }

    public boolean isClicked() {
        return isClicked;
    }
    public boolean isHeldOver() {
        return isHeldOver;
    }
}
