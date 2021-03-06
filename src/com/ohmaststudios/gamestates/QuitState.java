package com.ohmaststudios.gamestates;

import com.ohmaststudios.gamestate.GameState;
import com.ohmaststudios.gamestate.GameStateButton;
import com.ohmaststudios.gamestate.GameStateManager;
import com.ohmaststudios.main.Game;
import com.ohmaststudios.managers.MouseManager;

import java.awt.*;
import java.awt.event.KeyEvent;

public class QuitState extends GameState {

    private GameStateManager gsm;
    private GameStateButton no;
    private GameStateButton yes;

    public QuitState(GameStateManager gsm, MouseManager mm) {
        super(gsm, mm);
    }

    @Override
    public void init() {
        mm = new MouseManager();
        yes = new GameStateButton(Game.width/3 - 200, 100, "I'm Sure!");
        no = new GameStateButton(Game.width/3 + 200, 100, "Go Back!");
    }

    @Override
    public void tick(double deltaTime) {
        yes.tick();
        no.tick();

        if(yes.isPressed() && yes.isHeldOver()) {
            System.exit(1);
        }
        if(no.isHeldOver() && no.isPressed()) {
            gsm.states.push(new MenuState(gsm, mm));
            gsm.states.peek().init();
        }
    }

    @Override
    public void render(Graphics2D g) {
        yes.render(g);
        no.render(g);
    }


    public void keyPressed(KeyEvent e) {

    }
    public void keyReleased(KeyEvent e) {

    }
}
