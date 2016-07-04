package com.ohmaststudios.gamestate;

import com.ohmaststudios.gamestates.LevelLoader;
import com.ohmaststudios.gamestates.MenuState;

import java.awt.*;
import java.util.Stack;

public class GameStateManager {

    public static Stack<GameState> states;

    public GameStateManager() {
        states = new Stack<GameState>();
        states.push(new MenuState(this));
    }

    public void init() {
        states.peek().init();
    }

    public void tick(double deltaTime) {
        states.peek().tick(deltaTime);
    }

    public void render(Graphics2D g) {
        states.peek().render(g);
    }
}
