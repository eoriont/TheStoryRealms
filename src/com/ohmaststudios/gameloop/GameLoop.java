package com.ohmaststudios.gameloop;

import com.ohmaststudios.engine.OGameLoop;
import com.ohmaststudios.engine.Vector2F;
import com.ohmaststudios.gamestate.GameStateManager;
import com.ohmaststudios.main.Assets;

public class GameLoop extends OGameLoop {

    GameStateManager gsm;
    public static Assets assets = new Assets();
    public static Vector2F map = new Vector2F();

    public GameLoop(int fwidth, int fheight) {
        super(fwidth, fheight);
    }

    @Override
    public void init() {
        assets.init();
        Vector2F.setWorldVariables(map.xpos, map.ypos);
        gsm = new GameStateManager();
        gsm.init();
        super.init();
    }

    @Override
    public void tick(double deltaTime) {
        Vector2F.setWorldVariables(map.xpos, map.ypos);
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
