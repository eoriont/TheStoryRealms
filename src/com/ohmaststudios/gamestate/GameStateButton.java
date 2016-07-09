package com.ohmaststudios.gamestate;

import com.ohmaststudios.assets.Assets;
import com.ohmaststudios.engine.Vector2F;
import com.ohmaststudios.managers.MouseManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameStateButton extends Rectangle {

    private Vector2F pos = new Vector2F();
    private GameState gameState;
    private BufferedImage defaultImage;
    private GameStateManager gsm;
    private String buttonMessage;

    private boolean isHeldOver;
    private int width = 64*6, height = 64*2;

    public GameStateButton(float xpos, float ypos, GameState gameState, GameStateManager gsm, String buttonMessage) {
        this.gameState = gameState;
        this.pos.xpos = xpos;
        this.pos.ypos = ypos;
        this.gsm = gsm;
        this.buttonMessage = buttonMessage;

        setBounds((int) pos.xpos, (int) pos.ypos, width, height);
        defaultImage = Assets.button1;
    }

    public GameStateButton(float xpos, float ypos, String buttonMessage) {
        this.pos.xpos = xpos;
        this.pos.ypos = ypos;
        this.buttonMessage = buttonMessage;
        setBounds((int) pos.xpos, (int) pos.ypos, width, height);
    }

    public void tick() {
        setBounds((int) pos.xpos, (int) pos.ypos, width, height);

        if(getBounds().contains(MouseManager.mouse)) {
            isHeldOver = true;
            MouseManager.mouseType = MouseManager.MouseType.FINGER;
        } else {
            isHeldOver = false;
            MouseManager.mouseType = MouseManager.MouseType.POINTER;
        }

        if(isHeldOver) {
            if (defaultImage != Assets.button2) {
                defaultImage = Assets.button2;
            }
        } else {
            if(defaultImage != Assets.button1) {
                defaultImage = Assets.button1;
            }
        }

        if(gameState != null) {
            if(isHeldOver) {
                if(isPressed()) {
                    gsm.states.push(gameState);
                    isHeldOver = false;
                    MouseManager.pressed = false;
                }
            }
        }
    }

    public void render(Graphics2D g) {
        g.drawImage(defaultImage, (int) pos.xpos, (int) pos.ypos, width, height, null);
        g.drawString(buttonMessage, pos.xpos, pos.ypos);
    }

    public boolean isHeldOver() {
        return isHeldOver;
    }
    public boolean isPressed() {
        return MouseManager.pressed;
    }
}
