package com.ohmaststudios.gamestates;

import com.ohmaststudios.gamestate.GameState;
import com.ohmaststudios.gamestate.GameStateButton;
import com.ohmaststudios.gamestate.GameStateManager;
import com.ohmaststudios.main.Game;
import com.ohmaststudios.managers.MouseManager;

import java.awt.*;

public class QuitState extends GameState {

    MouseManager mm;
    GameStateManager gsm;
    GameStateButton no;
    GameStateButton yes;

    public QuitState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        mm = new MouseManager();
        yes = new GameStateButton(Game.width/3 - 200, 100, "I'm Sure!");
        no = new GameStateButton(Game.width/3 + 200, 100, "Go Back!");
    }

    @Override
    public void tick(double deltaTime) {
        mm.tick();
        yes.tick();
        no.tick();

        if(yes.isPressed() && yes.isHeldOver()) {
            System.exit(1);
        }
        if(no.isHeldOver() && no.isPressed()) {
            gsm.states.push(new MenuState(gsm));
            gsm.states.peek().init();
        }
    }

    @Override
    public void render(Graphics2D g) {
        yes.render(g);
        no.render(g);

        mm.render(g);
    }
}
