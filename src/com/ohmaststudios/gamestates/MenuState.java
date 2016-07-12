package com.ohmaststudios.gamestates;

import com.ohmaststudios.gamestate.GameState;
import com.ohmaststudios.gamestate.GameStateButton;
import com.ohmaststudios.gamestate.GameStateManager;
import com.ohmaststudios.generator.World;
import com.ohmaststudios.main.Game;
import com.ohmaststudios.managers.MouseManager;
import com.ohmaststudios.movableObjects.Player;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MenuState extends GameState {

    MouseManager mm;
    GameStateManager gsm;
    GameStateButton startButton;
    GameStateButton options;
    GameStateButton quit;

    public MenuState(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        mm = new MouseManager();
        startButton = new GameStateButton(Game.width/3, 200, new LevelLoader(gsm), gsm, "Start Game");
        options = new GameStateButton(Game.width/3, 400, new LevelLoader(gsm), gsm, "Options");
        quit = new GameStateButton(Game.width/3, 600, new QuitState(gsm), gsm, "Quit");
    }

    @Override
    public void tick(double deltaTime) {
        mm.tick();
        startButton.tick();
        options.tick();
        quit.tick();
    }

    @Override
    public void render(Graphics2D g) {
        startButton.render(g);
        options.render(g);
        quit.render(g);

        mm.render(g);
    }


    public void keyPressed(KeyEvent e) {

    }
    public void keyReleased(KeyEvent e) {

    }
}
