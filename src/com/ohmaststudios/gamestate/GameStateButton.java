package com.ohmaststudios.gamestate;

import com.ohmaststudios.engine.Vector2F;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameStateButton extends Rectangle {

    private Vector2F pos = new Vector2F();
    private GameState gameState;
    private BufferedImage defaultImage;
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
        g.drawImage(defaultImage, (int) pos.xpos, (int) pos.ypos, width, height, null);
    }

    public boolean isClicked() {
        return isClicked;
    }
    public boolean isHeldOver() {
        return isHeldOver;
    }
}
