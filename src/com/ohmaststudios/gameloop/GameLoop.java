package com.ohmaststudios.gameloop;

import com.ohmaststudios.engine.OGameLoop;
import com.ohmaststudios.engine.Vector2F;
import com.ohmaststudios.gamestate.GameStateManager;
import com.ohmaststudios.assets.Assets;

public class GameLoop extends OGameLoop {

    GameStateManager gsm;
    public static Assets assets = new Assets();

    public GameLoop(int fwidth, int fheight) {
        super(fwidth, fheight);
    }

    @Override
    public void init() {
        assets.init();
        gsm = new GameStateManager();
        gsm.init();
        super.init();
    }

    @Override
    public void tick(double deltaTime) {
        gsm.tick(deltaTime);
    }

    public void render() {
        super.render();
        gsm.render(graphics2D);
        clear();
    }

    @Override
    public void clear() {
        super.clear();
    }
}
