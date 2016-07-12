package com.ohmaststudios.gamestate;

import com.ohmaststudios.gamestates.MenuState;
import com.ohmaststudios.managers.MouseManager;

import java.awt.*;
import java.util.Stack;

public class GameStateManager {

    public Stack<GameState> states;

    public GameStateManager() {
        states = new Stack<GameState>();
        states.push(new MenuState(this, new MouseManager()));
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