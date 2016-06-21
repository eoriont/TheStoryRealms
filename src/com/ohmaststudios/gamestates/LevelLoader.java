package com.ohmaststudios.gamestates;

import com.ohmaststudios.assets.Assets;
import com.ohmaststudios.engine.loadImageFrom;
import com.ohmaststudios.gamestate.GameState;
import com.ohmaststudios.gamestate.GameStateManager;
import com.ohmaststudios.generator.Map;

import java.awt.*;

public class LevelLoader extends GameState {

    Map map;

    public LevelLoader(GameStateManager gsm) {
        super(gsm);
    }

    @Override
    public void init() {
        map = new Map();
        map.init();
    }

    @Override
    public void tick(double deltaTime) {
        map.tick(deltaTime);
    }

    @Override
    public void render(Graphics2D g) {
        map.render(g);
    }
}
